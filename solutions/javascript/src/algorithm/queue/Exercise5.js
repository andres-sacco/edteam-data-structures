import DynamicQueueADT from "../../structure/dynamic/DynamicQueueADT.js";

function esCapicua(cola) {
  const valores = [];
  const auxiliar = new DynamicQueueADT();

  // Extraer elementos y guardarlos en una lista
  while (!cola.isEmpty()) {
    const valor = cola.getElement();
    valores.push(valor);
    auxiliar.add(valor);
    cola.remove();
  }

  // Restaurar la cola original
  while (!auxiliar.isEmpty()) {
    cola.add(auxiliar.getElement());
    auxiliar.remove();
  }

  // Verificar si los valores son capicúa
  const invertido = [...valores].reverse();
  return JSON.stringify(valores) === JSON.stringify(invertido);
}

// Ejemplo de uso
const cola = new DynamicQueueADT();
[1, 2, 3, 2, 1].forEach(valor => cola.add(valor));

console.log("¿Es capicúa?", esCapicua(cola)); // true