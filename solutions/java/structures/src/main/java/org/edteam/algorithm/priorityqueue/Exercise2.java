package org.edteam.algorithm.priorityqueue;

import org.edteam.structure.definition.PriorityQueueADT;
import org.edteam.structure.implementation.dynamic.DynamicPriorityQueueADT;

public class Exercise2 {

    public static void eliminarPorPrioridad(PriorityQueueADT cola, int prioridadObjetivo) {
        PriorityQueueADT aux = new DynamicPriorityQueueADT();

        while (!cola.isEmpty()) {
            int valor = cola.getElement();
            int prioridad = cola.getPriority();
            cola.remove();
            if (prioridad != prioridadObjetivo) {
                aux.add(valor, prioridad);
            }
        }

        // Restaurar los elementos a la cola original
        while (!aux.isEmpty()) {
            cola.add(aux.getElement(), aux.getPriority());
            aux.remove();
        }
    }

    public static void main(String[] args) {
        PriorityQueueADT cola = new DynamicPriorityQueueADT();
        cola.add(10, 2);
        cola.add(20, 3);
        cola.add(30, 2);
        cola.add(40, 1);

        eliminarPorPrioridad(cola, 2); // Elimina 10 y 30

        while (!cola.isEmpty()) {
            System.out.println("Valor: " + cola.getElement() + ", Prioridad: " + cola.getPriority());
            cola.remove();
        }
    }

}
