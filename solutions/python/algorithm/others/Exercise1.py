from structure.dynamic.DynamicLinkedListADT import DynamicLinkedListADT
from structure.dynamic.DynamicQueueADT import DynamicQueueADT
from structure.dynamic.DynamicStackADT import DynamicStackADT

def combine_sorted(stack, queue):
    temp_list = DynamicLinkedListADT()
    temp_stack = DynamicStackADT()
    temp_queue = DynamicQueueADT()
    result_queue = DynamicQueueADT()

    # Extraer elementos de la pila
    while not stack.is_empty():
        value = stack.getElement()
        stack.remove()
        temp_list.add(value)
        temp_stack.add(value)

    # Restaurar pila
    while not temp_stack.is_empty():
        value = temp_stack.getElement()
        temp_stack.remove()
        stack.add(value)

    # Extraer elementos de la cola
    while not queue.is_empty():
        value = queue.getElement()
        queue.remove()
        temp_list.add(value)
        temp_queue.add(value)

    # Restaurar cola
    while not temp_queue.is_empty():
        value = temp_queue.getElement()
        temp_queue.remove()
        queue.add(value)

    # Obtener elementos, ordenarlos, y cargarlos en la nueva cola
    values = [temp_list.get(i) for i in range(temp_list.size())]
    values.sort()

    for val in values:
        result_queue.add(val)

    return result_queue



stack = DynamicStackADT()
queue = DynamicQueueADT()

# Agregar a la pila: 5 (bottom), 1, 9 (top)
stack.add(5)
stack.add(1)
stack.add(9)

# Agregar a la cola: 7 (front), 2, 3 (rear)
queue.add(7)
queue.add(2)
queue.add(3)

result = combine_sorted(stack, queue)

print("Cola resultante ordenada:")
while not result.is_empty():
    print(result.getElement(), end=" ")
    result.remove()
print()

print("Pila original:")
while not stack.is_empty():
    print(stack.getElement(), end=" ")
    stack.remove()
print()

print("Cola original:")
while not queue.is_empty():
    print(queue.getElement(), end=" ")
    queue.remove()
print()


