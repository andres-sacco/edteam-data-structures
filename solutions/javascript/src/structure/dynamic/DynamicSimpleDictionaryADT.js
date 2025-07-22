import DynamicSetADT from "./DynamicSetADT.js";

class DynamicSimpleDictionaryADT {
  constructor() {
    this.data = {};
  }

  add(key, value) {
    this.data[key] = value;
  }

  remove(key) {
    delete this.data[key];
  }

  get(key) {
    if (!(key in this.data)) throw new Error("La clave no existe.");
    return this.data[key];
  }

  getKeys() {
    const keysSet = new DynamicSetADT();
    for (const key of Object.keys(this.data)) {
      keysSet.add(parseInt(key));
    }
    return keysSet;
  }

  isEmpty() {
    return Object.keys(this.data).length === 0;
  }
}

export default DynamicSimpleDictionaryADT;
