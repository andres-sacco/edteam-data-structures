package org.edteam.algorithm.others;

import org.edteam.structure.definition.GraphADT;
import org.edteam.structure.definition.SetADT;
import org.edteam.structure.implementation.dynamic.DynamicGraphADT;
import org.edteam.structure.implementation.dynamic.DynamicSetADT;
import org.edteam.structure.implementation.dynamic.DynamicSimpleDictionaryADT;

public class Exercise7 {

    public static DynamicSimpleDictionaryADT calcularGradosPublicos(GraphADT grafo) {
        DynamicSimpleDictionaryADT resultado = new DynamicSimpleDictionaryADT();

        SetADT vertices = grafo.getVertxs();

        // Copiamos vertices para iterar sin perderlos (ya que SetADT tiene choose y remove)
        SetADT verticesCopy1 = copySet(vertices);
        SetADT verticesCopy2 = copySet(vertices);

        // Para cada vértice v, calculamos grados
        while (!verticesCopy1.isEmpty()) {
            int v = verticesCopy1.choose();
            verticesCopy1.remove(v);

            int gradoSalida = 0;
            int gradoEntrada = 0;

            // Calculamos grado salida: contar u con arista v->u
            SetADT aux = copySet(verticesCopy2);
            while (!aux.isEmpty()) {
                int u = aux.choose();
                aux.remove(u);
                if (grafo.existsEdge(v, u)) {
                    gradoSalida++;
                }
            }

            // Calculamos grado entrada: contar u con arista u->v
            aux = copySet(verticesCopy2);
            while (!aux.isEmpty()) {
                int u = aux.choose();
                aux.remove(u);
                if (grafo.existsEdge(u, v)) {
                    gradoEntrada++;
                }
            }

            // Guardamos valor codificado (ejemplo: entrada * 10000 + salida)
            int valorCodificado = gradoEntrada * 10000 + gradoSalida;
            resultado.add(v, valorCodificado);
        }

        return resultado;
    }

    private static SetADT copySet(SetADT original) {
        SetADT copy = new DynamicSetADT();
        SetADT temp = new DynamicSetADT();

        while (!original.isEmpty()) {
            int val = original.choose();
            original.remove(val);
            copy.add(val);
            temp.add(val);
        }

        // Restaurar original
        while (!temp.isEmpty()) {
            int val = temp.choose();
            temp.remove(val);
            original.add(val);
        }

        return copy;
    }

    public static void main(String[] args) {
        DynamicGraphADT grafo = new DynamicGraphADT();

        // Agregar vértices
        grafo.addVertx(1);
        grafo.addVertx(2);
        grafo.addVertx(3);

        // Agregar aristas dirigidas con pesos (peso no es relevante para grados)
        grafo.addEdge(1, 2, 5);
        grafo.addEdge(2, 3, 7);
        grafo.addEdge(3, 1, 4);
        grafo.addEdge(2, 1, 1);

        // Calcular grados de entrada y salida
        DynamicSimpleDictionaryADT grados = calcularGradosPublicos(grafo);

        // Mostrar resultados
        SetADT claves = grados.getKeys();
        while (!claves.isEmpty()) {
            int v = claves.choose();
            claves.remove(v);

            int codificado = grados.get(v);
            int gradoEntrada = codificado / 10000;
            int gradoSalida = codificado % 10000;

            System.out.println("Vértice: " + v + " - Grado Entrada: " + gradoEntrada + " - Grado Salida: " + gradoSalida);
        }
    }
}
