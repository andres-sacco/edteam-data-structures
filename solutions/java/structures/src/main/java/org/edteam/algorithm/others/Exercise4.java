package org.edteam.algorithm.others;

import org.edteam.structure.definition.MultipleDictionaryADT;
import org.edteam.structure.definition.SetADT;
import org.edteam.structure.definition.SimpleDictionaryADT;
import org.edteam.structure.implementation.dynamic.DynamicMultipleDictionaryADT;
import org.edteam.structure.implementation.dynamic.DynamicSimpleDictionaryADT;

public class Exercise4 {

    public static MultipleDictionaryADT invertSimpleToMultiple(SimpleDictionaryADT simple) {
        MultipleDictionaryADT multiple = new DynamicMultipleDictionaryADT();
        SetADT keys = simple.getKeys();

        while (!keys.isEmpty()) {
            int key = keys.choose();
            keys.remove(key);

            int value = simple.get(key);
            multiple.add(value, key); // Invertimos: valor → clave
        }

        return multiple;
    }

    public static void main(String[] args) {
        SimpleDictionaryADT simple = new DynamicSimpleDictionaryADT();
        simple.add(1, 10);
        simple.add(2, 20);
        simple.add(3, 10);
        simple.add(4, 30);

        MultipleDictionaryADT multiple = invertSimpleToMultiple(simple);

        SetADT keys = multiple.getKeys();
        while (!keys.isEmpty()) {
            int value = keys.choose();
            keys.remove(value);

            int[] originalKeys = multiple.get(value);
            System.out.print(value + " -> ");
            for (int k : originalKeys) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }
}
