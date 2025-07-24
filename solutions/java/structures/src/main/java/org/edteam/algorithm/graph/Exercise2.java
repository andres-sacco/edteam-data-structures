package org.edteam.algorithm.graph;

import org.edteam.structure.definition.GraphADT;
import org.edteam.structure.definition.SetADT;
import org.edteam.structure.exception.ElementNotFoundADTException;
import org.edteam.structure.implementation.dynamic.DynamicGraphADT;
import org.edteam.structure.implementation.dynamic.DynamicSetADT;

public class Exercise2 {

    public static int maxEdgeWeightFromVertex(GraphADT graph, int vertex) {
        SetADT original = graph.getVertxs();
        SetADT copia = copiarSet(original);

        int max = Integer.MIN_VALUE;
        boolean found = false;

        while (!copia.isEmpty()) {
            int destino = copia.choose();
            copia.remove(destino);

            if (graph.existsEdge(vertex, destino)) {
                int peso = graph.edgeWeight(vertex, destino);
                if (peso > max) {
                    max = peso;
                }
                found = true;
            }
        }

        if (!found) {
            throw new ElementNotFoundADTException("El vértice no tiene aristas salientes.");
        }

        return max;
    }

    private static SetADT copiarSet(SetADT original) {
        SetADT copia = new DynamicSetADT();
        SetADT aux = new DynamicSetADT();

        while (!original.isEmpty()) {
            int elem = original.choose();
            original.remove(elem);
            copia.add(elem);
            aux.add(elem);
        }

        while (!aux.isEmpty()) {
            int elem = aux.choose();
            aux.remove(elem);
            original.add(elem);
        }

        return copia;
    }

    public static void main(String[] args) {

        DynamicGraphADT grafo = new DynamicGraphADT();
        grafo.addVertx(1);
        grafo.addVertx(2);
        grafo.addVertx(3);
        grafo.addEdge(1, 2, 10);
        grafo.addEdge(1, 3, 25);

        int max = maxEdgeWeightFromVertex(grafo, 1);
        System.out.println("Máximo peso desde 1: " + max); // Debería imprimir 25

    }
}
