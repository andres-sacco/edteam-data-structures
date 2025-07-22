class BinaryTreeNode {
  constructor(value) {
    this.value = value;
    this.left = null;
    this.right = null;
  }
}

class DynamicBinaryTreeADT {
  constructor() {
    this.root = null;
  }

  getRoot() {
    return this.root ? this.root.value : null;
  }

  getLeft() {
    return this.root ? this.root.left : null;
  }

  getRight() {
    return this.root ? this.root.right : null;
  }

  isEmpty() {
    return this.root === null;
  }

  add(value) {
    this.root = this.#addRecursive(this.root, value);
  }

  #addRecursive(node, value) {
    if (node === null) return new BinaryTreeNode(value);

    if (value < node.value) {
      node.left = this.#addRecursive(node.left, value);
    } else {
      node.right = this.#addRecursive(node.right, value);
    }
    return node;
  }

  remove(value) {
    this.root = this.#removeRecursive(this.root, value);
  }

  #removeRecursive(node, value) {
    if (node === null) return null;

    if (value < node.value) {
      node.left = this.#removeRecursive(node.left, value);
    } else if (value > node.value) {
      node.right = this.#removeRecursive(node.right, value);
    } else {
      // Nodo con un solo hijo o sin hijos
      if (node.left === null) return node.right;
      if (node.right === null) return node.left;

      // Nodo con dos hijos: obtener el mínimo del subárbol derecho
      let minLargerNode = this.#getMin(node.right);
      node.value = minLargerNode.value;
      node.right = this.#removeRecursive(node.right, minLargerNode.value);
    }
    return node;
  }

  #getMin(node) {
    while (node.left !== null) node = node.left;
    return node;
  }
}
