import DynamicStackADT from "../../structure/dynamic/DynamicStackADT.js";

function countStack(stack) {
  const aux = new DynamicStackADT();
  let count = 0;

  while (!stack.isEmpty()) {
    aux.add(stack.getElement());
    stack.remove();
    count++;
  }

  while (!aux.isEmpty()) {
    stack.add(aux.getElement());
    aux.remove();
  }

  return count;
}

// Ejemplo de uso
const stack = new DynamicStackADT();
stack.add(10);
stack.add(20);
stack.add(30);

console.log("Cantidad de elementos:", countStack(stack)); // → 3

// Mostrar contenido
while (!stack.isEmpty()) {
  console.log(stack.getElement());
  stack.remove();
}
