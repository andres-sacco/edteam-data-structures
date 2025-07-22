package org.edteam.structure.implementation.dynamic;

import org.edteam.structure.exception.EmptyADTException;
import org.edteam.structure.definition.QueueADT;
import org.edteam.structure.implementation.common.Node;

// Esta clase representa la implementacion dinamica del TDA Cola.
public class DynamicQueueADT implements QueueADT {

    private Node first;

    @Override
    public int getElement() {
        if (this.isEmpty()) {
            throw new EmptyADTException("No se puede desacolar una cola vacia.");
        }
        return this.first.getValue();

    }

    @Override
    public void add(int value) {
        if (this.isEmpty()) {
            this.first = new Node(value, null);
            return;
        }
        Node candidate = this.first;
        while (candidate.getNext() != null) {
            candidate = candidate.getNext();
        }

        candidate.setNext(new Node(value, null));
    }

    @Override
    public void remove() {
        if (this.isEmpty()) {
            throw new EmptyADTException("No se puede desacolar una cola vacia");
        }
        this.first = this.first.getNext();
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }
}
