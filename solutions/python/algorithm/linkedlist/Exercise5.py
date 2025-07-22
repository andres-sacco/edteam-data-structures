
from structure.dynamic.DynamicLinkedListADT import DynamicLinkedListADT
from util.LinkedListUtil import print_list


def reverse(linked_list):
    reversed_list = DynamicLinkedListADT()  # Asumiendo que tenés una clase LinkedList creada

    for i in range(linked_list.size() - 1, -1, -1):
        reversed_list.add(linked_list.get(i))

    return reversed_list


# 🧪 Ejemplo de uso
lista = DynamicLinkedListADT()
lista.add(10)
lista.add(20)
lista.add(30)
lista.add(40)

print("Lista Original:")
print_list(lista)

lista_invertida = reverse(lista)

print("Lista invertida:")
print_list(lista_invertida)

