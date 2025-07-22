package org.edteam.algorithm.linkedlist;

import org.edteam.structure.definition.LinkedListADT;
import org.edteam.structure.implementation.dynamic.DynamicLinkedListADT;
import org.edteam.util.LinkedListADTUtil;

public class Exercise2 {


    public static void main(String[] args) {
        LinkedListADT adt = new DynamicLinkedListADT();
        adt.add(1);
        adt.add(2);
        adt.add(4);
        adt.add(3);
        adt.add(6);

        removeLast(adt, 3);
        LinkedListADTUtil.print(adt);
    }

    public static void removeLast(LinkedListADT list, int n) {
        int totalSize = list.size();

        if (n >= totalSize) {
            // Elimina todos los elementos
            for (int i = totalSize - 1; i >= 0; i--) {
                list.remove(i);
            }
        } else {
            // Elimina los últimos n elementos
            for (int i = 0; i < n; i++) {
                list.remove(list.size() - 1); // siempre eliminar el último
            }
        }
    }
}
