class StaticPriorityQueueADT {
  constructor(capacity) {
    this.capacity = capacity;
    this.values = new Array(capacity);
    this.priorities = new Array(capacity);
    this.size = 0;
  }

  // Agrega un elemento según su prioridad
  add(value, priority) {
    if (this.size >= this.capacity) {
      throw new Error("La cola ha alcanzado su capacidad máxima");
    }

    let i = this.size - 1;
    // Mover elementos con menor prioridad a la derecha
    while (i >= 0 && this.priorities[i] > priority) {
      this.values[i + 1] = this.values[i];
      this.priorities[i + 1] = this.priorities[i];
      i--;
    }

    // Insertar el nuevo valor en la posición correcta
    this.values[i + 1] = value;
    this.priorities[i + 1] = priority;
    this.size++;
  }

  // Devuelve el valor del primer elemento
  getElement() {
    if (this.isEmpty()) {
      throw new Error("La cola está vacía");
    }
    return this.values[0];
  }

  // Devuelve la prioridad del primer elemento
  getPriority() {
    if (this.isEmpty()) {
      throw new Error("La cola está vacía");
    }
    return this.priorities[0];
  }

  // Elimina el primer elemento
  remove() {
    if (this.isEmpty()) {
      throw new Error("La cola está vacía");
    }
    for (let i = 1; i < this.size; i++) {
      this.values[i - 1] = this.values[i];
      this.priorities[i - 1] = this.priorities[i];
    }
    this.size--;
  }

  // Devuelve true si no hay elementos
  isEmpty() {
    return this.size === 0;
  }
}

export default StaticPriorityQueueADT;