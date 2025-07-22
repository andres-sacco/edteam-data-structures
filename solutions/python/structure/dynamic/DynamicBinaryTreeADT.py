class DynamicBinaryTreeADT:
    def __init__(self, value=None):
        self.root = value
        self.left = None
        self.right = None

    def getRoot(self):
        return self.root

    def getLeft(self):
        return self.left

    def getRight(self):
        return self.right

    def add(self, value):
        if self.root is None:
            self.root = value
        elif value < self.root:
            if self.left is None:
                self.left = BinaryTreeADT(value)
            else:
                self.left.add(value)
        else:
            if self.right is None:
                self.right = BinaryTreeADT(value)
            else:
                self.right.add(value)

    def remove(self, value):
        # Implementación básica para eliminar nodos de un BST
        if self.root is None:
            return self

        if value < self.root:
            if self.left:
                self.left = self.left.remove(value)
        elif value > self.root:
            if self.right:
                self.right = self.right.remove(value)
        else:
            if self.left is None:
                return self.right
            if self.right is None:
                return self.left
            # Nodo con dos hijos: reemplazar con el menor de los mayores
            min_larger_node = self.right
            while min_larger_node.left:
                min_larger_node = min_larger_node.left
            self.root = min_larger_node.root
            self.right = self.right.remove(min_larger_node.root)
        return self

    def isEmpty(self):
        return self.root is None
