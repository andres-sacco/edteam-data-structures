import DynamicQueueADT from "../../structure/dynamic/DynamicQueueADT.js";

function copiarCola(original) {
  const copia = new DynamicQueueADT();
  const temp = [];

  while (!original.isEmpty()) {
    const val = original.getElement();
    original.remove();
    copia.add(val);
    temp.push(val);
  }

  for (const val of temp) {
    original.add(val);
  }

  return copia;
}

function elementosEnComun(cola1, cola2) {
  const copia1 = copiarCola(cola1);
  const copia2 = copiarCola(cola2);
  const resultado = new DynamicQueueADT();

  while (!copia1.isEmpty()) {
    const actual = copia1.getElement();
    copia1.remove();

    const temp = new DynamicQueueADT();
    let encontrado = false;

    while (!copia2.isEmpty()) {
      const val = copia2.getElement();
      copia2.remove();
      if (val === actual && !encontrado) {
        resultado.add(val);
        encontrado = true;
      }
      temp.add(val);
    }

    while (!temp.isEmpty()) {
      copia2.add(temp.getElement());
      temp.remove();
    }
  }

  return resultado;
}


// Suponiendo que DynamicQueueADT tiene métodos: add, remove, getElement, isEmpty

const cola1 = new DynamicQueueADT();
cola1.add(1);
cola1.add(2);
cola1.add(3);
cola1.add(4);

const cola2 = new DynamicQueueADT();
cola2.add(3);
cola2.add(4);
cola2.add(5);
cola2.add(6);

const comun = elementosEnComun(cola1, cola2);

let salida = "Elementos en común: ";
while (!comun.isEmpty()) {
  salida += comun.getElement() + " ";
  comun.remove();
}

console.log(salida);
