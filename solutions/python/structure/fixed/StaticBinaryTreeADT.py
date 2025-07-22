class StaticBinaryTreeADT:
    def __init__(self, capacity):
        self.capacity = capacity
        self.tree = [None] * capacity
        self.size = 0

    def getRoot(self):
        return self.tree[0]

    def getLeft(self, index):
        left_index = 2 * index + 1
        if left_index < self.capacity:
            return self.tree[left_index]
        return None

    def getRight(self, index):
        right_index = 2 * index + 2
        if right_index < self.capacity:
            return self.tree[right_index]
        return None

    def add(self, value):
        if self.size == 0:
            self.tree[0] = value
            self.size += 1
        else:
            self._add_recursive(0, value)

    def _add_recursive(self, index, value):
        if index >= self.capacity:
            raise Exception("Capacidad excedida")

        if self.tree[index] is None:
            self.tree[index] = value
            self.size += 1
        elif value < self.tree[index]:
            self._add_recursive(2 * index + 1, value)
        else:
            self._add_recursive(2 * index + 2, value)

    def remove(self, value):
        raise NotImplementedError("Eliminación no implementada en la versión estática")

    def isEmpty(self):
        return self.size == 0
