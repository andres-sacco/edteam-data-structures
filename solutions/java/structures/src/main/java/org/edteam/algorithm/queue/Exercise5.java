package org.edteam.algorithm.queue;

import org.edteam.structure.definition.QueueADT;
import org.edteam.structure.implementation.dynamic.DynamicQueueADT;

public class Exercise5 {


    public static boolean esCapicua(QueueADT queue) {
        // Paso 1: Copiamos los elementos a una lista para poder recorrerlos en ambos sentidos
        java.util.List<Integer> elementos = new java.util.ArrayList<>();

        QueueADT auxQueue = new DynamicQueueADT();

        // Paso 2: Transferimos los elementos a una lista y también a una cola auxiliar
        while (!queue.isEmpty()) {
            int valor = queue.getElement();
            elementos.add(valor);
            auxQueue.add(valor);
            queue.remove();
        }

        // Paso 3: Restauramos la cola original
        for (int valor : elementos) {
            queue.add(valor);
        }

        // Paso 4: Verificamos si es capicúa
        int i = 0;
        int j = elementos.size() - 1;
        while (i < j) {
            if (!elementos.get(i).equals(elementos.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        DynamicQueueADT queue = new DynamicQueueADT();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(2);
        queue.add(1);

        boolean resultado = esCapicua(queue);
        System.out.println("¿La cola es capicúa? " + resultado);  // Debería imprimir true
    }
}
