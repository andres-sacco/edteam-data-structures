import DynamicMultipleDictionaryADT from "../../structure/dynamic/DynamicMultipleDictionaryADT.js";
import DynamicSetADT from "../../structure/dynamic/DynamicSetADT.js";

function sumarDiccionarios(d1, d2) {
  const resultado = new DynamicMultipleDictionaryADT();
  const claves = new DynamicSetADT();

  // Agregar claves del primer diccionario
  const claves1 = d1.getKeys();
  for (let i = 0; i < claves1.length; i++) {
    claves.add(claves1[i]);
  }

  // Agregar claves del segundo diccionario (sin repetir)
  const claves2 = d2.getKeys();
  for (let i = 0; i < claves2.length; i++) {
    claves.add(claves2[i]);
  }

  // Procesar cada clave del conjunto
  while (!claves.isEmpty()) {
    const clave = claves.choose();
    claves.remove(clave);

    let suma = 0;

    try {
      const valores1 = d1.get(clave);
      for (let i = 0; i < valores1.length; i++) {
        suma += valores1[i];
      }
    } catch (_) {}

    try {
      const valores2 = d2.get(clave);
      for (let i = 0; i < valores2.length; i++) {
        suma += valores2[i];
      }
    } catch (_) {}

    resultado.add(clave, suma);
  }

  return resultado;
}

const d1 = new DynamicMultipleDictionaryADT();
d1.add(1, 10);
d1.add(1, 20);
d1.add(2, 5);

const d2 = new DynamicMultipleDictionaryADT();
d2.add(1, 5);
d2.add(3, 100);

const resultado = sumarDiccionarios(d1, d2);

const clavesRes = resultado.getKeys();
for (let i = 0; i < clavesRes.length; i++) {
  const clave = clavesRes[i];
  const valores = resultado.get(clave);
  console.log(`Clave ${clave}: ${valores.join(', ')}`);
}
