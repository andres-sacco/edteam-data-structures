import random

class StaticSetADT:
    def __init__(self, capacity):
        self.capacity = capacity
        self.elements = [None] * capacity
        self.size = 0

    def exist(self, value):
        for i in range(self.size):
            if self.elements[i] == value:
                return True
        return False

    def choose(self):
        if self.isEmpty():
            raise Exception("No se puede elegir de un conjunto vacío")
        return random.choice(self.elements[:self.size])

    def add(self, value):
        if self.size >= self.capacity:
            raise Exception("Capacidad máxima alcanzada")
        if self.exist(value):
            return
        self.elements[self.size] = value
        self.size += 1

    def remove(self, value):
        for i in range(self.size):
            if self.elements[i] == value:
                for j in range(i, self.size - 1):
                    self.elements[j] = self.elements[j + 1]
                self.elements[self.size - 1] = None
                self.size -= 1
                return

    def isEmpty(self):
        return self.size == 0
