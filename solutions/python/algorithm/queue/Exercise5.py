from structure.dynamic.DynamicQueueADT import DynamicQueueADT

def es_capicua(cola: DynamicQueueADT) -> bool:
    # Copiamos los valores de la cola en una lista
    valores = []
    auxiliar = DynamicQueueADT()

    while not cola.is_empty():
        valor = cola.getElement()
        valores.append(valor)
        auxiliar.add(valor)
        cola.remove()

    # Restauramos la cola original
    while not auxiliar.is_empty():
        cola.add(auxiliar.getElement())
        auxiliar.remove()

    # Verificamos si la lista es igual a su reversa
    return valores == valores[::-1]


# Ejemplo de uso:
cola = DynamicQueueADT()
for valor in [1, 2, 3, 2, 1]:
    cola.add(valor)

cola.mostrar()
print("¿Es capicúa?", es_capicua(cola))  # True
cola.mostrar()  # Se mantiene intacta
