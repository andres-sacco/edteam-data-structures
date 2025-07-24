from structure.dynamic.DynamicMultipleDictionaryADT import DynamicMultipleDictionaryADT
from structure.dynamic.DynamicSetADT import DynamicSetADT
from structure.dynamic.DynamicSimpleDictionaryADT import DynamicSimpleDictionaryADT


def invert_simple_to_multiple(simple_dict):
    result = DynamicMultipleDictionaryADT()
    keys = simple_dict.get_keys()  # Esto es un SetADT
    temp = DynamicSetADT()

    while not keys.isEmpty():
        key = keys.choose()

        value = simple_dict.get(key)
        result.add(key, value)

        keys.remove(key)
        temp.add(key)

    # Restaurar el conjunto original
    while not temp.isEmpty():
        key = temp.choose()
        temp.remove(key)
        keys.add(key)

    return result


simple = DynamicSimpleDictionaryADT()
simple.add(1, 10)
simple.add(2, 20)
simple.add(3, 10)
simple.add(4, 30)

multiple = invert_simple_to_multiple(simple)

keys = multiple.get_keys()
for value in keys.get_all():
    original_keys = multiple.get(value)
    print(f"{value} -> {original_keys}")

