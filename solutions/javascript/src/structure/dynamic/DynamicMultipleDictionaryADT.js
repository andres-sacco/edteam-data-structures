import DynamicSetADT from "../../structure/dynamic/DynamicSetADT.js";

class KeyNode {
  constructor(key, valueSet, next = null) {
    this.key = key;
    this.valueSet = valueSet;
    this.next = next;
  }
}

class DynamicMultipleDictionaryADT {
  constructor() {
    this.head = null;
  }

  add(key, value) {
    let current = this.head;

    while (current !== null) {
      if (current.key === key) {
        current.valueSet.add(value);
        return;
      }
      current = current.next;
    }

    const newSet = new DynamicSetADT();
    newSet.add(value);
    this.head = new KeyNode(key, newSet, this.head);
  }

  remove(key) {
    if (this.head === null) return;

    if (this.head.key === key) {
      this.head = this.head.next;
      return;
    }

    let prev = this.head;
    let current = this.head.next;

    while (current !== null) {
      if (current.key === key) {
        prev.next = current.next;
        return;
      }
      prev = current;
      current = current.next;
    }
  }

  removeValue(key, value) {
    let current = this.head;

    while (current !== null) {
      if (current.key === key) {
        current.valueSet.remove(value);
        if (current.valueSet.isEmpty()) {
          this.remove(key);
        }
        return;
      }
      current = current.next;
    }
  }

  get(key) {
    let current = this.head;

    while (current !== null) {
      if (current.key === key) {
        return current.valueSet; // Devuelve el DynamicSetADT
      }
      current = current.next;
    }

    throw new Error("Clave no encontrada");
  }

  getKeys() {
    const keys = new DynamicSetADT();
    let current = this.head;

    while (current !== null) {
      keys.add(current.key);
      current = current.next;
    }

    return keys;
  }

  isEmpty() {
    return this.head === null;
  }
}

export default DynamicMultipleDictionaryADT;
