class DynamicSimpleDictionaryADT:
    def __init__(self):
        self.keys = []
        self.values = []

    def add(self, key, value):
        index = self._index_of_key(key)
        if index != -1:
            self.values[index] = value  # Sobrescribe si ya existe
        else:
            self.keys.append(key)
            self.values.append(value)

    def remove(self, key):
        index = self._index_of_key(key)
        if index != -1:
            self.keys.pop(index)
            self.values.pop(index)

    def get(self, key):
        index = self._index_of_key(key)
        if index != -1:
            return self.values[index]
        raise KeyError(f"Clave {key} no encontrada.")

    def get_keys(self):
        return list(self.keys)

    def is_empty(self):
        return len(self.keys) == 0

    def _index_of_key(self, key):
        for i, k in enumerate(self.keys):
            if k == key:
                return i
        return -1

    def mostrar(self):
        for k, v in zip(self.keys, self.values):
            print(f"Clave: {k} -> Valor: {v}")
