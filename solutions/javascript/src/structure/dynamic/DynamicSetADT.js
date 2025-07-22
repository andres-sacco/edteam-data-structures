class DynamicSetADT {
  constructor() {
    this.items = [];
  }

  exist(value) {
    return this.items.includes(value);
  }

  choose() {
    if (this.isEmpty()) {
      throw new Error("El conjunto está vacío");
    }
    const index = Math.floor(Math.random() * this.items.length);
    return this.items[index];
  }

  add(value) {
    if (!this.exist(value)) {
      this.items.push(value);
    }
  }

  remove(value) {
    const index = this.items.indexOf(value);
    if (index !== -1) {
      this.items.splice(index, 1);
    }
  }

  isEmpty() {
    return this.items.length === 0;
  }

  mostrar() {
    if (this.isEmpty()) {
      console.log("Conjunto vacío");
      return;
    }

    const copia = [...this.items]; // Copia para no modificar el original
    console.log("Elementos del conjunto:");
    for (const item of copia) {
      console.log(item);
    }
  }
}

export default DynamicSetADT;