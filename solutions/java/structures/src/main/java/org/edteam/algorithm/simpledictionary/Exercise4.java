package org.edteam.algorithm.simpledictionary;

import org.edteam.structure.definition.SetADT;
import org.edteam.structure.definition.SimpleDictionaryADT;
import org.edteam.structure.implementation.dynamic.DynamicSimpleDictionaryADT;
import org.edteam.util.SimpleDictionaryADTUtil;

public class Exercise4 {


    public static SimpleDictionaryADT filtrarPorUmbral(SimpleDictionaryADT original, int umbral) {
        SimpleDictionaryADT resultado = new DynamicSimpleDictionaryADT();

        SetADT claves = original.getKeys();

        while (!claves.isEmpty()) {
            int clave = claves.choose();
            claves.remove(clave);

            int valor = original.get(clave);

            if (valor > umbral) {
                resultado.add(clave, valor);
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        SimpleDictionaryADT dict = new DynamicSimpleDictionaryADT();

        dict.add(1, 10);
        dict.add(2, 5);
        dict.add(3, 20);
        dict.add(4, 3);

        SimpleDictionaryADT filteredDict = filtrarPorUmbral(dict, 6);

        SimpleDictionaryADTUtil.print(filteredDict);
    }

}
