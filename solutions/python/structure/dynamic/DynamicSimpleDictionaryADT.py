from structure.dynamic.DynamicSetADT import DynamicSetADT


class PairNode:
    def __init__(self, key, value, next_node=None):
        self.key = key
        self.value = value
        self.next = next_node

class DynamicSimpleDictionaryADT:
    def __init__(self):
        self.keys = DynamicSetADT()
        self.pairs_head = None  # Lista enlazada de PairNode

    def add(self, key, value):
        if self.keys.exist(key):
            current = self.pairs_head
            while current:
                if current.key == key:
                    current.value = value  # Sobrescribe
                    return
                current = current.next
        else:
            self.pairs_head = PairNode(key, value, self.pairs_head)
            self.keys.add(key)

    def remove(self, key):
        if not self.keys.exist(key):
            return

        prev = None
        current = self.pairs_head
        while current:
            if current.key == key:
                if prev:
                    prev.next = current.next
                else:
                    self.pairs_head = current.next
                self.keys.remove(key)
                return
            prev = current
            current = current.next

    def get(self, key):
        if not self.keys.exist(key):
            raise KeyError(f"Clave {key} no encontrada.")

        current = self.pairs_head
        while current:
            if current.key == key:
                return current.value
            current = current.next
        raise KeyError(f"Clave {key} no encontrada.")  # Seguridad adicional

    def get_keys(self):
        return self.keys  # Devuelve el SetADT

    def is_empty(self):
        return self.keys.isEmpty()

    def mostrar(self):
        current = self.pairs_head
        while current:
            print(f"Clave: {current.key} -> Valor: {current.value}")
            current = current.next
