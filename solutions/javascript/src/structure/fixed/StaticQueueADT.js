class StaticQueueADT {
  constructor(capacity) {
    this.capacity = capacity;
    this.queue = new Array(capacity);
    this.front = 0;
    this.rear = 0;
    this.size = 0;
  }

  add(value) {
    if (this.size >= this.capacity) {
      throw new Error("La cola ha alcanzado su capacidad máxima");
    }
    this.queue[this.rear] = value;
    this.rear = (this.rear + 1) % this.capacity;
    this.size++;
  }

  remove() {
    if (this.isEmpty()) {
      throw new Error("La cola está vacía");
    }
    this.front = (this.front + 1) % this.capacity;
    this.size--;
  }

  getElement() {
    if (this.isEmpty()) {
      throw new Error("La cola está vacía");
    }
    return this.queue[this.front];
  }

  isEmpty() {
    return this.size === 0;
  }
}
