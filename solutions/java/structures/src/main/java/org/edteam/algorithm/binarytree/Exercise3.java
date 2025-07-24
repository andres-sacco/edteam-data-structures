package org.edteam.algorithm.binarytree;

import org.edteam.structure.definition.BinaryTreeADT;
import org.edteam.structure.implementation.dynamic.DynamicBinaryTreeADT;

public class Exercise3 {

    public static boolean isPrefix(BinaryTreeADT a, BinaryTreeADT b) {
        if (a == null || a.isEmpty()) {
            return true; // árbol vacío es prefijo de cualquier árbol
        }
        if (b == null || b.isEmpty()) {
            return false; // si A no es vacío y B sí, no es prefijo
        }
        if (a.getRoot() != b.getRoot()) {
            return false;
        }
        return isPrefix(a.getLeft(), b.getLeft()) && isPrefix(a.getRight(), b.getRight());
    }

    public static void main(String[] args) {
        BinaryTreeADT tree1 = new DynamicBinaryTreeADT();
        tree1.add(10);
        tree1.add(5);

        BinaryTreeADT tree2 = new DynamicBinaryTreeADT();
        tree2.add(10);
        tree2.add(5);
        tree2.add(15);

        System.out.println("Tree1 es prefijo de Tree2? " + isPrefix(tree1, tree2)); // true
        System.out.println("Tree2 es prefijo de Tree1? " + isPrefix(tree2, tree1)); // false
    }

}
