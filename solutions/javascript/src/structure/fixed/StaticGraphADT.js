class StaticGraphADT {
  constructor(maxVertices = 10) {
    this.maxVertices = maxVertices;
    this.vertices = new Array(maxVertices).fill(null); // posiciones ocupadas por vértices o null
    this.adjMatrix = Array.from({ length: maxVertices }, () =>
      new Array(maxVertices).fill(0)
    );
  }

  findIndex(vertex) {
    return this.vertices.indexOf(vertex);
  }

  addVertx(vertex) {
    if (this.findIndex(vertex) !== -1) return;
    const index = this.vertices.indexOf(null);
    if (index !== -1) this.vertices[index] = vertex;
  }

  removeVertx(vertex) {
    const idx = this.findIndex(vertex);
    if (idx === -1) return;
    this.vertices[idx] = null;
    for (let i = 0; i < this.maxVertices; i++) {
      this.adjMatrix[idx][i] = 0;
      this.adjMatrix[i][idx] = 0;
    }
  }

  addEdge(from, to, weight) {
    const i = this.findIndex(from);
    const j = this.findIndex(to);
    if (i !== -1 && j !== -1) this.adjMatrix[i][j] = weight;
  }

  removeEdge(from, to) {
    const i = this.findIndex(from);
    const j = this.findIndex(to);
    if (i !== -1 && j !== -1) this.adjMatrix[i][j] = 0;
  }

  existsEdge(from, to) {
    const i = this.findIndex(from);
    const j = this.findIndex(to);
    return i !== -1 && j !== -1 && this.adjMatrix[i][j] !== 0;
  }

  edgeWeight(from, to) {
    const i = this.findIndex(from);
    const j = this.findIndex(to);
    if (i !== -1 && j !== -1) return this.adjMatrix[i][j];
    return null;
  }

  getVertxs() {
    const set = new SetADT();
    for (const v of this.vertices) if (v !== null) set.add(v);
    return set;
  }

  isEmpty() {
    return this.vertices.every(v => v === null);
  }
}

export default StaticGraphADT;