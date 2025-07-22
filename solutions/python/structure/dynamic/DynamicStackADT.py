class Nodo:
    def __init__(self, valor):
        self.valor = valor
        self.siguiente = None

class DynamicStackADT:
    def __init__(self):
        self.tope = None

    def getElement(self) -> int:
        if self.is_empty():
            raise Exception("La pila está vacía.")
        return self.tope.valor

    def add(self, value: int):
        nuevo_nodo = Nodo(value)
        nuevo_nodo.siguiente = self.tope
        self.tope = nuevo_nodo

    def remove(self):
        if self.is_empty():
            raise Exception("La pila está vacía.")
        self.tope = self.tope.siguiente

    def is_empty(self) -> bool:
        return self.tope is None

    def mostrar(self):
        actual = self.tope
        while actual:
            print(actual.valor, end=" -> ")
            actual = actual.siguiente
        print("None")
