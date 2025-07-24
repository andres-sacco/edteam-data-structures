import DynamicBinaryTreeADT from "../../structure/dynamic/DynamicBinaryTreeADT.js";

function isPrefix(a, b) {
  if (!a || a.isEmpty()) {
    return true;
  }
  if (!b || b.isEmpty()) {
    return false;
  }
  if (a.getRoot() !== b.getRoot()) {
    return false;
  }
  return isPrefix(a.getLeft(), b.getLeft()) && isPrefix(a.getRight(), b.getRight());
}


// Prueba
const tree1 = new DynamicBinaryTreeADT();
tree1.add(10);
tree1.add(5);

const tree2 = new DynamicBinaryTreeADT();
tree2.add(10);
tree2.add(5);
tree2.add(15);

console.log("Tree1 es prefijo de Tree2? ", isPrefix(tree1, tree2)); // true
console.log("Tree2 es prefijo de Tree1? ", isPrefix(tree2, tree1)); // false