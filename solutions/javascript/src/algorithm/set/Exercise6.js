import DynamicSetADT from "../../structure/dynamic/DynamicSetADT.js";

function union(set1, set2) {
  const result = new DynamicSetADT();

  // Agregamos todos los elementos de set1
  while (!set1.isEmpty()) {
    const value = set1.choose();
    result.add(value);
    set1.remove(value);
  }

  // Agregamos todos los elementos de set2
  while (!set2.isEmpty()) {
    const value = set2.choose();
    result.add(value); // `add` ya evita duplicados
    set2.remove(value);
  }

  return result;
}


function intersection(set1, set2) {
  const result = new DynamicSetADT();
  const temp = new DynamicSetADT();

  while (!set1.isEmpty()) {
    const value = set1.choose();
    if (set2.exist(value)) {
      result.add(value);
    }
    temp.add(value); // lo guardamos para no perder set1
    set1.remove(value);
  }

  // Restaurar set1 desde temp
  while (!temp.isEmpty()) {
    const value = temp.choose();
    set1.add(value);
    temp.remove(value);
  }

  return result;
}


const setA = new DynamicSetADT();
[1, 2, 3, 4].forEach(v => setA.add(v));

const setB = new DynamicSetADT();
[3, 4, 5, 6].forEach(v => setB.add(v));

const unionSet = union(setA, setB);
console.log("Unión:");
while (!unionSet.isEmpty()) {
  const value = unionSet.choose();
  console.log(value);
  unionSet.remove(value);
}

const setC = new DynamicSetADT();
[1, 2, 3, 4].forEach(v => setC.add(v));

const setD = new DynamicSetADT();
[3, 4, 5, 6].forEach(v => setD.add(v));

const intersectionSet = intersection(setC, setD);
console.log("Intersección:");
while (!intersectionSet.isEmpty()) {
  const value = intersectionSet.choose();
  console.log(value);
  intersectionSet.remove(value);
}