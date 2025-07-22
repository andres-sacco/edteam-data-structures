from structure.dynamic.DynamicSimpleDictionaryADT import DynamicSimpleDictionaryADT

def suma_clave_por_valor(diccionario):
    suma = 0
    for clave in diccionario.get_keys():
        valor = diccionario.get(clave)
        suma += clave * valor
    return suma

# Ejemplo de uso
dic = DynamicSimpleDictionaryADT()
dic.add(2, 5)  # 2 * 5 = 10
dic.add(3, 4)  # 3 * 4 = 12
dic.add(5, 1)  # 5 * 1 = 5

dic.mostrar()

resultado = suma_clave_por_valor(dic)
print("La suma de claves * valores es:", resultado)  # Debería imprimir 27