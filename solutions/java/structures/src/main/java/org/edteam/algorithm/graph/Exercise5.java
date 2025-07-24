package org.edteam.algorithm.graph;

import org.edteam.structure.definition.GraphADT;
import org.edteam.structure.definition.SetADT;
import org.edteam.structure.implementation.dynamic.DynamicGraphADT;
import org.edteam.structure.implementation.dynamic.DynamicSetADT;

public class Exercise5 {
    public static boolean areGraphsEqual(GraphADT g1, GraphADT g2) {
        // Comparar vértices
        if (!setsAreEqual(g1.getVertxs(), g2.getVertxs())) {
            return false;
        }

        // Copiar conjunto para recorrer sin modificar
        SetADT vertices = g1.getVertxs();
        SetADT copia = copiarSet(vertices);

        // Para cada vértice en el grafo
        while (!copia.isEmpty()) {
            int origen = copia.choose();
            copia.remove(origen);

            SetADT destinos = copiarSet(vertices);
            while (!destinos.isEmpty()) {
                int destino = destinos.choose();
                destinos.remove(destino);

                boolean g1Tiene = g1.existsEdge(origen, destino);
                boolean g2Tiene = g2.existsEdge(origen, destino);

                if (g1Tiene != g2Tiene) {
                    return false;
                }

                if (g1Tiene) {
                    int peso1 = g1.edgeWeight(origen, destino);
                    int peso2 = g2.edgeWeight(origen, destino);
                    if (peso1 != peso2) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private static boolean setsAreEqual(SetADT s1, SetADT s2) {
        SetADT copia1 = copiarSet(s1);
        SetADT copia2 = copiarSet(s2);

        if (count(copia1) != count(copia2)) return false;

        while (!copia1.isEmpty()) {
            int elem = copia1.choose();
            copia1.remove(elem);
            if (!copia2.exist(elem)) {
                return false;
            }
            copia2.remove(elem);
        }

        return copia2.isEmpty();
    }

    private static int count(SetADT set) {
        SetADT copia = copiarSet(set);
        int c = 0;
        while (!copia.isEmpty()) {
            copia.remove(copia.choose());
            c++;
        }
        return c;
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
        GraphADT g1 = new DynamicGraphADT();
        g1.addVertx(1);
        g1.addVertx(2);
        g1.addEdge(1, 2, 10);

        GraphADT g2 = new DynamicGraphADT();
        g2.addVertx(1);
        g2.addVertx(2);
        g2.addEdge(1, 2, 10);

        boolean iguales = areGraphsEqual(g1, g2);
        System.out.println("¿Son iguales? " + iguales); // true
    }
}
