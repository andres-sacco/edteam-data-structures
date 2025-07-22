package org.edteam.algorithm.set;

import org.edteam.structure.definition.SetADT;
import org.edteam.structure.implementation.dynamic.DynamicSetADT;

public class Exercise6 {
    public static SetADT intersection(SetADT a, SetADT b) {
        SetADT result = new DynamicSetADT();

        while (!a.isEmpty()) {
            int value = a.choose();
            if (b.exist(value)) {
                result.add(value);
            }
            a.remove(value); // Operamos de forma destructiva sobre 'a'
        }

        return result;
    }

    public static SetADT union(SetADT a, SetADT b) {
        SetADT result = new DynamicSetADT();

        while (!a.isEmpty()) {
            int value = a.choose();
            result.add(value);
            a.remove(value); // Operamos de forma destructiva sobre 'a'
        }

        while (!b.isEmpty()) {
            int value = b.choose();
            result.add(value);
            b.remove(value); // Operamos de forma destructiva sobre 'b'
        }

        return result;
    }

    public static void main(String[] args) {
        SetADT setA = new DynamicSetADT();
        setA.add(1);
        setA.add(2);
        setA.add(3);

        SetADT setB = new DynamicSetADT();
        setB.add(2);
        setB.add(3);
        setB.add(4);

        SetADT interseccion = intersection(setA, setB);
        System.out.println("Intersección:");
        while (!interseccion.isEmpty()) {
            int val = interseccion.choose();
            System.out.print(val + " ");
            interseccion.remove(val);
        }

        // Re-crear los sets porque se destruyeron en la intersección
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setB.add(2);
        setB.add(3);
        setB.add(4);

        SetADT union = union(setA, setB);
        System.out.println("\nUnión:");
        while (!union.isEmpty()) {
            int val = union.choose();
            System.out.print(val + " ");
            union.remove(val);
        }
    }
}
