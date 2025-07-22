from structure.dynamic.DynamicSetADT import DynamicSetADT


def filter_greater_than(original_set, threshold):
    result = DynamicSetADT()
    while not original_set.isEmpty():
        value = original_set.choose()
        if value > threshold:
            result.add(value)
        original_set.remove(value)
    return result


# Crear conjunto original
my_set = DynamicSetADT()
for val in [5, 3, 8, 1, 6]:
    my_set.add(val)

# Filtrar valores mayores a 4
filtered_set = filter_greater_than(my_set, 4)

print("Elementos mayores a 4:")
while not filtered_set.isEmpty():
    val = filtered_set.choose()
    print(val, end=" ")
    filtered_set.remove(val)