package org.edteam.structure.implementation.fixed;

import org.edteam.structure.exception.EmptyADTException;
import org.edteam.structure.exception.FullADTException;
import org.edteam.structure.definition.StackADT;

// Esta clase representa la implementacion estatica del TDA Pila.
public class StaticStackADT implements StackADT {

    private static final int MAX = 1000;

    private final int[] array;
    private int count;

    public StaticStackADT() {
        this.array = new int[MAX];
        this.count = 0;
    }

    @Override
    public int getElement() {
        if (isEmpty()) {
            throw new EmptyADTException("No se puede obtener el tope una pila vacia.");
        }
        return array[this.count - 1];
    }

    @Override
    public void remove() {
        if (isEmpty()) {
            throw new EmptyADTException("No se puede obtener eliminar elementos de una pila vacia.");
        }
        count--;
    }

    @Override
    public void add(int value) {
        if (this.count == MAX) {
            throw new FullADTException("La pila esta llena.");
        }
        this.array[this.count] = value;
        this.count++;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }
}
