package org.edteam.structure.implementation.dynamic;

import org.edteam.structure.exception.EmptyADTException;
import org.edteam.structure.exception.GenericADTException;
import org.edteam.structure.definition.LinkedListADT;
import org.edteam.structure.implementation.common.Node;

public class DynamicLinkedListADT implements LinkedListADT {

    private Node head;
    private int count;

    @Override
    public void add(int value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        count++;
    }

    @Override
    public void insert(int index, int value) {
        if (index < 0 || index >= count) {
            throw new GenericADTException("Índice fuera de rango.");
        }
        Node newNode = new Node(value, null);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        count++;
    }

    @Override
    public void remove(int index) {
        if (this.isEmpty()) {
            throw new EmptyADTException("No se puede eliminar en una lista vacia");
        } else if (index < 0 || index >= count) {
            throw new GenericADTException("Índice fuera de rango.");
        }

        if (index == 0) {
            head = head.getNext();
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            current.setNext(current.getNext().getNext());
        }
        count--;
    }

    @Override
    public int get(int index) {
        if (this.isEmpty()) {
            throw new EmptyADTException("No se puede eliminar en una lista vacia");
        } else if (index < 0 || index >= count) {
            throw new GenericADTException("Índice fuera de rango.");
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }
}
