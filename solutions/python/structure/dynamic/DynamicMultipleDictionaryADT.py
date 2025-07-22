class SetADT:
    def __init__(self):
        self.elements = set()

    def add(self, elem):
        self.elements.add(elem)

    def remove(self, elem):
        self.elements.discard(elem)

    def contains(self, elem):
        return elem in self.elements

    def get_all(self):
        return list(self.elements)

    def is_empty(self):
        return len(self.elements) == 0


class DynamicMultipleDictionaryADT:
    def __init__(self):
        self.data = {}

    def add(self, key: int, value: int):
        if key not in self.data:
            self.data[key] = []
        if value not in self.data[key]:
            self.data[key].append(value)

    def remove(self, key: int):
        self.data.pop(key, None)

    def remove_value(self, key: int, value: int):
        if key in self.data:
            if value in self.data[key]:
                self.data[key].remove(value)
            if not self.data[key]:
                del self.data[key]

    def get(self, key: int) -> list[int]:
        if key in self.data:
            return self.data[key][:]
        raise KeyError(f"La clave {key} no existe.")

    def get_keys(self) -> SetADT:
        keys_set = SetADT()
        for key in self.data:
            keys_set.add(key)
        return keys_set

    def is_empty(self) -> bool:
        return not self.data

    def mostrar(self):
        for key, values in self.data.items():
            print(f"{key}: {values}")
