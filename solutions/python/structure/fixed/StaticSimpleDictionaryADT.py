class StaticSimpleDictionaryADT:
    def __init__(self, capacity):
        self.capacity = capacity
        self.keys = [None] * capacity
        self.values = [None] * capacity
        self.size = 0

    def add(self, key, value):
        index = self._index_of_key(key)
        if index != -1:
            self.values[index] = value  # Sobrescribe si ya existe
        elif self.size < self.capacity:
            self.keys[self.size] = key
            self.values[self.size] = value
            self.size += 1
        # Si está lleno, no hace nada (podrías lanzar excepción si querés)

    def remove(self, key):
        index = self._index_of_key(key)
        if index != -1:
            # Reemplaza con el último elemento
            self.keys[index] = self.keys[self.size - 1]
            self.values[index] = self.values[self.size - 1]
            self.keys[self.size - 1] = None
            self.values[self.size - 1] = None
            self.size -= 1

    def get(self, key):
        index = self._index_of_key(key)
        if index != -1:
            return self.values[index]
        raise KeyError(f"Clave {key} no encontrada.")

    def get_keys(self):
        return [self.keys[i] for i in range(self.size)]

    def is_empty(self):
        return self.size == 0

    def _index_of_key(self, key):
        for i in range(self.size):
            if self.keys[i] == key:
                return i
        return -1

    def mostrar(self):
        for i in range(self.size):
            print(f"Clave: {self.keys[i]} -> Valor: {self.values[i]}")
