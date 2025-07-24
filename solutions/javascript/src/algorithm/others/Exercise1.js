import DynamicLinkedListADT from "../../structure/dynamic/DynamicLinkedListADT.js";
import DynamicStackADT from "../../structure/dynamic/DynamicStackADT.js";
import DynamicQueueADT from "../../structure/dynamic/DynamicQueueADT.js";

function insertOrdered(list, value) {
  if (list.isEmpty()) {
    list.add(value);
    return;
  }
  let i = 0;
  while (i < list.size() && list.get(i) < value) {
    i++;
  }
  list.insert(i, value);
}

function combineSorted(stack, queue) {
  const tempList = new DynamicLinkedListADT();
  const tempStack = new DynamicStackADT();
  const tempQueue = new DynamicQueueADT();
  const resultQueue = new DynamicQueueADT();

  // Extraer elementos de pila y guardarlos en tempList ordenadamente
  while (!stack.isEmpty()) {
    const val = stack.getElement();
    stack.remove();
    insertOrdered(tempList, val);
    tempStack.add(val);
  }
  // Restaurar pila
  while (!tempStack.isEmpty()) {
    const val = tempStack.getElement();
    tempStack.remove();
    stack.add(val);
  }

  // Extraer elementos de cola y guardarlos en tempList ordenadamente
  while (!queue.isEmpty()) {
    const val = queue.getElement();
    queue.remove();
    insertOrdered(tempList, val);
    tempQueue.add(val);
  }
  // Restaurar cola
  while (!tempQueue.isEmpty()) {
    const val = tempQueue.getElement();
    tempQueue.remove();
    queue.add(val);
  }

  // Agregar ordenadamente a la cola resultado
  for (let i = 0; i < tempList.size(); i++) {
    resultQueue.add(tempList.get(i));
  }

  return resultQueue;
}


const stack = new DynamicStackADT();
const queue = new DynamicQueueADT();

// Datos para pila
stack.add(5);
stack.add(1);
stack.add(9);

// Datos para cola
queue.add(7);
queue.add(2);
queue.add(3);

const resultQueue = combineSorted(stack, queue);

console.log("Cola resultante ordenada:");
while (!resultQueue.isEmpty()) {
    console.log(resultQueue.getElement());
    resultQueue.remove();
}

console.log("Pila original:");
while (!stack.isEmpty()) {
    console.log(stack.getElement());
    stack.remove();
}

console.log("Cola original:");
while (!queue.isEmpty()) {
    console.log(queue.getElement());
    queue.remove();
}