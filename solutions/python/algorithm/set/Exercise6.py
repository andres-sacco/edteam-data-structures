from structure.dynamic.DynamicSetADT import DynamicSetADT


def intersection(set_a, set_b):
    result = DynamicSetADT()
    while not set_a.isEmpty():
        value = set_a.choose()
        if set_b.exist(value):
            result.add(value)
        set_a.remove(value)
    return result

def union(set_a, set_b):
    result = DynamicSetADT()
    while not set_a.isEmpty():
        value = set_a.choose()
        result.add(value)
        set_a.remove(value)

    while not set_b.isEmpty():
        value = set_b.choose()
        result.add(value)
        set_b.remove(value)

    return result

# Crear dos conjuntos
a = DynamicSetADT()
b = DynamicSetADT()

for v in [1, 2, 3]:
    a.add(v)
for v in [2, 3, 4]:
    b.add(v)

inter = intersection(a, b)
print("Intersección:")
while not inter.isEmpty():
    val = inter.choose()
    print(val, end=" ")
    inter.remove(val)

# Re-crear los conjuntos porque los anteriores fueron destruidos
a = DynamicSetADT()
b = DynamicSetADT()
for v in [1, 2, 3]:
    a.add(v)
for v in [2, 3, 4]:
    b.add(v)

un = union(a, b)
print("\nUnión:")
while not un.isEmpty():
    val = un.choose()
    print(val, end=" ")
    un.remove(val)