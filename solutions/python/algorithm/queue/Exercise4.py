from structure.dynamic.DynamicQueueADT import DynamicQueueADT

def elementos_en_comun(cola1: DynamicQueueADT, cola2: DynamicQueueADT) -> DynamicQueueADT:
    copia1 = copiar_cola(cola1)
    copia2 = copiar_cola(cola2)
    resultado = DynamicQueueADT()

    while not copia1.is_empty():
        actual = copia1.getElement()
        copia1.remove()

        temp = DynamicQueueADT()
        encontrado = False

        while not copia2.is_empty():
            valor = copia2.getElement()
            copia2.remove()
            if valor == actual and not encontrado:
                resultado.add(valor)
                encontrado = True
            temp.add(valor)

        copia2 = temp

    return resultado

def copiar_cola(original: DynamicQueueADT) -> DynamicQueueADT:
    copia = DynamicQueueADT()
    temp = DynamicQueueADT()

    while not original.is_empty():
        val = original.getElement()
        original.remove()
        copia.add(val)
        temp.add(val)

    while not temp.is_empty():
        original.add(temp.getElement())
        temp.remove()

    return copia


# Suponiendo que DynamicQueueADT tiene métodos: add, remove, getElement, is_empty

cola1 = DynamicQueueADT()
cola1.add(1)
cola1.add(2)
cola1.add(3)
cola1.add(4)

cola2 = DynamicQueueADT()
cola2.add(3)
cola2.add(4)
cola2.add(5)
cola2.add(6)

comun = elementos_en_comun(cola1, cola2)

print("Elementos en común:", end=" ")
while not comun.is_empty():
    print(comun.getElement(), end=" ")
    comun.remove()
