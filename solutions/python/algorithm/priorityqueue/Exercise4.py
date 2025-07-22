from structure.dynamic.DynamicPriorityQueueADT import DynamicPriorityQueueADT


def filtrar_por_prioridad(cola, prioridad_minima):
    resultado = DynamicPriorityQueueADT()
    aux = DynamicPriorityQueueADT()

    while not cola.is_empty():
        valor = cola.get_element()
        prioridad = cola.get_priority()
        cola.remove()
        aux.add(valor, prioridad)

        if prioridad >= prioridad_minima:
            resultado.add(valor, prioridad)

    # Restaurar cola original
    while not aux.is_empty():
        valor = aux.get_element()
        prioridad = aux.get_priority()
        aux.remove()
        cola.add(valor, prioridad)

    return resultado


# Ejemplo de uso
cola = DynamicPriorityQueueADT()
cola.add(10, 2)
cola.add(20, 3)
cola.add(30, 2)
cola.add(40, 1)

resultado = filtrar_por_prioridad(cola, 3)

while not resultado.is_empty():
    print(f"Valor: {resultado.get_element()}, Prioridad: {resultado.get_priority()}")
    resultado.remove()