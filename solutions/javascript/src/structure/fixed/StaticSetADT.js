class StaticSetADT {
  constructor(capacity) {
    this.capacity = capacity;
    this.items = new Array(capacity);
    this.size = 0;
  }

  exist(value) {
    for (let i = 0; i < this.size; i++) {
      if (this.items[i] === value) return true;
    }
    return false;
  }

  choose() {
    if (this.isEmpty()) {
      throw new Error("El conjunto está vacío");
    }
    const index = Math.floor(Math.random() * this.size);
    return this.items[index];
  }

  add(value) {
    if (this.size >= this.capacity) {
      throw new Error("El conjunto ha alcanzado su capacidad máxima");
    }
    if (!this.exist(value)) {
      this.items[this.size++] = value;
    }
  }

  remove(value) {
    const index = this.items.indexOf(value);
    if (index !== -1) {
      for (let i = index; i < this.size - 1; i++) {
        this.items[i] = this.items[i + 1];
      }
      this.size--;
    }
  }

  isEmpty() {
    return this.size === 0;
  }
}
