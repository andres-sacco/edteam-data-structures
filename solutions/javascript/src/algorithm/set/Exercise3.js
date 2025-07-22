import DynamicSetADT from "../../structure/dynamic/DynamicSetADT.js";

function filterGreaterThan(originalSet, threshold) {
  const result = new DynamicSetADT();

  while (!originalSet.isEmpty()) {
    const value = originalSet.choose();
    if (value > threshold) {
      result.add(value);
    }
    originalSet.remove(value);
  }

  return result;
}


const mySet = new DynamicSetADT();
[5, 3, 8, 1, 6].forEach(v => mySet.add(v));

const filteredSet = filterGreaterThan(mySet, 4);

console.log("Elementos mayores a 4:");
while (!filteredSet.isEmpty()) {
  const val = filteredSet.choose();
  console.log(val);
  filteredSet.remove(val);
}