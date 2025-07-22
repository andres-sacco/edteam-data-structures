class StaticMultipleDictionaryADT {
  constructor(maxKeys = 100, maxValuesPerKey = 10) {
    this.maxKeys = maxKeys;
    this.maxValuesPerKey = maxValuesPerKey;
    this.keys = new Array(maxKeys).fill(null);
    this.values = new Array(maxKeys).fill(null).map(() => []);
    this.size = 0;
  }

  add(key, value) {
    let index = this.keys.indexOf(key);
    if (index === -1) {
      if (this.size >= this.maxKeys) {
        console.warn("Capacidad de claves alcanzada");
        return;
      }
      index = this.size++;
      this.keys[index] = key;
    }

    const currentValues = this.values[index];
    if (!currentValues.includes(value)) {
      if (currentValues.length >= this.maxValuesPerKey) {
        console.warn("Capacidad de valores alcanzada para la clave:", key);
        return;
      }
      currentValues.push(value);
    }
  }

  remove(key) {
    const index = this.keys.indexOf(key);
    if (index !== -1) {
      this.keys.splice(index, 1);
      this.values.splice(index, 1);
      this.size--;
      this.keys.push(null);
      this.values.push([]);
    }
  }

  removeValue(key, value) {
    const index = this.keys.indexOf(key);
    if (index !== -1) {
      const valIndex = this.values[index].indexOf(value);
      if (valIndex !== -1) {
        this.values[index].splice(valIndex, 1);
      }
    }
  }

  get(key) {
    const index = this.keys.indexOf(key);
    if (index !== -1) {
      return this.values[index];
    }
    throw new Error("Clave no encontrada");
  }

  getKeys() {
    return this.keys.filter(k => k !== null);
  }

  isEmpty() {
    return this.size === 0;
  }
}

export default StaticMultipleDictionaryADT;