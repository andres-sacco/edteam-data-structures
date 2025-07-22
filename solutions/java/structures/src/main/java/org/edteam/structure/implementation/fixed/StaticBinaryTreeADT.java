package org.edteam.structure.implementation.fixed;


import org.edteam.structure.definition.BinaryTreeADT;
import org.edteam.structure.exception.EmptyADTException;
import org.edteam.structure.exception.FullADTException;
import org.edteam.structure.implementation.common.BinaryTreeNode;

public class StaticBinaryTreeADT implements BinaryTreeADT {
    private static final int MAX = 1000;

    private int count;
    private BinaryTreeNode root;

    public StaticBinaryTreeADT() {
        this.root = null;
        this.count = 0;
    }

    @Override
    public int getRoot() {
        if (isEmpty()) {
            throw new EmptyADTException("El árbol está vacío.");
        }
        return this.root.getValue();
    }

    @Override
    public BinaryTreeADT getLeft() {
        return (root != null && root.getLeft() != null) ? root.getLeft() : new StaticBinaryTreeADT();
    }

    @Override
    public BinaryTreeADT getRight() {
        return (root != null && root.getRight() != null) ? root.getRight() : new StaticBinaryTreeADT();
    }

    @Override
    public void add(int value) {
        if (count >= MAX) {
            throw new FullADTException("El árbol ha alcanzado su capacidad máxima.");
        } else if (count == 0) {
            this.root = new BinaryTreeNode(value);
            this.count++;
        } else{
            addRecursive(root, value);
        }
    }

    @Override
    public void remove(int value) {
        if (isEmpty()) {
            throw new EmptyADTException("El árbol está vacío.");
        }

        if (root.getValue() == value) {
            if (root.getRight() == null && root.getLeft() == null) {
                root = null;
            } else if (root.getLeft() != null) {
                root = ((StaticBinaryTreeADT) root.getLeft()).root;
            } else if (root.getRight() != null) {
                root = ((StaticBinaryTreeADT) root.getRight()).root;
            } else {
                BinaryTreeNode min = ((StaticBinaryTreeADT) root.getRight()).root;
                while (((StaticBinaryTreeADT) min.getLeft()).root != null) {
                    min = ((StaticBinaryTreeADT) min.getLeft()).root;
                }

                root.setValue(min.getValue());
                root.getRight().remove(min.getValue());
            }
        } else if (root.getValue() > value) {
            root.getLeft().remove(value);
        } else {
            root.getRight().remove(value);
        }
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }


    private void addRecursive(BinaryTreeNode node, int value) {
         if (value < node.getValue()) {
            if (node.getLeft() == null) {
                node.setLeft(new StaticBinaryTreeADT());
                node.getLeft().add(value);
            } else {
                node.getLeft().add(value);
            }
        } else if (value > node.getValue()) {
            if (node.getRight() == null) {
                node.setRight(new StaticBinaryTreeADT());
                node.getRight().add(value);
            } else {
                node.getRight().add(value);
            }
        }
         this.count++;
    }
}
