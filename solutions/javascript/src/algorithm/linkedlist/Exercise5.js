import DynamicLinkedListADT from "../../structure/dynamic/DynamicLinkedListADT.js";

function printList(linkedList) {
  const elements = [];
  for (let i = 0; i < linkedList.size(); i++) {
    elements.push(linkedList.get(i));
  }
  console.log(elements);
}

function reverse(linkedList) {
    const reversed = new DynamicLinkedListADT(); // Suponiendo que tenés una clase LinkedList creada

    for (let i = linkedList.size() - 1; i >= 0; i--) {
        reversed.add(linkedList.get(i));
    }

    return reversed;
}

const lista = new DynamicLinkedListADT();
lista.add(10);
lista.add(20);
lista.add(30);

console.log("Lista original");
printList(lista); // Salida: [10, 20, 30]

reverse(lista);
console.log("Lista revertida");
printList(lista); // Salida: [30, 20, 10]