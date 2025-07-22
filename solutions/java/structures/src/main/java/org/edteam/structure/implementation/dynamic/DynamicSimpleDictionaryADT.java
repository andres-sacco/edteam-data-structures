package org.edteam.structure.implementation.dynamic;

import org.edteam.structure.exception.ElementNotFoundADTException;
import org.edteam.structure.exception.EmptyADTException;
import org.edteam.structure.definition.SetADT;
import org.edteam.structure.definition.SimpleDictionaryADT;
import org.edteam.structure.implementation.common.KeyNode;
import org.edteam.structure.implementation.common.ValueNode;

public class DynamicSimpleDictionaryADT implements SimpleDictionaryADT {

    private KeyNode first;

    @Override
    public void add(int key, int value) {
        if (this.first == null) {
            this.first = new KeyNode(key, new ValueNode(value, null), null);
        } else {
            KeyNode current = this.first;
            while (current.getNext() != null) {
                if (current.getKey() == key) {
                    if (current.getValueNode().getValue() == value) {
                        return;
                    }
                    throw new RuntimeException("Ya existe una par clave-valor diferente");
                }
                current = current.getNext();
            }

            current.setNext(new KeyNode(key, new ValueNode(value, null), null));
        }
    }

    @Override
    public void remove(int key) {
        if (this.first == null) {
            throw new EmptyADTException("No se puede eliminar un par de un diccionario vacío");
        }

        if (this.first.getNext() == null) {
            if (this.first.getKey() == key) {
                this.first = null;
            }
            return;
        }

        KeyNode previous = this.first;
        KeyNode current = this.first.getNext();
        while (current.getNext() != null) {
            if (current.getKey() == key) {
                previous.setNext(current.getNext());
            }
            previous = current;
            current = current.getNext();
        }

        if (current.getKey() == key) {
            previous.setNext(current.getNext());
        }

        throw new ElementNotFoundADTException("No existe el par clave-valor.");
    }

    @Override
    public int get(int key) {
        if (this.first == null) {
            throw new EmptyADTException("No se puede obtener el valor de un diccionario vacio");
        }

        KeyNode current = this.first;

        while (current != null) {
            if (current.getKey() == key) {
                return current.getValueNode().getValue();
            }
            current = current.getNext();
        }

        throw new ElementNotFoundADTException("No se puede obtener el valor de una clave que no existe");
    }

    @Override
    public SetADT getKeys() {
        SetADT result = new DynamicSetADT();
        if (this.first == null) {
            return result;
        }

        KeyNode current = this.first;
        while (current != null) {
            result.add(current.getKey());
            current = current.getNext();
        }

        return result;
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }
}
