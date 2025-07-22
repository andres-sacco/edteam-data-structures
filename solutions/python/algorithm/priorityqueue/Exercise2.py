from structure.dynamic.DynamicPriorityQueueADT import DynamicPriorityQueueADT


def eliminar_por_prioridad(cola, prioridad_objetivo):
    aux = DynamicPriorityQueueADT()

    while not cola.is_empty():
        valor = cola.get_element()
        prioridad = cola.get_priority()
        cola.remove()
        if prioridad != prioridad_objetivo:
            aux.add(valor, prioridad)

    while not aux.is_empty():
        cola.add(aux.get_element(), aux.get_priority())
        aux.remove()

# Ejemplo de uso
cola = DynamicPriorityQueueADT()
cola.add(10, 2)
cola.add(20, 3)
cola.add(30, 2)
cola.add(40, 1)

eliminar_por_prioridad(cola, 2)

while not cola.is_empty():
    print(f"Valor: {cola.get_element()}, Prioridad: {cola.get_priority()}")
    cola.remove()