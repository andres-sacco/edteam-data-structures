package org.edteam.structure.implementation.fixed;

import org.edteam.structure.exception.ElementNotFoundADTException;
import org.edteam.structure.exception.EmptyADTException;
import org.edteam.structure.exception.FullADTException;
import org.edteam.structure.definition.MultipleDictionaryADT;
import org.edteam.structure.definition.SetADT;

public class StaticMultipleDictionaryADT implements MultipleDictionaryADT {

    private static final int MAX = 1000;

    private final int[][] values;
    private int count;

    public StaticMultipleDictionaryADT() {
        this.values = new int[MAX][MAX];
        this.count = 0;
    }

    @Override
    public void remove(int key, int value) {
        if (this.count == 0) {
            throw new EmptyADTException("No se puede eliminar un par de un diccionario vacío");
        }

        int keyIndex = findKeyIndex(key);
        if (keyIndex == -1) {
            throw new ElementNotFoundADTException("No existe el par clave-valor.");
        }

        if (!removeValueAtKey(keyIndex, value)) {
            throw new ElementNotFoundADTException("No existe par clave-valor. La clave sin embargo, existe.");
        }

        if (this.values[keyIndex][1] == 0) {
            removeKey(keyIndex);
        }
    }

    @Override
    public void add(int key, int value) {
        if (this.count == 0) {
            this.values[0][0] = key;
            this.values[0][1] = 1;
            this.values[0][2] = value;
            this.count++;
            return;
        }

        for (int i = 0; i < this.count; i++) {
            if (this.values[i][0] == key) {
                int column = this.values[i][1];
                if (column == MAX) {
                    throw new FullADTException("No hay espacio disponible para un valor nuevo");
                }
                this.values[i][column + 2] = value;
                this.values[i][1]++;
                return;
            }
        }

        if (this.count == MAX) {
            throw new FullADTException("No hay espacio disponible para una clave nueva");
        }

        this.values[this.count][0] = key;
        this.values[this.count][1] = 1;
        this.values[this.count][2] = value;
        this.count++;
    }

    @Override
    public void remove(int key) {
        if (this.count == 0) {
            throw new EmptyADTException("No se puede eliminar un par de un diccionario vacío");
        }

        int keyIndex = findKeyIndex(key);
        if (keyIndex == -1) {
            throw new ElementNotFoundADTException("No existe el par clave-valor.");
        }
        removeKey(keyIndex);
    }

    @Override
    public int[] get(int key) {
        if (this.count == 0) {
            throw new EmptyADTException("El diccionario está vacío.");
        }

        for (int i = 0; i < this.count; i++) {
            if (this.values[i][0] == key) {
                int valueCount = this.values[i][1];

                if (valueCount == 0) {
                    return new int[0];
                }

                int[] result = new int[valueCount];
                System.arraycopy(this.values[i], 2, result, 0, valueCount);
                return result;
            }
        }

        throw new ElementNotFoundADTException("La clave " + key + " no tiene valores asociados en el diccionario.");
    }

    @Override
    public SetADT getKeys() {
        if (this.count == 0) {
            return new StaticSetADT();
        }
        SetADT result = new StaticSetADT();
        for (int i = 0; i < count; i++) {
            result.add(this.values[i][0]);
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    private int findKeyIndex(int key) {
        for (int i = 0; i < this.count; i++) {
            if (this.values[i][0] == key) {
                return i;
            }
        }
        return -1;
    }

    // Elimina el valor de la clave en un índice dado
    private boolean removeValueAtKey(int keyIndex, int value) {
        int valueCount = this.values[keyIndex][1];
        for (int j = 2; j < valueCount; j++) {
            if (this.values[keyIndex][j] == value) {
                // Desplazar valores para llenar el hueco
                System.arraycopy(this.values[keyIndex], j + 1, this.values[keyIndex], j, valueCount - j - 1);
                this.values[keyIndex][1]--;
                return true;
            }
        }
        return false;
    }

    // Elimina una clave moviendo la última clave al lugar actual
    private void removeKey(int keyIndex) {
        this.values[keyIndex][0] = this.values[this.count - 1][0];
        this.values[keyIndex][1] = this.values[this.count - 1][1];
        this.count--;
    }
}
