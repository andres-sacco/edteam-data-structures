class DynamicStackADT {
  constructor() {
    this.stack = [];
  }

  add(value) {
    this.stack.push(value);
  }

  remove() {
    if (this.isEmpty()) {
      throw new Error("La pila está vacía");
    }
    this.stack.pop();
  }

  getElement() {
    if (this.isEmpty()) {
      throw new Error("La pila está vacía");
    }
    return this.stack[this.stack.length - 1];
  }

  isEmpty() {
    return this.stack.length === 0;
  }
}

export default DynamicStackADT;