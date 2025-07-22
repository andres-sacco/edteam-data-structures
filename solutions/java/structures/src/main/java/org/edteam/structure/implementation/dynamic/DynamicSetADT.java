package org.edteam.structure.implementation.dynamic;

import org.edteam.structure.exception.EmptyADTException;
import org.edteam.structure.exception.GenericADTException;
import org.edteam.structure.definition.SetADT;
import org.edteam.structure.implementation.common.Node;

import java.util.Random;

// Esta clase representa la implementacion dinamica del TDA Conjunto.
public class DynamicSetADT implements SetADT {

    private Node first;
    private int count;

    public DynamicSetADT() {
        this.first = null;
        this.count = 0;
    }

    @Override
    public boolean exist(int value) {
        Node current = first;

        while (current != null) {
            if (current.getValue() == value) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    @Override
    public int choose() {
        if (isEmpty()) {
            throw new EmptyADTException("No se puede elegir un elemento de un conjunto vacío.");
        }

        Random random = new Random();
        int i = random.nextInt(count);
        int countAux = 0;
        Node current = this.first;

        while (current != null) {
            if (countAux == i) {
                return current.getValue();
            }
            countAux++;
            current = current.getNext();
        }

        throw new GenericADTException("No se pudo elegir un elemento del conjunto.");
    }

    @Override
    public void add(int value) {
        if (this.isEmpty()) {
            this.first = new Node(value, null);
            this.count++;
            return;
        }

        Node current = this.first;
        while (current.getNext() != null) {
            if (current.getValue() == value) {
                return;
            }
            current = current.getNext();
        }

        if (current.getValue() == value) {
            return;
        }

        current.setNext(new Node(value, null));
        this.count++;
    }

    @Override
    public void remove(int element) {
        if (this.isEmpty()) {
            return;
        }
        if (this.first.getNext() == null) {
            if (this.first.getValue() == element) {
                this.first = null;
                this.count--;
            }
            return;
        }

        if (this.first.getValue() == element) {
            this.first = this.first.getNext();
            this.count--;
            return;
        }

        Node current = this.first.getNext();
        Node previous = this.first;
        while (current.getNext() != null) {
            if (current.getValue() == element) {
                previous.setNext(current.getNext());
                this.count--;
                return;
            }
            previous = current;
            current = current.getNext();
        }

        if (current.getValue() == element) {
            previous.setNext(current.getNext());
            this.count--;
        }
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }
}
