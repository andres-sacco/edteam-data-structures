from structure.dynamic.DynamicMultipleDictionaryADT import DynamicMultipleDictionaryADT, SetADT


def sumar_diccionarios(d1: DynamicMultipleDictionaryADT, d2: DynamicMultipleDictionaryADT) -> DynamicMultipleDictionaryADT:
    resultado = DynamicMultipleDictionaryADT()
    claves_unidas = SetADT()

    for clave in d1.get_keys().get_all():
        claves_unidas.add(clave)
    for clave in d2.get_keys().get_all():
        claves_unidas.add(clave)

    for clave in claves_unidas.get_all():
        suma = 0

        try:
            for valor in d1.get(clave):
                suma += valor
        except KeyError:
            pass

        try:
            for valor in d2.get(clave):
                suma += valor
        except KeyError:
            pass

        resultado.add(clave, suma)

    return resultado


d1 = DynamicMultipleDictionaryADT()
d1.add(1, 10)
d1.add(1, 20)
d1.add(2, 5)

d2 = DynamicMultipleDictionaryADT()
d2.add(1, 5)
d2.add(3, 100)

resultado = sumar_diccionarios(d1, d2)
resultado.mostrar()
