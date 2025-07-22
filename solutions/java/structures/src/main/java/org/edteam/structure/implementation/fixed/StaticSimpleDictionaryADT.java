package org.edteam.structure.implementation.fixed;

import org.edteam.structure.exception.ElementNotFoundADTException;
import org.edteam.structure.exception.EmptyADTException;
import org.edteam.structure.exception.FullADTException;
import org.edteam.structure.definition.SetADT;
import org.edteam.structure.definition.SimpleDictionaryADT;

public class StaticSimpleDictionaryADT implements SimpleDictionaryADT {

    private static final int MAX = 1000;

    private final int[] keys;
    private final int[] values;
    private int count;

    public StaticSimpleDictionaryADT() {
        this.keys = new int[MAX];
        this.values = new int[MAX];
        this.count = 0;
    }

    @Override
    public void add(int key, int value) {
        for (int i = 0; i < count; i++) {
            if (keys[i] == key) {
                values[i] = value;
                return;
            }
        }

        if (this.count >= MAX) {
            throw new FullADTException("No hay espacio disponible para una clave nueva.");
        }

        keys[count] = key;
        values[count] = value;
        count++;
    }

    @Override
    public void remove(int key) {
        if (isEmpty()) {
            throw new EmptyADTException("No se puede eliminar un par de un diccionario vacío.");
        }

        for (int i = 0; i < this.count; i++) {
            if (this.keys[i] == key) {
                for (int j = i; j < count - 1; j++) {
                    keys[j] = keys[j + 1];
                    values[j] = values[j + 1];
                }
                count--;
                return;
            }
        }

        throw new ElementNotFoundADTException("No existe el par clave-valor.");
    }

    @Override
    public int get(int key) {
        if (isEmpty()) {
            throw new EmptyADTException("No se puede obtener el valor de un diccionario vacio.");
        }
        for (int i = 0; i < count; i++) {
            if (this.keys[i] == key) {
                return this.values[i];
            }
        }
        throw new ElementNotFoundADTException("No se puede obtener el valor de una clave que no existe.");
    }

    @Override
    public SetADT getKeys() {
        if (isEmpty()) {
            return new StaticSetADT();
        }
        SetADT result = new StaticSetADT();
        for (int i = 0; i < count; i++) {
            result.add(this.keys[i]);
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }
}
