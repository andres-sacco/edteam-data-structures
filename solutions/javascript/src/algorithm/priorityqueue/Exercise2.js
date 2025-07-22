import DynamicPriorityQueueADT from "../../structure/dynamic/DynamicPriorityQueueADT.js";

function eliminarPorPrioridad(cola, prioridadObjetivo) {
  const aux = new DynamicPriorityQueueADT();

  while (!cola.isEmpty()) {
    const value = cola.getElement();
    const priority = cola.getPriority();

    cola.remove();
    if (priority !== prioridadObjetivo) {
      aux.add(value, priority);
    }
  }

  while (!aux.isEmpty()) {
    const value = aux.getElement();
    const priority = aux.getPriority();
    aux.remove();
    cola.add(value, priority);
  }
}

// Ejemplo
const cola = new DynamicPriorityQueueADT();
cola.add(10, 2);
cola.add(20, 3);
cola.add(30, 2);
cola.add(40, 1);

eliminarPorPrioridad(cola, 2); // Elimina 10 y 30

while (!cola.isEmpty()) {
    const value = cola.getElement();
    const priority = cola.getPriority();

  console.log(`Valor: ${value}, Prioridad: ${priority}`);
  cola.remove();
}