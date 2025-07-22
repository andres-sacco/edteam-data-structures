package org.edteam.algorithm.linkedlist;

import org.edteam.structure.definition.LinkedListADT;
import org.edteam.structure.implementation.dynamic.DynamicLinkedListADT;
import org.edteam.util.LinkedListADTUtil;

public class Exercise5 {

    public static void main(String[] args) {
        LinkedListADT adt = new DynamicLinkedListADT();
        adt.add(1);
        adt.add(2);
        adt.add(4);
        adt.add(3);
        adt.add(6);

        LinkedListADT result = reverse(adt);
        LinkedListADTUtil.print(result);
    }

    public static LinkedListADT reverse(LinkedListADT original) {
        LinkedListADT reversed = new DynamicLinkedListADT(); // Suponiendo que esta es tu implementación concreta

        for (int i = original.size() - 1; i >= 0; i--) {
            reversed.add(original.get(i));
        }

        return reversed;
    }
}
