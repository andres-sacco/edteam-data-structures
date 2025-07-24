package org.edteam.algorithm.binarytree;

import org.edteam.structure.definition.BinaryTreeADT;
import org.edteam.structure.implementation.dynamic.DynamicBinaryTreeADT;

public class Exercise2 {

    public static int countNodes(BinaryTreeADT tree) {
        if (tree == null || tree.isEmpty()) {
            return 0;
        }
        return 1 + countNodes(tree.getLeft()) + countNodes(tree.getRight());
    }

    public static void main(String[] args) {
        BinaryTreeADT tree = new DynamicBinaryTreeADT();
        tree.add(10);
        tree.add(5);
        tree.add(15);

        System.out.println("Cantidad de nodos: " + countNodes(tree)); // Salida: 3
    }
}
