import random

class Node:
    def __init__(self, value, next=None):
        self.value = value
        self.next = next

class DynamicSetADT:
    def __init__(self):
        self.head = None

    def exist(self, value):
        current = self.head
        while current:
            if current.value == value:
                return True
            current = current.next
        return False

    def choose(self):
        if self.isEmpty():
            raise Exception("No se puede elegir de un conjunto vacío")
        values = []
        current = self.head
        while current:
            values.append(current.value)
            current = current.next
        return random.choice(values)

    def add(self, value):
        if self.exist(value):
            return
        self.head = Node(value, self.head)

    def remove(self, value):
        if self.isEmpty():
            return
        if self.head.value == value:
            self.head = self.head.next
            return
        prev = self.head
        current = self.head.next
        while current:
            if current.value == value:
                prev.next = current.next
                return
            prev = current
            current = current.next

    def isEmpty(self):
        return self.head is None
