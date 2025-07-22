package org.edteam.structure.implementation.fixed;

import org.edteam.structure.exception.ElementNotFoundADTException;
import org.edteam.structure.exception.EmptyADTException;
import org.edteam.structure.definition.GraphADT;
import org.edteam.structure.definition.SetADT;
import org.edteam.structure.definition.SimpleDictionaryADT;

public class StaticGraphADT implements GraphADT {
    private static final int MAX_NODES = 15;

    private final int[][] adjacencyMatrix;
    private final SimpleDictionaryADT dictionary;
    private int totalNodes;

    public StaticGraphADT() {
        this.adjacencyMatrix = new int[MAX_NODES][MAX_NODES];
        this.dictionary = new StaticSimpleDictionaryADT();
        this.totalNodes = 0;
    }

    @Override
    public SetADT getVertxs() {
        return this.dictionary.getKeys();
    }

    @Override
    public void addVertx(int vertex) {
        if (isEmpty()) {
            this.dictionary.add(vertex, this.totalNodes);
            this.totalNodes++;
            return;
        }
        this.dictionary.add(vertex, this.totalNodes);
        this.totalNodes++;

    }

    @Override
    public void removeVertx(int vertex) {
        if (isEmpty()) {
            throw new ElementNotFoundADTException("El nodo no existe.");
        }

        int before = this.totalNodes;
        SetADT nodes = this.dictionary.getKeys();
        int index = this.dictionary.get(vertex);
        int last = -1;
        while (!nodes.isEmpty()) {
            int current = nodes.choose();
            if (this.dictionary.get(current) == before - 1) {
                last = current;
            }
            if (current == vertex) {
                this.dictionary.remove(vertex);
                this.totalNodes--;
            }
            nodes.remove(current);
        }
        int after = this.totalNodes;

        if (last == vertex) {
            return;
        }

        if (before != after) {
            for (int i = 0; i < before; i++) {
                this.adjacencyMatrix[i][index] = this.adjacencyMatrix[i][after];
                this.adjacencyMatrix[index][i] = this.adjacencyMatrix[after][i];
            }

            this.dictionary.remove(last);
            this.dictionary.add(last, index);
            return;
        }

        throw new ElementNotFoundADTException("El nodo no existe");
    }

    @Override
    public void addEdge(int from, int to, int weight) {
        if (isEmpty()) {
            throw new EmptyADTException("No hay nodos en el grafo.");
        } else if (notIn(from) || notIn(to)) {
            throw new ElementNotFoundADTException("No existe alguno de los nodos en el grafo.");
        }

        int indexFrom = this.dictionary.get(from);
        int indexTo = this.dictionary.get(to);

        if (this.adjacencyMatrix[indexFrom][indexTo] != 0) {
            throw new RuntimeException("Ya existe la arista");
        }

        this.adjacencyMatrix[indexFrom][indexTo] = weight;
    }

    @Override
    public void removeEdge(int from, int to) {
        if (!existsEdge(from, to)) {
            throw new ElementNotFoundADTException("No existe la arista.");
        }

        int indexFrom = this.dictionary.get(from);
        int indexTo = this.dictionary.get(to);

        this.adjacencyMatrix[indexFrom][indexTo] = 0;
    }

    @Override
    public boolean existsEdge(int from, int to) {
        if (isEmpty()) {
            return false;
        } else if (notIn(from) || notIn(to)) {
            return false;
        }

        int indexFrom = this.dictionary.get(from);
        int indexTo = this.dictionary.get(to);

        return this.adjacencyMatrix[indexFrom][indexTo] != 0;
    }

    @Override
    public int edgeWeight(int from, int to) {
        if (isEmpty()) {
            throw new EmptyADTException("No hay nodos en el grafo.");
        } else if (!existsEdge(from, to)) {
            throw new ElementNotFoundADTException("No existe la arista.");
        }

        int indexFrom = this.dictionary.get(from);
        int indexTo = this.dictionary.get(to);

        return this.adjacencyMatrix[indexFrom][indexTo];
    }

    @Override
    public boolean isEmpty() {
        return totalNodes == 0;
    }

    private boolean notIn(int node) {
        SetADT nodes = this.dictionary.getKeys();
        while (!nodes.isEmpty()) {
            int current = nodes.choose();
            if (current == node) {
                return false;
            }
            nodes.remove(current);
        }
        return true;
    }
}
