package org.edteam.structure.implementation.common;

public class EdgeNode {
    int weight;
    EdgeNode nextEdgeNode;
    VertexNode connectedVertex;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public EdgeNode getNextEdgeNode() {
        return nextEdgeNode;
    }

    public void setNextEdgeNode(EdgeNode nextEdgeNode) {
        this.nextEdgeNode = nextEdgeNode;
    }

    public VertexNode getConnectedVertex() {
        return connectedVertex;
    }

    public void setConnectedVertex(VertexNode connectedVertex) {
        this.connectedVertex = connectedVertex;
    }
}
