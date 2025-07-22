package org.edteam.algorithm.stack;

import org.edteam.structure.definition.StackADT;
import org.edteam.structure.implementation.dynamic.DynamicStackADT;
import org.edteam.util.StackADTUtil;

public class Exercise2 {
    public static void main(String[] args) {
        StackADT pila = new DynamicStackADT();

        // Inicializar la pila con algunos valores
        pila.add(10);
        pila.add(20);
        pila.add(30);
        pila.add(40); // Este será el tope (primer elemento)

        // Mostrar la pila original
        System.out.println("Pila original:");
        StackADTUtil.print(pila);

        // Resolver el ejercicio
        multiply(pila, 3);

        // Mostrar la pila modificada
        System.out.println("Pila modificada:");
        StackADTUtil.print(pila);
    }

    public static void multiply(StackADT stack, int factor) {
        StackADT aux = new DynamicStackADT();

        // Paso 1: Pasar todos los elementos a la pila auxiliar multiplicando
        while (!stack.isEmpty()) {
            int value = stack.getElement();
            stack.remove();
            aux.add(value * factor);
        }

        // Paso 2: Restaurar el orden original pasando de nuevo a la pila original
        StackADT temp = new DynamicStackADT();
        while (!aux.isEmpty()) {
            temp.add(aux.getElement());
            aux.remove();
        }
        while (!temp.isEmpty()) {
            stack.add(temp.getElement());
            temp.remove();
        }
    }
}
