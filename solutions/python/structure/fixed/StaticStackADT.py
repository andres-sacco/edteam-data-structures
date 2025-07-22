class StaticStackADT:
    def __init__(self, capacidad: int):
        self.capacidad = capacidad
        self.stack = [None] * capacidad  # lista de tamaño fijo
        self.tope = -1  # índice del último elemento

    def getElement(self) -> int:
        if self.is_empty():
            raise Exception("La pila está vacía.")
        return self.stack[self.tope]

    def add(self, value: int):
        if self.tope == self.capacidad - 1:
            raise Exception("La pila está llena.")
        self.tope += 1
        self.stack[self.tope] = value

    def remove(self):
        if self.is_empty():
            raise Exception("La pila está vacía.")
        self.stack[self.tope] = None  # opcional: limpiar la posición
        self.tope -= 1

    def is_empty(self) -> bool:
        return self.tope == -1

    def mostrar(self):
        for i in range(self.tope, -1, -1):
            print(self.stack[i], end=" -> ")
        print("None")
