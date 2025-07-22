from structure.dynamic.DynamicStackADT import DynamicStackADT

def count_stack(stack):
    aux = DynamicStackADT()
    count = 0

    while not stack.is_empty():
        aux.add(stack.getElement())
        stack.remove()
        count += 1

    while not aux.is_empty():
        stack.add(aux.getElement())
        aux.remove()

    return count

# Ejemplo de uso
stack = DynamicStackADT()
stack.add(10)
stack.add(20)
stack.add(30)

print("Cantidad de elementos:", count_stack(stack))  # → 3

# Mostrar el contenido (verificar que quedó igual)
while not stack.is_empty():
    print(stack.getElement())
    stack.remove()