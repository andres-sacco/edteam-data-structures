import DynamicSetADT from './DynamicSetADT'

class DynamicGraphADT {
  constructor() {
    this.vertices = new DynamicSetADT();
    this.edges = []; // Lista de {from, to, weight}
  }

  getVertxs() {
    return this.vertices;
  }

  addVertx(vertex) {
    this.vertices.add(vertex);
  }

  removeVertx(vertex) {
    this.vertices.remove(vertex);
    this.edges = this.edges.filter(e => e.from !== vertex && e.to !== vertex);
  }

  addEdge(from, to, weight) {
    if (this.vertices.contains(from) && this.vertices.contains(to)) {
      this.edges.push({ from, to, weight });
    }
  }

  removeEdge(from, to) {
    this.edges = this.edges.filter(e => !(e.from === from && e.to === to));
  }

  existsEdge(from, to) {
    return this.edges.some(e => e.from === from && e.to === to);
  }

  edgeWeight(from, to) {
    const edge = this.edges.find(e => e.from === from && e.to === to);
    return edge ? edge.weight : null;
  }

  isEmpty() {
    return this.vertices.isEmpty();
  }
}


export default DynamicGraphADT;
