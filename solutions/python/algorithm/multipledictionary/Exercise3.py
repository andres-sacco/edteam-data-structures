from structure.dynamic.DynamicMultipleDictionaryADT import DynamicMultipleDictionaryADT


def filtrar_por_rango(diccionario: DynamicMultipleDictionaryADT, minimo: int, maximo: int) -> DynamicMultipleDictionaryADT:
    resultado = DynamicMultipleDictionaryADT()
    claves = diccionario.get_keys().get_all()

    for clave in claves:
        try:
            valores = diccionario.get(clave)
            for valor in valores:
                if minimo <= valor <= maximo:
                    resultado.add(clave, valor)
        except KeyError:
            pass  # ignorar claves que no existen (aunque no debería pasar)

    return resultado


d = DynamicMultipleDictionaryADT()
d.add(1, 10)
d.add(1, 20)
d.add(1, 5)
d.add(2, 100)
d.add(2, 25)
d.add(3, 30)

filtrado = filtrar_por_rango(d, 10, 30)
filtrado.mostrar()

