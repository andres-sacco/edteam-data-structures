package org.edteam.algorithm.multipledictionary;

import org.edteam.structure.definition.MultipleDictionaryADT;
import org.edteam.structure.definition.SetADT;
import org.edteam.structure.implementation.dynamic.DynamicMultipleDictionaryADT;
import org.edteam.util.MultipleDictionaryADTUtil;

public class Exercise3 {

    public static MultipleDictionaryADT filtrarPorRango(MultipleDictionaryADT diccionario, int minimo, int maximo) {
        MultipleDictionaryADT resultado = new DynamicMultipleDictionaryADT();

        SetADT claves = diccionario.getKeys();
        while (!claves.isEmpty()) {
            int clave = claves.choose();
            claves.remove(clave);

            int[] valores = diccionario.get(clave);
            for (int valor : valores) {
                if (valor >= minimo && valor <= maximo) {
                    resultado.add(clave, valor);
                }
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        MultipleDictionaryADT diccionario = new DynamicMultipleDictionaryADT();
        diccionario.add(1, 10);
        diccionario.add(1, 20);
        diccionario.add(2, 30);
        diccionario.add(3, 5);
        diccionario.add(3, 25);

        MultipleDictionaryADT filtrado = filtrarPorRango(diccionario, 10, 25);
        MultipleDictionaryADTUtil.print(filtrado);
        // El diccionario `filtrado` ahora contiene:
        // clave 1 → [10, 20]
        // clave 3 → [25]

    }

}
