import DynamicStackADT from "../../structure/dynamic/DynamicStackADT.js";

function multiplyStackElements(stack, factor) {
  const aux = new DynamicStackADT();
  while (!stack.isEmpty()) {
        aux.add(stack.getElement() * factor);
        stack.remove();
  }

  // Restaurar la pila original con los valores modificados
  while (!aux.isEmpty()) {
        stack.add(aux.getElement());
        aux.remove();
  }
}

// Ejemplo de uso
const stack = new DynamicStackADT();
stack.add(1);
stack.add(2);
stack.add(3);

multiplyStackElements(stack, 10);

// Mostrar pila
while (!stack.isEmpty()) {
    console.log(stack.getElement()); // 30, 20, 10
    stack.remove();
}