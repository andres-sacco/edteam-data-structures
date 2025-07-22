from structure.dynamic.DynamicStackADT import DynamicStackADT

def multiply_stack_elements(stack, factor):
    aux = DynamicStackADT()
    while not stack.is_empty():
        aux.add(stack.getElement() * factor)
        stack.remove()

    # Restaurar pila
    while not aux.is_empty():
        stack.add(aux.getElement())
        aux.remove()

# Ejemplo de uso
stack = DynamicStackADT()
stack.add(1)
stack.add(2)
stack.add(3)

multiply_stack_elements(stack, 10)

while not stack.is_empty():
    print(stack.getElement())  # 30, 20, 10
    stack.remove()