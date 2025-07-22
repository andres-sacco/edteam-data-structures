import DynamicPriorityQueueADT from "../../structure/dynamic/DynamicPriorityQueueADT.js";


function filtrarColaPorPrioridad(originalQueue, prioridadMinima) {
  const nuevaCola = new DynamicPriorityQueueADT();
  const auxiliar = new DynamicPriorityQueueADT();

  while (!originalQueue.isEmpty()) {
    const valor = originalQueue.getElement();
    const prioridad = originalQueue.getPriority();

    if (prioridad >= prioridadMinima) {
      nuevaCola.add(valor, prioridad);
    }

    auxiliar.add(valor, prioridad); // Para restaurar
    originalQueue.remove();
  }

  // Restaurar cola original
  while (!auxiliar.isEmpty()) {
    originalQueue.add(auxiliar.getElement(), auxiliar.getPriority());
    auxiliar.remove();
  }

  return nuevaCola;
}


const cola = new DynamicPriorityQueueADT();

cola.add(10, 1);
cola.add(20, 5);
cola.add(30, 3);
cola.add(40, 7);
cola.add(50, 2);

const prioridadMinima = 3;
const filtrada = filtrarColaPorPrioridad(cola, prioridadMinima);

console.log(`Elementos con prioridad >= ${prioridadMinima}:`);
while (!filtrada.isEmpty()) {
    console.log(`[${filtrada.getElement()}, ${filtrada.getPriority()}]`);
    filtrada.remove();
}

console.log("\nCola original después del filtrado (debe mantenerse igual):");
while (!cola.isEmpty()) {
    console.log(`[${cola.getElement()}, ${cola.getPriority()}]`);
    cola.remove();
}