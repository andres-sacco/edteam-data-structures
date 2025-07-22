import DynamicStackADT from "../dynamic/DynamicStackADT.js";

class StaticStackADT {
  constructor(capacity) {
    this.capacity = capacity;
    this.stack = new Array(capacity);
    this.top = -1;
  }

  add(value) {
    if (this.top >= this.capacity - 1) {
      throw new Error("La pila ha alcanzado su capacidad máxima");
    }
    this.stack[++this.top] = value;
  }

  remove() {
    if (this.isEmpty()) {
      throw new Error("La pila está vacía");
    }
    this.top--;
  }

  getElement() {
    if (this.isEmpty()) {
      throw new Error("La pila está vacía");
    }
    return this.stack[this.top];
  }

  isEmpty() {
    return this.top === -1;
  }
}

export default StaticStackADT;