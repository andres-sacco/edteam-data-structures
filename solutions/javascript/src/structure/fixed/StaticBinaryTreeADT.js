class StaticBinaryTreeADT {
  constructor(capacity) {
    this.capacity = capacity;
    this.tree = new Array(capacity).fill(null);
    this.size = 0;
  }

  getRoot() {
    return this.tree[0];
  }

  getLeft(index = 0) {
    const leftIndex = 2 * index + 1;
    return leftIndex < this.capacity ? this.tree[leftIndex] : null;
  }

  getRight(index = 0) {
    const rightIndex = 2 * index + 2;
    return rightIndex < this.capacity ? this.tree[rightIndex] : null;
  }

  isEmpty() {
    return this.size === 0;
  }

  add(value) {
    if (this.size >= this.capacity) throw new Error("Tree is full");
    this.tree[this.size++] = value;
  }

  remove(value) {
    const index = this.tree.indexOf(value);
    if (index === -1) return;

    // Move last element to removed position and shrink size
    this.tree[index] = this.tree[this.size - 1];
    this.tree[this.size - 1] = null;
    this.size--;
  }
}
