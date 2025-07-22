package org.edteam.algorithm.queue;

import org.edteam.structure.definition.QueueADT;
import org.edteam.structure.implementation.dynamic.DynamicQueueADT;

public class Exercise4 {

    public static QueueADT elementosEnComun(DynamicQueueADT cola1, DynamicQueueADT cola2) {
        QueueADT copia1 = copiarCola(cola1);
        QueueADT copia2 = copiarCola(cola2);
        QueueADT resultado = new DynamicQueueADT();

        while (!copia1.isEmpty()) {
            int actual = copia1.getElement();
            copia1.remove();

            DynamicQueueADT temp = new DynamicQueueADT();
            boolean encontrado = false;

            while (!copia2.isEmpty()) {
                int valor = copia2.getElement();
                copia2.remove();
                if (valor == actual && !encontrado) {
                    resultado.add(valor);
                    encontrado = true;
                }
                temp.add(valor);
            }

            copia2 = temp;
        }

        return resultado;
    }

    public static DynamicQueueADT copiarCola(DynamicQueueADT original) {
        DynamicQueueADT copia = new DynamicQueueADT();
        DynamicQueueADT temp = new DynamicQueueADT();

        while (!original.isEmpty()) {
            int val = original.getElement();
            original.remove();
            copia.add(val);
            temp.add(val);
        }

        while (!temp.isEmpty()) {
            original.add(temp.getElement());
            temp.remove();
        }

        return copia;
    }

    public static void main(String[] args) {
        DynamicQueueADT cola1 = new DynamicQueueADT();
        cola1.add(1);
        cola1.add(2);
        cola1.add(3);
        cola1.add(4);

        DynamicQueueADT cola2 = new DynamicQueueADT();
        cola2.add(3);
        cola2.add(4);
        cola2.add(5);
        cola2.add(6);

        QueueADT comun = elementosEnComun(cola1, cola2);

        System.out.print("Elementos en común: ");
        while (!comun.isEmpty()) {
            System.out.print(comun.getElement() + " ");
            comun.remove();
        }
    }
}
