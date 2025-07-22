class PriorityNode:
    def __init__(self, value: int, priority: int, siguiente=None):
        self.value = value
        self.priority = priority
        self.siguiente = siguiente

class DynamicPriorityQueueADT:
    def __init__(self):
        self.node = None

    def get_element(self) -> int:
        if self.is_empty():
            raise Exception("No se puede obtener el primero de una cola vacía")
        return self.node.value

    def get_priority(self) -> int:
        if self.is_empty():
            raise Exception("No se puede obtener la prioridad del primero de una cola vacía")
        return self.node.priority

    def remove(self):
        if self.is_empty():
            raise Exception("No se puede remover el primero de una cola vacía")
        self.node = self.node.siguiente

    def add(self, value: int, priority: int):
        nuevo = PriorityNode(value, priority)

        if self.is_empty() or self.node.priority > priority:
            nuevo.siguiente = self.node
            self.node = nuevo
            return

        actual = self.node
        while actual.siguiente is not None and actual.siguiente.priority <= priority:
            actual = actual.siguiente

        nuevo.siguiente = actual.siguiente
        actual.siguiente = nuevo

    def is_empty(self) -> bool:
        return self.node is None

    def mostrar(self):
        actual = self.node
        while actual:
            print(f"[{actual.value}, {actual.priority}]", end=" -> ")
            actual = actual.siguiente
        print("None")
