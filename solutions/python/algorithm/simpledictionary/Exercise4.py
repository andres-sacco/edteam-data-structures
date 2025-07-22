from structure.dynamic.DynamicSimpleDictionaryADT import DynamicSimpleDictionaryADT

def filtrar_por_umbral(diccionario, umbral):
    resultado = DynamicSimpleDictionaryADT()
    for key in diccionario.get_keys():
        valor = diccionario.get(key)
        if valor > umbral:
            resultado.add(key, valor)
    return resultado

# Creamos un diccionario
dicc = DynamicSimpleDictionaryADT()
dicc.add(1, 10)
dicc.add(2, 5)
dicc.add(3, 20)
dicc.add(4, 3)

# Filtramos los valores mayores a 6
resultado = filtrar_por_umbral(dicc, 6)

# Mostramos el nuevo diccionario filtrado
resultado.mostrar()
