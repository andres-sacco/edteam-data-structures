package org.edteam.algorithm.others;

import org.edteam.structure.definition.LinkedListADT;
import org.edteam.structure.definition.QueueADT;
import org.edteam.structure.definition.StackADT;
import org.edteam.structure.implementation.dynamic.DynamicLinkedListADT;
import org.edteam.structure.implementation.dynamic.DynamicQueueADT;
import org.edteam.structure.implementation.dynamic.DynamicStackADT;

public class Exercise1 {


    /**
     * Inserta un valor en la lista enlazada de forma ordenada ascendente.
     */
    private static void insertOrdered(LinkedListADT list, int value) {
        if (list.isEmpty()) {
            list.add(value);
            return;
        }
        int i = 0;
        while (i < list.size() && list.get(i) < value) {
            i++;
        }
        list.insert(i, value);
    }

    public static QueueADT combineSorted(StackADT stack, QueueADT queue,
                                         LinkedListADT tempList,
                                         StackADT tempStack,
                                         QueueADT tempQueue,
                                         QueueADT resultQueue) {
        // Extraer elementos de pila y guardarlos
        while (!stack.isEmpty()) {
            int val = stack.getElement();
            stack.remove();
            insertOrdered(tempList, val);
            tempStack.add(val);
        }
        // Restaurar pila
        while (!tempStack.isEmpty()) {
            int val = tempStack.getElement();
            tempStack.remove();
            stack.add(val);
        }

        // Extraer elementos de cola y guardarlos
        while (!queue.isEmpty()) {
            int val = queue.getElement();
            queue.remove();
            insertOrdered(tempList, val);
            tempQueue.add(val);
        }
        // Restaurar cola
        while (!tempQueue.isEmpty()) {
            int val = tempQueue.getElement();
            tempQueue.remove();
            queue.add(val);
        }

        // Cargar nueva cola con valores ordenados
        for (int i = 0; i < tempList.size(); i++) {
            resultQueue.add(tempList.get(i));
        }

        return resultQueue;
    }


    public static void main(String[] args) {
        // Crear instancias de las estructuras
        StackADT stack = new DynamicStackADT();
        QueueADT queue = new DynamicQueueADT();
        LinkedListADT tempList = new DynamicLinkedListADT();
        StackADT tempStack = new DynamicStackADT();
        QueueADT tempQueue = new DynamicQueueADT();
        QueueADT resultQueue = new DynamicQueueADT();

        // Agregar datos a pila
        stack.add(5);
        stack.add(1);
        stack.add(9);

        // Agregar datos a cola
        queue.add(7);
        queue.add(2);
        queue.add(3);

        // Llamar a la función para combinar y ordenar
        combineSorted(stack, queue, tempList, tempStack, tempQueue, resultQueue);

        // Mostrar resultado
        System.out.println("Cola resultante ordenada:");
        while (!resultQueue.isEmpty()) {
            System.out.print(resultQueue.getElement() + " ");
            resultQueue.remove();
        }
        System.out.println();

        // Verificar que pila y cola originales estén intactas
        System.out.println("Pila original:");
        while (!stack.isEmpty()) {
            System.out.print(stack.getElement() + " ");
            stack.remove();
        }
        System.out.println();

        System.out.println("Cola original:");
        while (!queue.isEmpty()) {
            System.out.print(queue.getElement() + " ");
            queue.remove();
        }
        System.out.println();
    }
}
