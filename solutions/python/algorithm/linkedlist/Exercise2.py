from structure.dynamic.DynamicLinkedListADT import DynamicLinkedListADT
from util.LinkedListUtil import print_list


def remove_last(linked_list, n):
    total_size = linked_list.size()

    if n >= total_size:
        for i in range(total_size - 1, -1, -1):
            linked_list.remove(i)
    else:
        for _ in range(n):
            linked_list.remove(linked_list.size() - 1)


# 🧪 Ejemplo de uso
lista = DynamicLinkedListADT()
lista.add(10)
lista.add(20)
lista.add(30)
lista.add(40)

print("Lista Original:")
print_list(lista)

remove_last(lista, 2)

print("Lista sin elementos:")
print_list(lista)