class Nodo:
    def __init__(self, valor):
        self.valor = valor
        self.siguiente = None

class DynamicQueueADT:
    def __init__(self):
        self.frente = None
        self.final = None

    def getElement(self) -> int:
        if self.is_empty():
            raise IndexError("La cola está vacía.")
        return self.frente.valor

    def add(self, value: int):
        nuevo_nodo = Nodo(value)
        if self.is_empty():
            self.frente = nuevo_nodo
            self.final = nuevo_nodo
        else:
            self.final.siguiente = nuevo_nodo
            self.final = nuevo_nodo

    def remove(self):
        if self.is_empty():
            raise IndexError("La cola está vacía.")
        self.frente = self.frente.siguiente
        if self.frente is None:
            self.final = None  # La cola quedó vacía

    def is_empty(self) -> bool:
        return self.frente is None

    def mostrar(self):
        actual = self.frente
        while actual:
            print(actual.valor, end=" -> ")
            actual = actual.siguiente
        print("None")
