class PriorityQueueNode {
  constructor(value, priority) {
    this.value = value;
    this.priority = priority;
    this.next = null;
  }
}

class DynamicPriorityQueueADT {
  constructor() {
    this.front = null;
  }

  // Agrega un elemento respetando el orden de prioridad (menor número = mayor prioridad)
  add(value, priority) {
    const newNode = new PriorityQueueNode(value, priority);
    if (this.isEmpty() || priority < this.front.priority) {
      newNode.next = this.front;
      this.front = newNode;
    } else {
      let current = this.front;
      while (current.next !== null && current.next.priority <= priority) {
        current = current.next;
      }
      newNode.next = current.next;
      current.next = newNode;
    }
  }

  // Devuelve el valor del primer elemento (con mayor prioridad)
  getElement() {
    if (this.isEmpty()) throw new Error("La cola está vacía");
    return this.front.value;
  }

  // Devuelve la prioridad del primer elemento
  getPriority() {
    if (this.isEmpty()) throw new Error("La cola está vacía");
    return this.front.priority;
  }

  // Elimina el primer elemento (con mayor prioridad)
  remove() {
    if (this.isEmpty()) throw new Error("La cola está vacía");
    this.front = this.front.next;
  }

  // Devuelve true si no hay elementos
  isEmpty() {
    return this.front === null;
  }
}

export default DynamicPriorityQueueADT;
