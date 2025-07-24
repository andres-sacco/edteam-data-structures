from structure.dynamic.DynamicBinaryTreeADT import DynamicBinaryTreeADT


def is_prefix(a, b):
    if a is None or a.isEmpty():
        return True
    if b is None or b.isEmpty():
        return False
    if a.getRoot() != b.getRoot():
        return False
    return is_prefix(a.getLeft(), b.getLeft()) and is_prefix(a.getRight(), b.getRight())


# Prueba
tree1 = DynamicBinaryTreeADT()
tree1.add(10)
tree1.add(5)

tree2 = DynamicBinaryTreeADT()
tree2.add(10)
tree2.add(5)
tree2.add(15)

print("Tree1 es prefijo de Tree2? ", is_prefix(tree1, tree2))  # True
print("Tree2 es prefijo de Tree1? ", is_prefix(tree2, tree1))  # False