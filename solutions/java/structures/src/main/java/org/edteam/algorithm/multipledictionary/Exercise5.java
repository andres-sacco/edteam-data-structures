package org.edteam.algorithm.multipledictionary;

import org.edteam.structure.definition.MultipleDictionaryADT;
import org.edteam.structure.definition.SetADT;
import org.edteam.structure.exception.ElementNotFoundADTException;
import org.edteam.structure.implementation.dynamic.DynamicMultipleDictionaryADT;
import org.edteam.structure.implementation.dynamic.DynamicSetADT;
import org.edteam.util.MultipleDictionaryADTUtil;

public class Exercise5 {

    public static MultipleDictionaryADT sumarDiccionarios(MultipleDictionaryADT d1, MultipleDictionaryADT d2) {
        MultipleDictionaryADT resultado = new DynamicMultipleDictionaryADT();
        SetADT claves = new DynamicSetADT();

        // Unir claves de ambos diccionarios en un solo conjunto
        agregarClaves(claves, d1.getKeys());
        agregarClaves(claves, d2.getKeys());

        // Para cada clave, sumar los valores y agregar al resultado
        while (!claves.isEmpty()) {
            int clave = claves.choose();
            claves.remove(clave);

            int suma = 0;
            if (!d1.isEmpty()) {
                try {
                    for (int valor : d1.get(clave)) {
                        suma += valor;
                    }
                } catch (ElementNotFoundADTException ignored) {}
            }

            if (!d2.isEmpty()) {
                try {
                    for (int valor : d2.get(clave)) {
                        suma += valor;
                    }
                } catch (ElementNotFoundADTException ignored) {}
            }

            resultado.add(clave, suma);
        }

        return resultado;
    }

    private static void agregarClaves(SetADT destino, SetADT origen) {
        while (!origen.isEmpty()) {
            int clave = origen.choose();
            origen.remove(clave);
            destino.add(clave);
        }
    }

    public static void main(String[] args) {
        MultipleDictionaryADT d1 = new DynamicMultipleDictionaryADT();
        d1.add(1, 10);
        d1.add(1, 20);
        d1.add(2, 5);

        MultipleDictionaryADT d2 = new DynamicMultipleDictionaryADT();
        d2.add(1, 5);
        d2.add(3, 100);

        MultipleDictionaryADT suma = sumarDiccionarios(d1, d2);
        MultipleDictionaryADTUtil.print(suma);

    }

}
