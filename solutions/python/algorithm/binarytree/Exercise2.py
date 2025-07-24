from structure.dynamic.DynamicBinaryTreeADT import DynamicBinaryTreeADT


def count_nodes(tree):
    if tree is None or tree.isEmpty():
        return 0
    return 1 + count_nodes(tree.getLeft()) + count_nodes(tree.getRight())


# Ejemplo de ejecución
tree = DynamicBinaryTreeADT()
tree.add(10)
tree.add(5)
tree.add(15)

print("Cantidad de nodos:", count_nodes(tree))  # Salida: 3