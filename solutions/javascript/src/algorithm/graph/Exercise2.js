import DynamicSetADT from "../../structure/dynamic/DynamicSetADT.js";
import DynamicGraphADT from "../../structure/dynamic/DynamicGraphADT.js";

function maxEdgeWeightFromVertex(graph, v) {
  if (graph.isEmpty()) {
    throw new Error("El grafo está vacío.");
  }

  const vertices = graph.getVertxs();
  const copia = copiarSet(vertices);

  let maxWeight = null;
  let found = false;

  while (!copia.isEmpty()) {
    const destino = copia.choose();
    copia.remove(destino);

    if (graph.existsEdge(v, destino)) {
      const peso = graph.edgeWeight(v, destino);
      if (maxWeight === null || peso > maxWeight) {
        maxWeight = peso;
        found = true;
      }
    }
  }

  if (!found) {
    throw new Error(`El vértice ${v} no tiene aristas salientes.`);
  }

  return maxWeight;
}

function copiarSet(original) {
  const copia = new DynamicSetADT();
  const aux = new DynamicSetADT();

  while (!original.isEmpty()) {
    const elem = original.choose();
    original.remove(elem);
    copia.add(elem);
    aux.add(elem);
  }

  while (!aux.isEmpty()) {
    const elem = aux.choose();
    aux.remove(elem);
    original.add(elem);
  }

  return copia;
}


const grafo = new DynamicGraphADT();
grafo.addVertx(1);
grafo.addVertx(2);
grafo.addVertx(3);
grafo.addEdge(1, 2, 15);
grafo.addEdge(1, 3, 30);

console.log(maxEdgeWeightFromVertex(grafo, 1)); // → 30
