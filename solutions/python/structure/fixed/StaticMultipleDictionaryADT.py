from typing import List, Optional

class StaticSet:
    def __init__(self, capacity: int = 100):
        self.data = [None] * capacity
        self.size = 0

    def exist(self, value: int) -> bool:
        for i in range(self.size):
            if self.data[i] == value:
                return True
        return False

    def choose(self) -> int:
        if self.size == 0:
            raise ValueError("El conjunto está vacío")
        return self.data[0]

    def add(self, value: int):
        if self.size >= len(self.data) or self.exist(value):
            return
        self.data[self.size] = value
        self.size += 1

    def remove(self, value: int):
        for i in range(self.size):
            if self.data[i] == value:
                self.data[i] = self.data[self.size - 1]
                self.size -= 1
                return

    def is_empty(self) -> bool:
        return self.size == 0

    def to_list(self) -> List[int]:
        return [self.data[i] for i in range(self.size)]

class StaticMultipleDictionary:
    def __init__(self, capacity: int = 100):
        self.keys = [None] * capacity
        self.values = [[None] * 10 for _ in range(capacity)]
        self.counts = [0] * capacity
        self.size = 0
        self.capacity = capacity

    def _find_index(self, key: int) -> Optional[int]:
        for i in range(self.size):
            if self.keys[i] == key:
                return i
        return None

    def add(self, key: int, value: int):
        index = self._find_index(key)
        if index is not None:
            # Evitar duplicados
            for i in range(self.counts[index]):
                if self.values[index][i] == value:
                    return
            if self.counts[index] < len(self.values[index]):
                self.values[index][self.counts[index]] = value
                self.counts[index] += 1
        else:
            if self.size >= self.capacity:
                return
            self.keys[self.size] = key
            self.values[self.size][0] = value
            self.counts[self.size] = 1
            self.size += 1

    def remove(self, key: int):
        index = self._find_index(key)
        if index is not None:
            self.keys[index] = self.keys[self.size - 1]
            self.values[index] = self.values[self.size - 1]
            self.counts[index] = self.counts[self.size - 1]
            self.size -= 1

    def remove_value(self, key: int, value: int):
        index = self._find_index(key)
        if index is not None:
            for i in range(self.counts[index]):
                if self.values[index][i] == value:
                    self.values[index][i] = self.values[index][self.counts[index] - 1]
                    self.counts[index] -= 1
                    break
            if self.counts[index] == 0:
                self.remove(key)

    def get(self, key: int) -> List[int]:
        index = self._find_index(key)
        if index is None or self.counts[index] == 0:
            raise KeyError("Clave no encontrada")
        return [self.values[index][i] for i in range(self.counts[index])]

    def get_keys(self) -> StaticSet:
        result = StaticSet()
        for i in range(self.size):
            result.add(self.keys[i])
        return result

    def is_empty(self) -> bool:
        return self.size == 0
