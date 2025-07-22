package org.edteam.algorithm.stack;

import org.edteam.structure.definition.StackADT;
import org.edteam.structure.implementation.dynamic.DynamicStackADT;

public class Exercise4 {


    public static int count(StackADT stack) {
        StackADT aux = new DynamicStackADT();
        int count = 0;

        // Pasamos los elementos a la pila auxiliar mientras contamos
        while (!stack.isEmpty()) {
            aux.add(stack.getElement());
            stack.remove();
            count++;
        }

        // Restauramos la pila original
        while (!aux.isEmpty()) {
            stack.add(aux.getElement());
            aux.remove();
        }

        return count;
    }

    public static void main(String[] args) {
        StackADT stack = new DynamicStackADT();
        stack.add(10);
        stack.add(20);
        stack.add(30); // Pila: [30, 20, 10]

        int total = count(stack);
        System.out.println("Cantidad de elementos: " + total); // → 3
    }
}
