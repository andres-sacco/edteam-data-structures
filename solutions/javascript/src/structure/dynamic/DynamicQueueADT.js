class DynamicQueueADT {
  constructor() {
    this.queue = [];
  }

  add(value) {
    this.queue.push(value);
  }

  remove() {
    if (this.isEmpty()) {
      throw new Error("La cola está vacía");
    }
    this.queue.shift();
  }

  getElement() {
    if (this.isEmpty()) {
      throw new Error("La cola está vacía");
    }
    return this.queue[0];
  }

  isEmpty() {
    return this.queue.length === 0;
  }
}


export default DynamicQueueADT;