import DynamicMultipleDictionaryADT from "../../structure/dynamic/DynamicMultipleDictionaryADT.js";
import DynamicSimpleDictionaryADT from "../../structure/dynamic/DynamicSimpleDictionaryADT.js";
import DynamicSetADT from "../../structure/dynamic/DynamicSetADT.js";

function invertSimpleToMultiple(simpleDict) {
  const multiple = new DynamicMultipleDictionaryADT();
  const keys = simpleDict.getKeys(); // DynamicSetADT

  while (!keys.isEmpty()) {
    const key = keys.choose();
    keys.remove(key);
    const value = simpleDict.get(key);
    multiple.add(value, key); // Invertimos valor → clave
  }

  return multiple;
}


const simple = new DynamicSimpleDictionaryADT();
simple.add(1, 10);
simple.add(2, 20);
simple.add(3, 10);
simple.add(4, 30);

const multiple = invertSimpleToMultiple(simple);
const keys = multiple.getKeys();

while (!keys.isEmpty()) {
  const value = keys.choose();
  keys.remove(value);

  const originalKeys = multiple.get(value); // Esto es un DynamicSetADT

  // Recorremos el conjunto sin usar arrays
  const temp = new DynamicSetADT();
  let output = `${value} -> `;

  while (!originalKeys.isEmpty()) {
    const k = originalKeys.choose();
    output += k + " ";
    originalKeys.remove(k);
    temp.add(k); // Guardamos para restaurar luego
  }

  console.log(output.trim());

  // Restauramos el conjunto
  while (!temp.isEmpty()) {
    const k = temp.choose();
    temp.remove(k);
    originalKeys.add(k);
  }
}