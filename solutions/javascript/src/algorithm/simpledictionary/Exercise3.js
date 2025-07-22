import DynamicSimpleDictionaryADT from "../../structure/dynamic/DynamicSimpleDictionaryADT.js";


function sumKeyTimesValue(dictionary) {
  let suma = 0;
  const claves = dictionary.getKeys();
  while (!claves.isEmpty()) {
    const clave = claves.choose();
    claves.remove(clave);
    const valor = dictionary.get(clave);
    suma += clave * valor;
  }

  return suma;
}


const dict = new DynamicSimpleDictionaryADT();
dict.add(2, 5);  // 2 * 5 = 10
dict.add(3, 4);  // 3 * 4 = 12
dict.add(4, 3);  // 4 * 3 = 12

const resultado = sumKeyTimesValue(dict);
console.log("Resultado:", resultado);  // Resultado: 34