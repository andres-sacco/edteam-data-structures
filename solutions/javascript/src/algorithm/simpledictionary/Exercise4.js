import DynamicSimpleDictionaryADT from "../../structure/dynamic/DynamicSimpleDictionaryADT.js";

function filterByValueThreshold(dictionary, threshold) {
  const result = new DynamicSimpleDictionaryADT();
  const keys = dictionary.getKeys();
  while (!keys.isEmpty()) {
    const key = keys.choose();
    keys.remove(key);
    const value = dictionary.get(key);
    if (value > threshold) {
      result.add(key, value);
    }
  }
  return result;
}


const dict = new DynamicSimpleDictionaryADT();
dict.add(1, 10);
dict.add(2, 25);
dict.add(3, 5);
dict.add(4, 30);

const filtrado = filterByValueThreshold(dict, 20);
filtrado.getKeys().mostrar();  // Suponiendo que el DynamicSetADT tenga un método mostrar()

// O para mostrar manualmente:
const clavesFiltradas = filtrado.getKeys();
while (!clavesFiltradas.isEmpty()) {
  const clave = clavesFiltradas.choose();
  clavesFiltradas.remove(clave);
  console.log(`Clave: ${clave}, Valor: ${filtrado.get(clave)}`);
}