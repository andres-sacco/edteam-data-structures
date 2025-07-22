package org.edteam.structure.implementation.common;

public class VertexNode {
    int value = 0;
    VertexNode nextVertexNode;
    EdgeNode edgeNode;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public VertexNode getNextVertexNode() {
        return nextVertexNode;
    }

    public void setNextVertexNode(VertexNode nextVertexNode) {
        this.nextVertexNode = nextVertexNode;
    }

    public EdgeNode getEdgeNode() {
        return edgeNode;
    }

    public void setEdgeNode(EdgeNode edgeNode) {
        this.edgeNode = edgeNode;
    }
}
