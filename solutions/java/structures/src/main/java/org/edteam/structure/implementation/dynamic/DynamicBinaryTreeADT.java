package org.edteam.structure.implementation.dynamic;


import org.edteam.structure.definition.BinaryTreeADT;
import org.edteam.structure.exception.EmptyADTException;
import org.edteam.structure.implementation.common.BinaryTreeNode;
import org.edteam.structure.implementation.fixed.StaticBinaryTreeADT;

public class DynamicBinaryTreeADT implements BinaryTreeADT {

    private BinaryTreeNode root;

    public DynamicBinaryTreeADT() {
        this.root = null;
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
        if (isEmpty()) {
            this.root = new BinaryTreeNode(value);
        } else {
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
                root = ((DynamicBinaryTreeADT) root.getLeft()).root;
            } else if (root.getRight() != null) {
                root = ((DynamicBinaryTreeADT) root.getRight()).root;
            } else {
                BinaryTreeNode min = ((DynamicBinaryTreeADT) root.getRight()).root;
                while (((DynamicBinaryTreeADT) min.getLeft()).root != null) {
                    min = ((DynamicBinaryTreeADT) min.getLeft()).root;
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
                node.setLeft(new DynamicBinaryTreeADT());
                node.getLeft().add(value);
            } else {
                node.getLeft().add(value);
            }
        } else if (value > node.getValue()) {
            if (node.getRight() == null) {
                node.setRight(new DynamicBinaryTreeADT());
                node.getRight().add(value);
            } else {
                node.getRight().add(value);
            }
        }
    }
}
