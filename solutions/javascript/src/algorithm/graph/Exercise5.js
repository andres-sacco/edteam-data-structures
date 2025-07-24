import DynamicGraphADT from "../../structure/dynamic/DynamicGraphADT.js";
import DynamicSetADT from "../../structure/dynamic/DynamicSetADT.js";

function areGraphsEqual(g1, g2) {
  // Verificar que tengan los mismos vértices
  if (!setsAreEqual(g1.getVertxs(), g2.getVertxs())) {
    return false;
  }

  const vertices = g1.getVertxs();
  const copiaVertices = copiarSet(vertices);

  while (!copiaVertices.isEmpty()) {
    const v = copiaVertices.choose();
    copiaVertices.remove(v);

    const destinos = g1.getVertxs(); // Usamos los vértices para probar destinos
    const copiaDestinos = copiarSet(destinos);

    while (!copiaDestinos.isEmpty()) {
      const destino = copiaDestinos.choose();
      copiaDestinos.remove(destino);

      const g1HasEdge = g1.existsEdge(v, destino);
      const g2HasEdge = g2.existsEdge(v, destino);

      if (g1HasEdge !== g2HasEdge) {
        return false;
      }

      if (g1HasEdge) {
        if (g1.edgeWeight(v, destino) !== g2.edgeWeight(v, destino)) {
          return false;
        }
      }
    }
  }

  return true;
}

function setsAreEqual(s1, s2) {
  const copia1 = copiarSet(s1);
  const copia2 = copiarSet(s2);

  if (countSet(copia1) !== countSet(copia2)) return false;

  while (!copia1.isEmpty()) {
    const elem = copia1.choose();
    copia1.remove(elem);
    if (!copia2.exist(elem)) {
      return false;
    }
    copia2.remove(elem);
  }

  return copia2.isEmpty();
}

function countSet(set) {
  const copia = copiarSet(set);
  let count = 0;
  while (!copia.isEmpty()) {
    copia.remove(copia.choose());
    count++;
  }
  return count;
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


const g1 = new DynamicGraphADT();
g1.addVertx(1);
g1.addVertx(2);
g1.addEdge(1, 2, 10);

const g2 = new DynamicGraphADT();
g2.addVertx(1);
g2.addVertx(2);
g2.addEdge(1, 2, 10);

console.log(areGraphsEqual(g1, g2)); // true
