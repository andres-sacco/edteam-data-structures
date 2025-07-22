package org.edteam.structure.implementation.fixed;

import org.edteam.structure.exception.EmptyADTException;
import org.edteam.structure.exception.FullADTException;
import org.edteam.structure.definition.SetADT;

import java.util.Random;

public class StaticSetADT implements SetADT {

    private static final int MAX = 1000;

    private final int[] array;
    private int count;

    public StaticSetADT() {
        this.array = new int[MAX];
        this.count = 0;
    }

    @Override
    public boolean exist(int value) {
        for (int i = 0; i < this.count; i++) {
            if (this.array[i] == value) {
                return true;
            }
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
        return this.array[i];
    }

    @Override
    public void add(int value) {
        if (this.count == MAX) {
            throw new FullADTException("El conjunto esta lleno.");
        }

        for (int i = 0; i < this.count; i++) {
            if (this.array[i] == value) {
                return;
            }
        }
        this.array[this.count] = value;
        this.count++;
    }

    @Override
    public void remove(int value) {
        if (isEmpty()) {
            throw new EmptyADTException("No se puede eliminar un elemento de un conjunto vacio.");
        }

        for (int i = 0; i < this.count; i++) {
            if (this.array[i] == value) {
                this.array[i] = this.array[this.count - 1];
                this.count--;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }
}
