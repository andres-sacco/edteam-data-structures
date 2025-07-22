class DynamicMultipleDictionaryADT {
  constructor() {
    this.dict = new Map();
  }

  add(key, value) {
    if (!this.dict.has(key)) {
      this.dict.set(key, []);
    }
    const values = this.dict.get(key);
    if (!values.includes(value)) {
      values.push(value);
    }
  }

  remove(key) {
    this.dict.delete(key);
  }

  removeValue(key, value) {
    if (this.dict.has(key)) {
      const values = this.dict.get(key);
      const index = values.indexOf(value);
      if (index !== -1) {
        values.splice(index, 1);
        if (values.length === 0) {
          this.dict.delete(key);
        }
      }
    }
  }

  get(key) {
    if (!this.dict.has(key)) {
      throw new Error("Clave no encontrada");
    }
    return this.dict.get(key);
  }

  getKeys() {
    return Array.from(this.dict.keys());
  }

  isEmpty() {
    return this.dict.size === 0;
  }
}
