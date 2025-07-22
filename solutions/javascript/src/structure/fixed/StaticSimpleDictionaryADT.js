class StaticSimpleDictionaryADT {
  constructor(capacity) {
    this.capacity = capacity;
    this.data = new Array(capacity).fill(null); // cada elemento será { key, value }
    this.size = 0;
  }

  add(key, value) {
    for (let i = 0; i < this.size; i++) {
      if (this.data[i].key === key) {
        this.data[i].value = value; // pisa el contenido
        return;
      }
    }

    if (this.size >= this.capacity) {
      throw new Error("Capacidad máxima alcanzada");
    }

    this.data[this.size] = { key, value };
    this.size++;
  }

  remove(key) {
    for (let i = 0; i < this.size; i++) {
      if (this.data[i].key === key) {
        // desplazamos los siguientes elementos hacia la izquierda
        for (let j = i; j < this.size - 1; j++) {
          this.data[j] = this.data[j + 1];
        }
        this.data[this.size - 1] = null;
        this.size--;
        return;
      }
    }
  }

  get(key) {
    for (let i = 0; i < this.size; i++) {
      if (this.data[i].key === key) {
        return this.data[i].value;
      }
    }
    throw new Error("Clave no encontrada");
  }

  getKeys() {
    const keysSet = new StaticSetADT(this.capacity);
    for (let i = 0; i < this.size; i++) {
      keysSet.add(this.data[i].key);
    }
    return keysSet;
  }

  isEmpty() {
    return this.size === 0;
  }
}
