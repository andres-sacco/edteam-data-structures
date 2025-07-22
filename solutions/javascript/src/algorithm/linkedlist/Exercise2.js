import DynamicLinkedListADT from "../../structure/dynamic/DynamicLinkedListADT.js";


function printList(linkedList) {
  const elements = [];
  for (let i = 0; i < linkedList.size(); i++) {
    elements.push(linkedList.get(i));
  }
  console.log(elements);
}

function removeLast(linkedList, n) {
    const totalSize = linkedList.size();

    if (n >= totalSize) {
        for (let i = totalSize - 1; i >= 0; i--) {
            linkedList.remove(i);
        }
    } else {
        for (let i = 0; i < n; i++) {
            linkedList.remove(linkedList.size() - 1);
        }
    }
}


const lista = new DynamicLinkedListADT();
lista.add(10);
lista.add(20);
lista.add(30);

console.log("Lista original");
printList(lista); // Salida: [10, 20, 30]

removeLast(lista,2);
console.log("Lista con eliminados");
printList(lista); // Salida: [10]