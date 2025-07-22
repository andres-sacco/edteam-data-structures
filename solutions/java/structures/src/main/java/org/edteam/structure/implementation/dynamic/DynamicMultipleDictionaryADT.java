package org.edteam.structure.implementation.dynamic;

import org.edteam.structure.exception.ElementNotFoundADTException;
import org.edteam.structure.exception.EmptyADTException;
import org.edteam.structure.definition.MultipleDictionaryADT;
import org.edteam.structure.definition.SetADT;
import org.edteam.structure.implementation.common.KeyNode;
import org.edteam.structure.implementation.common.ValueNode;

public class DynamicMultipleDictionaryADT implements MultipleDictionaryADT {
    private KeyNode first;

    @Override
    public void add(int key, int value) {
        if (isEmpty()) {
            this.first = new KeyNode(key, new ValueNode(value, null), null);
            return;
        }

        KeyNode current = this.first;
        while (current.getNext() != null) {
            if (current.getKey() == key) {
                ValueNode currentValue = current.getValueNode();
                while (currentValue.getNext() != null) {
                    currentValue = currentValue.getNext();
                }
                currentValue.setNext(new ValueNode(value, null));
                return;
            }
            current = current.getNext();
        }

        current.setNext(new KeyNode(key, new ValueNode(value, null), null));
    }

    @Override
    public void remove(int key) {
        if (isEmpty()) {
            throw new EmptyADTException("No se puede eliminar un par de un diccionario vacío.");
        }

        if (this.first.getKey() == key) {
            this.first = this.first.getNext();
            return;
        }

        KeyNode current = this.first;
        while (current.getNext() != null) {
            if (current.getNext().getKey() == key) {
                current.setNext(current.getNext().getNext());
                return;
            }
            current = current.getNext();
        }

        throw new ElementNotFoundADTException("La clave no existe en el diccionario.");
    }

    @Override
    public void remove(int key, int value) {
        if (isEmpty()) {
            throw new EmptyADTException("No se puede eliminar un par de un diccionario vacío.");
        }

        KeyNode keyNode = findKeyNode(key);
        if (keyNode == null) {
            throw new ElementNotFoundADTException("La clave no existe en el diccionario.");
        }

        removeValueFromKeyNode(keyNode, value);
    }

    @Override
    public int[] get(int key) {
        if (isEmpty()) {
            throw new EmptyADTException("No se puede obtener el valor de un diccionario vacio.");
        }

        KeyNode current = this.first;
        while (current != null) {
            if (current.getKey() == key) {
                int count = 0;
                ValueNode currentValue = current.getValueNode();
                while (currentValue != null) {
                    count++;
                    currentValue = currentValue.getNext();
                }

                int[] result = new int[count];
                int index = 0;
                currentValue = current.getValueNode();
                while (currentValue != null) {
                    result[index++] = currentValue.getValue();
                    currentValue = currentValue.getNext();
                }

                return result;
            }
            current = current.getNext();
        }

        throw new ElementNotFoundADTException("No se puede obtener el valor de una clave que no existe");
    }

    @Override
    public SetADT getKeys() {
        SetADT result = new DynamicSetADT();
        if (isEmpty()) {
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
        return first == null;
    }

    private KeyNode findKeyNode(int key) {
        KeyNode current = this.first;
        while (current != null) {
            if (current.getKey() == key) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    private void removeValueFromKeyNode(KeyNode keyNode, int value) {
        ValueNode currentValue = keyNode.getValueNode();

        while (currentValue != null) {
            if (currentValue.getValue() == value) {
                removeValueNode(currentValue);
                return;
            }
            currentValue = currentValue.getNext();
        }

        throw new ElementNotFoundADTException("No existe el par clave-valor.");
    }

    private void removeValueNode(ValueNode valueNode) {
        if (valueNode.getNext() != null) {
            valueNode.setValue(valueNode.getNext().getValue());
            valueNode.setNext(valueNode.getNext().getNext());
        } else {
            valueNode = null;
        }
    }
}
