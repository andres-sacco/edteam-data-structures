from structure.dynamic.DynamicSetADT import DynamicSetADT


class EdgeNode:
    def __init__(self, destination, weight, next_edge=None):
        self.destination = destination
        self.weight = weight
        self.next = next_edge


class VertexNode:
    def __init__(self, value, next_vertex=None):
        self.value = value
        self.edges = None  # Lista enlazada de EdgeNode
        self.next = next_vertex

class DynamicGraphADT:
    def __init__(self):
        self.first_vertex = None  # Primer VertexNode

    def is_empty(self):
        return self.first_vertex is None

    def add_vertex(self, vertex):
        if self.find_vertex(vertex) is not None:
            return
        self.first_vertex = VertexNode(vertex, self.first_vertex)

    def remove_vertex(self, vertex):
        if self.is_empty():
            return

        # Eliminar si es el primero
        if self.first_vertex.value == vertex:
            self.first_vertex = self.first_vertex.next
        else:
            prev = self.first_vertex
            current = self.first_vertex.next
            while current:
                if current.value == vertex:
                    prev.next = current.next
                    break
                prev = current
                current = current.next

        # Eliminar aristas que apuntan a este vértice
        current = self.first_vertex
        while current:
            self.remove_edge(current.value, vertex)
            current = current.next

    def add_edge(self, v1, v2, weight):
        self.add_vertex(v1)
        self.add_vertex(v2)
        from_vertex = self.find_vertex(v1)

        current = from_vertex.edges
        while current:
            if current.destination == v2:
                current.weight = weight
                return
            current = current.next

        from_vertex.edges = EdgeNode(v2, weight, from_vertex.edges)

    def remove_edge(self, v1, v2):
        from_vertex = self.find_vertex(v1)
        if not from_vertex or not from_vertex.edges:
            return

        if from_vertex.edges.destination == v2:
            from_vertex.edges = from_vertex.edges.next
            return

        prev = from_vertex.edges
        current = prev.next
        while current:
            if current.destination == v2:
                prev.next = current.next
                return
            prev = current
            current = current.next

    def exists_edge(self, v1, v2):
        from_vertex = self.find_vertex(v1)
        if not from_vertex:
            return False
        current = from_vertex.edges
        while current:
            if current.destination == v2:
                return True
            current = current.next
        return False

    def edge_weight(self, v1, v2):
        from_vertex = self.find_vertex(v1)
        if not from_vertex:
            raise ValueError("Vértice origen no encontrado")
        current = from_vertex.edges
        while current:
            if current.destination == v2:
                return current.weight
            current = current.next
        raise ValueError("No existe la arista")

    def get_vertices(self):
        result = DynamicSetADT()
        current = self.first_vertex
        while current:
            result.add(current.value)
            current = current.next
        return result

    def find_vertex(self, vertex):
        current = self.first_vertex
        while current:
            if current.value == vertex:
                return current
            current = current.next
        return None
