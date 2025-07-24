import DynamicSetADT from "../../structure/dynamic/DynamicSetADT.js";
import DynamicSimpleDictionaryADT from "../../structure/dynamic/DynamicSimpleDictionaryADT.js";
import DynamicGraphADT from "../../structure/dynamic/DynamicGraphADT.js";

function calcularGradoEntradaSalida(grafo) {
  const resultado = new DynamicSimpleDictionaryADT(); // Diccionario simple para guardar resultados

  // Copiamos los vértices para poder iterar y modificar sin problemas
  const vertices = grafo.getVertxs();
  const tempSet = new DynamicSetADT();

  // Extraer todos los vértices a tempSet e inicializar resultado con [0, 0]
  while (!vertices.isEmpty()) {
    const v = vertices.choose();
    vertices.remove(v);
    tempSet.add(v);
    resultado.add(v, [0, 0]); // [gradoEntrada, gradoSalida]
  }

  // Restaurar vertices
  while (!tempSet.isEmpty()) {
    const v = tempSet.choose();
    tempSet.remove(v);
    vertices.add(v);
  }

  // Calcular grados
  // gradoSalida: contar aristas que salen de v
  // gradoEntrada: contar aristas que llegan a v
  for (const v of verticesToArray(vertices)) {
    let salida = 0;
    for (const edge of grafo.edges) {
      if (edge.from === v) {
        salida++;
        // actualizar grado de entrada del destino
        if (resultado.get(edge.to)) {
          const [entrada, salidaActual] = resultado.get(edge.to);
          resultado.remove(edge.to);
          resultado.add(edge.to, [entrada + 1, salidaActual]);
        } else {
          resultado.add(edge.to, [1, 0]);
        }
      }
    }
    // actualizar grado salida para v
    if (resultado.get(v)) {
      const [entrada, _] = resultado.get(v);
      resultado.remove(v);
      resultado.add(v, [entrada, salida]);
    } else {
      resultado.add(v, [0, salida]);
    }
  }

  return resultado;
}

// Función auxiliar para convertir DynamicSetADT a array sin modificar el conjunto
function verticesToArray(dynamicSet) {
  const result = [];
  const temp = new DynamicSetADT();

  while (!dynamicSet.isEmpty()) {
    const val = dynamicSet.choose();
    dynamicSet.remove(val);
    result.push(val);
    temp.add(val);
  }
  // Restaurar
  while (!temp.isEmpty()) {
    const val = temp.choose();
    temp.remove(val);
    dynamicSet.add(val);
  }

  return result;
}


const grafo = new DynamicGraphADT();
grafo.addVertx(1);
grafo.addVertx(2);
grafo.addVertx(3);

grafo.addEdge(1, 2, 5);
grafo.addEdge(1, 3, 10);
grafo.addEdge(2, 3, 7);

const grados = calcularGradoEntradaSalida(grafo);

const keys = grados.getKeys();
while (!keys.isEmpty()) {
  const k = keys.choose();
  keys.remove(k);
  const [entrada, salida] = grados.get(k);
  console.log(`Nodo ${k} -> Grado entrada: ${entrada}, Grado salida: ${salida}`);
}