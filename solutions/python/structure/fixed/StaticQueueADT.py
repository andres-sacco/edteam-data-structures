class StaticQueueADT:
    def __init__(self, capacidad: int):
        self.capacidad = capacidad
        self.elementos = [0] * capacidad
        self.frente = 0
        self.final = 0
        self.cantidad = 0

    def getElement(self) -> int:
        if self.is_empty():
            raise IndexError("La cola está vacía.")
        return self.elementos[self.frente]

    def add(self, value: int):
        if self.cantidad == self.capacidad:
            raise OverflowError("La cola está llena.")
        self.elementos[self.final] = value
        self.final = (self.final + 1) % self.capacidad
        self.cantidad += 1

    def remove(self):
        if self.is_empty():
            raise IndexError("La cola está vacía.")
        self.frente = (self.frente + 1) % self.capacidad
        self.cantidad -= 1

    def is_empty(self) -> bool:
        return self.cantidad == 0

    def mostrar(self):
        if self.is_empty():
            print("Cola vacía")
            return
        i = self.frente
        for _ in range(self.cantidad):
            print(self.elementos[i], end=" -> ")
            i = (i + 1) % self.capacidad
        print("None")
