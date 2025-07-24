import DynamicBinaryTreeADT from "../../structure/dynamic/DynamicBinaryTreeADT.js";

function countNodes(tree) {
  if (!tree || tree.isEmpty()) {
    return 0;
  }
  return 1 + countNodes(tree.getLeft()) + countNodes(tree.getRight());
}


// Ejemplo de ejecución
const tree = new DynamicBinaryTreeADT();
tree.add(10);
tree.add(5);
tree.add(15);

console.log("Cantidad de nodos:", countNodes(tree)); // Salida: 3