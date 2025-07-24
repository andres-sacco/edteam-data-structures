import DynamicMultipleDictionaryADT from "../../structure/dynamic/DynamicMultipleDictionaryADT.js";


function filtrarPorRango(diccionario, minimo, maximo) {
  const resultado = new DynamicMultipleDictionaryADT();
  const claves = diccionario.getKeys();

  for (let i = 0; i < claves.length; i++) {
    const clave = claves[i];

    try {
      const valores = diccionario.get(clave);
      for (let j = 0; j < valores.length; j++) {
        const valor = valores[j];
        if (valor >= minimo && valor <= maximo) {
          resultado.add(clave, valor);
        }
      }
    } catch (_) {
      // ignorar si la clave no existe (no debería ocurrir)
    }
  }

  return resultado;
}


const diccionario = new DynamicMultipleDictionaryADT();
diccionario.add(1, 10);
diccionario.add(1, 20);
diccionario.add(2, 5);
diccionario.add(2, 30);
diccionario.add(3, 100);

const filtrado = filtrarPorRango(diccionario, 10, 30);
const clavesFiltradas = filtrado.getKeys();

for (let i = 0; i < clavesFiltradas.length; i++) {
  const clave = clavesFiltradas[i];
  const valores = filtrado.get(clave);
  console.log(`Clave ${clave}: ${valores.join(', ')}`);
}
