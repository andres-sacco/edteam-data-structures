package org.edteam.structure.implementation.dynamic;

import org.edteam.structure.exception.ElementNotFoundADTException;
import org.edteam.structure.definition.GraphADT;
import org.edteam.structure.definition.SetADT;
import org.edteam.structure.implementation.common.EdgeNode;
import org.edteam.structure.implementation.common.VertexNode;

public class DynamicGraphADT implements GraphADT {

    private VertexNode firstVertex;

    public DynamicGraphADT() {
        this.firstVertex = null;
    }

    @Override
    public SetADT getVertxs() {
        SetADT vertices = new DynamicSetADT();
        VertexNode current = firstVertex;
        while (current != null) {
            vertices.add(current.getValue());
            current = current.getNextVertexNode();
        }
        return vertices;
    }

    @Override
    public void addVertx(int vertex) {
        if (firstVertex == null) {
            firstVertex = new VertexNode();
            firstVertex.setValue(vertex);
        } else {
            VertexNode current = firstVertex;
            while (current != null) {
                if (current.getValue() == vertex) {
                    return;
                }
                if (current.getNextVertexNode() == null) {
                    VertexNode newVertex = new VertexNode();
                    newVertex.setValue(vertex);
                    current.setNextVertexNode(newVertex);
                    return;
                }
                current = current.getNextVertexNode();
            }
        }
    }

    @Override
    public void removeVertx(int vertex) {
        if (firstVertex == null) {
            return;
        }

        if (firstVertex.getValue() == vertex) {
            firstVertex = firstVertex.getNextVertexNode();
            return;
        }

        VertexNode current = firstVertex;
        while (current.getNextVertexNode() != null) {
            if (current.getNextVertexNode().getValue() == vertex) {
                current.setNextVertexNode(current.getNextVertexNode().getNextVertexNode());
                return;
            }
            current = current.getNextVertexNode();
        }
    }

    @Override
    public void addEdge(int vertxOne, int vertxTwo, int weight) {
        VertexNode v1 = findVertex(vertxOne);
        VertexNode v2 = findVertex(vertxTwo);

        if (v1 == null || v2 == null) {
            throw new ElementNotFoundADTException("Uno de los elementos no existe.");
        }

        EdgeNode newEdge = new EdgeNode();
        newEdge.setConnectedVertex(v2);
        newEdge.setWeight(weight);

        if (v1.getEdgeNode() == null) {
            v1.setEdgeNode(newEdge);
        } else {
            EdgeNode current = v1.getEdgeNode();
            while (current.getNextEdgeNode() != null) {
                current = current.getNextEdgeNode();
            }
            current.setNextEdgeNode(newEdge);
        }
    }

    @Override
    public void removeEdge(int vertxOne, int vertxTwo) {
        VertexNode v1 = findVertex(vertxOne);
        if (v1 == null) {
            return;
        }

        EdgeNode current = v1.getEdgeNode();
        EdgeNode previous = null;

        while (current != null) {
            if (current.getConnectedVertex().getValue() == vertxTwo) {
                if (previous == null) {
                    v1.setEdgeNode(current.getNextEdgeNode());
                } else {
                    previous.setNextEdgeNode(current.getNextEdgeNode());
                }
                return;
            }
            previous = current;
            current = current.getNextEdgeNode();
        }
    }

    @Override
    public boolean existsEdge(int vertxOne, int vertxTwo) {
        VertexNode v1 = findVertex(vertxOne);
        if (v1 == null) {
            return false;
        }

        EdgeNode current = v1.getEdgeNode();
        while (current != null) {
            if (current.getConnectedVertex().getValue() == vertxTwo) {
                return true;
            }
            current = current.getNextEdgeNode();
        }
        return false;
    }

    @Override
    public int edgeWeight(int vertxOne, int vertxTwo) {
        VertexNode v1 = findVertex(vertxOne);
        if (v1 == null) {
            throw new ElementNotFoundADTException("No hay nodos en el grafo.");
        }

        EdgeNode current = v1.getEdgeNode();
        while (current != null) {
            if (current.getConnectedVertex().getValue() == vertxTwo) {
                return current.getWeight();
            }
            current = current.getNextEdgeNode();
        }
        throw new ElementNotFoundADTException("No existe la arista.");
    }

    @Override
    public boolean isEmpty() {
        return firstVertex == null;
    }

    private VertexNode findVertex(int vertex) {
        VertexNode current = firstVertex;
        while (current != null) {
            if (current.getValue() == vertex) {
                return current;
            }
            current = current.getNextVertexNode();
        }
        return null;
    }
}
