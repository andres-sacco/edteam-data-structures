package org.edteam.structure.implementation.fixed;

import org.edteam.structure.exception.EmptyADTException;
import org.edteam.structure.exception.FullADTException;
import org.edteam.structure.definition.QueueADT;

public class StaticQueueADT implements QueueADT {
    private static final int MAX = 1000;

    private final int[] array;
    private int count;

    public StaticQueueADT() {
        this.array = new int[MAX];
        this.count = 0;
    }

    @Override
    public int getElement() {
        if (isEmpty()) {
            throw new EmptyADTException("No se puede obtener el primero de una cola vacia.");
        }
        return array[0];
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new EmptyADTException("No se puede eliminar elementos de una cola vacia.");
        }
        for (int i = 0; i < count - 1; i++) {
            this.array[i] = this.array[i + 1];
        }
        count--;
    }

    @Override
    public void add(int value) {
        if (this.count == MAX) {
            throw new FullADTException("La cola esta llena.");
        }
        this.array[this.count] = value;
        this.count++;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }
}
