package org.edteam.algorithm.set;

import org.edteam.structure.definition.SetADT;
import org.edteam.structure.implementation.dynamic.DynamicSetADT;

public class Exercise3 {

    public static SetADT filterGreaterThan(SetADT originalSet, int minValue) {
        SetADT result = new DynamicSetADT();
        SetADT temp = new DynamicSetADT();

        // Copiar todos los elementos a un conjunto auxiliar para no modificar el original
        while (!originalSet.isEmpty()) {
            int element = originalSet.choose();
            temp.add(element);
            if (element > minValue) {
                result.add(element);
            }
            originalSet.remove(element);
        }

        // Restaurar el conjunto original
        while (!temp.isEmpty()) {
            int element = temp.choose();
            originalSet.add(element);
            temp.remove(element);
        }

        return result;
    }

    public static void main(String[] args) {
        SetADT set = new DynamicSetADT();
        set.add(10);
        set.add(5);
        set.add(20);
        set.add(15);

        int threshold = 10;
        SetADT result = filterGreaterThan(set, threshold);

        System.out.println("Elementos mayores a " + threshold + ":");
        while (!result.isEmpty()) {
            int value = result.choose();
            System.out.println(value);
            result.remove(value);
        }

        System.out.println("\nConjunto original restaurado:");
        while (!set.isEmpty()) {
            int value = set.choose();
            System.out.println(value);
            set.remove(value);
        }
    }


}
