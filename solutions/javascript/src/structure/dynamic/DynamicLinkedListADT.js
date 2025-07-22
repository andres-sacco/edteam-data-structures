class Node {
  constructor(value) {
    this.value = value;
    this.next = null;
  }
}

class DynamicLinkedListADT {
  constructor() {
    this.head = null;
    this.length = 0;
  }

  // Agrega al final
  add(value) {
    const newNode = new Node(value);
    if (!this.head) {
      this.head = newNode;
    } else {
      let actual = this.head;
      while (actual.next) {
        actual = actual.next;
      }
      actual.next = newNode;
    }
    this.length++;
  }

  // Inserta en un índice
  insert(index, value) {
    if (index < 0 || index > this.length) {
      throw new Error("Índice fuera de rango");
    }

    const newNode = new Node(value);

    if (index === 0) {
      newNode.next = this.head;
      this.head = newNode;
    } else {
      let actual = this.head;
      for (let i = 0; i < index - 1; i++) {
        actual = actual.next;
      }
      newNode.next = actual.next;
      actual.next = newNode;
    }

    this.length++;
  }

  // Elimina por índice
  remove(index) {
    if (index < 0 || index >= this.length) {
      throw new Error("Índice fuera de rango");
    }

    if (index === 0) {
      this.head = this.head.next;
    } else {
      let actual = this.head;
      for (let i = 0; i < index - 1; i++) {
        actual = actual.next;
      }
      actual.next = actual.next.next;
    }

    this.length--;
  }

  // Obtiene valor por índice
  get(index) {
    if (index < 0 || index >= this.length) {
      throw new Error("Índice fuera de rango");
    }

    let actual = this.head;
    for (let i = 0; i < index; i++) {
      actual = actual.next;
    }
    return actual.value;
  }

  // Retorna el tamaño
  size() {
    return this.length;
  }

  // Comprueba si está vacía
  isEmpty() {
    return this.length === 0;
  }
}

export default DynamicLinkedListADT;