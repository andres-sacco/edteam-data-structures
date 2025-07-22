class StaticPriorityQueueADT:
    def __init__(self, capacidad: int):
        self.capacidad = capacidad
        self.datos = [None] * capacidad  # Cada elemento será una tupla (valor, prioridad)
        self.size = 0

    def get_element(self) -> int:
        if self.is_empty():
            raise Exception("No se puede obtener el primero de una cola vacía")
        return self.datos[0][0]

    def get_priority(self) -> int:
        if self.is_empty():
            raise Exception("No se puede obtener la prioridad del primero de una cola vacía")
        return self.datos[0][1]

    def remove(self):
        if self.is_empty():
            raise Exception("No se puede remover el primero de una cola vacía")
        for i in range(1, self.size):
            self.datos[i - 1] = self.datos[i]
        self.datos[self.size - 1] = None
        self.size -= 1

    def add(self, value: int, priority: int):
        if self.size >= self.capacidad:
            raise Exception("Cola llena")

        i = self.size - 1
        # Insertamos ordenado por prioridad ascendente
        while i >= 0 and self.datos[i][1] > priority:
            self.datos[i + 1] = self.datos[i]
            i -= 1
        self.datos[i + 1] = (value, priority)
        self.size += 1

    def is_empty(self) -> bool:
        return self.size == 0

    def mostrar(self):
        for i in range(self.size):
            print(f"[{self.datos[i][0]}, {self.datos[i][1]}]", end=" -> ")
        print("None")
