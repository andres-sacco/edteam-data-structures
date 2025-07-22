package org.edteam.structure.implementation.dynamic;

import org.edteam.structure.exception.EmptyADTException;
import org.edteam.structure.definition.StackADT;
import org.edteam.structure.implementation.common.Node;

// Esta clase representa la implementacion dinamica del TDA Pila.
public class DynamicStackADT implements StackADT {

    private Node first;

    @Override
    public int getElement() {
        if (this.isEmpty()) {
            throw new EmptyADTException("No se puede desapilar una pila vacia.");
        } else {
            return this.first.getValue();
        }
    }

    @Override
    public void add(int value) {
        this.first = new Node(value, this.first);
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new EmptyADTException("No se puede desapilar una pila vacia.");
        } else {
            this.first = this.first.getNext();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }
}
