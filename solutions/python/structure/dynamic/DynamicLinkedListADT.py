class Nodo:
    def __init__(self, valor):
        self.valor = valor
        self.siguiente = None

class DynamicLinkedListADT:
    def __init__(self):
        self.cabeza = None
        self._tamanio = 0

    def add(self, value: int):
        nuevo_nodo = Nodo(value)
        if self.cabeza is None:
            self.cabeza = nuevo_nodo
        else:
            actual = self.cabeza
            while actual.siguiente:
                actual = actual.siguiente
            actual.siguiente = nuevo_nodo
        self._tamanio += 1

    def insert(self, index: int, value: int):
        if index < 0 or index > self._tamanio:
            raise IndexError("Índice fuera de rango")
        nuevo_nodo = Nodo(value)
        if index == 0:
            nuevo_nodo.siguiente = self.cabeza
            self.cabeza = nuevo_nodo
        else:
            actual = self.cabeza
            for _ in range(index - 1):
                actual = actual.siguiente
            nuevo_nodo.siguiente = actual.siguiente
            actual.siguiente = nuevo_nodo
        self._tamanio += 1

    def remove(self, index: int):
        if index < 0 or index >= self._tamanio:
            raise IndexError("Índice fuera de rango")
        if index == 0:
            self.cabeza = self.cabeza.siguiente
        else:
            actual = self.cabeza
            for _ in range(index - 1):
                actual = actual.siguiente
            actual.siguiente = actual.siguiente.siguiente
        self._tamanio -= 1

    def get(self, index: int) -> int:
        if index < 0 or index >= self._tamanio:
            raise IndexError("Índice fuera de rango")
        actual = self.cabeza
        for _ in range(index):
            actual = actual.siguiente
        return actual.valor

    def size(self) -> int:
        return self._tamanio

    def is_empty(self) -> bool:
        return self._tamanio == 0

    def mostrar(self):
        actual = self.cabeza
        while actual:
            print(actual.valor, end=" -> ")
            actual = actual.siguiente
        print("None")
