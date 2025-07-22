package org.edteam.structure.implementation.common;


import org.edteam.structure.definition.BinaryTreeADT;

public class BinaryTreeNode {
    int value;
    BinaryTreeADT left;
    BinaryTreeADT right;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTreeADT getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeADT left) {
        this.left = left;
    }

    public BinaryTreeADT getRight() {
        return right;
    }

    public void setRight(BinaryTreeADT right) {
        this.right = right;
    }
}