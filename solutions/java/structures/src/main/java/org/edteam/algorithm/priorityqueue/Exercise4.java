package org.edteam.algorithm.priorityqueue;

import org.edteam.structure.definition.PriorityQueueADT;
import org.edteam.structure.implementation.dynamic.DynamicPriorityQueueADT;

public class Exercise4 {

    public static PriorityQueueADT filtrarPorPrioridad(PriorityQueueADT original, int prioridadMinima) {
        PriorityQueueADT resultado = new DynamicPriorityQueueADT();
        PriorityQueueADT copia = copiarCola(original);

        while (!copia.isEmpty()) {
            int valor = copia.getElement();
            int prioridad = copia.getPriority();

            if (prioridad >= prioridadMinima) {
                resultado.add(valor, prioridad);
            }

            copia.remove();
        }

        return resultado;
    }

    // Copia auxiliar para no modificar la original
    private static PriorityQueueADT copiarCola(PriorityQueueADT original) {
        PriorityQueueADT copia = new DynamicPriorityQueueADT();
        PriorityQueueADT aux = new DynamicPriorityQueueADT();

        while (!original.isEmpty()) {
            int valor = original.getElement();
            int prioridad = original.getPriority();
            copia.add(valor, prioridad);
            aux.add(valor, prioridad);
            original.remove();
        }

        // Restaurar original
        while (!aux.isEmpty()) {
            original.add(aux.getElement(), aux.getPriority());
            aux.remove();
        }

        return copia;
    }

    public static void main(String[] args) {
        PriorityQueueADT cola = new DynamicPriorityQueueADT();
        cola.add(10, 2);
        cola.add(20, 5);
        cola.add(30, 1);
        cola.add(40, 4);

        int prioridadMinima = 3;
        PriorityQueueADT resultado = filtrarPorPrioridad(cola, prioridadMinima);

        System.out.println("Elementos con prioridad >= " + prioridadMinima + ":");
        while (!resultado.isEmpty()) {
            System.out.println("Valor: " + resultado.getElement() + ", Prioridad: " + resultado.getPriority());
            resultado.remove();
        }
    }
}
