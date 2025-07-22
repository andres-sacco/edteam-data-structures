class DynamicGraphADT:
    def __init__(self):
        self.adjacency = {}  # {vertex: {neighbor: weight}}

    def get_vertices(self):
        return set(self.adjacency.keys())

    def add_vertex(self, vertex):
        if vertex not in self.adjacency:
            self.adjacency[vertex] = {}

    def remove_vertex(self, vertex):
        if vertex in self.adjacency:
            self.adjacency.pop(vertex)
            for neighbors in self.adjacency.values():
                neighbors.pop(vertex, None)

    def add_edge(self, v1, v2, weight):
        self.add_vertex(v1)
        self.add_vertex(v2)
        self.adjacency[v1][v2] = weight

    def remove_edge(self, v1, v2):
        if v1 in self.adjacency:
            self.adjacency[v1].pop(v2, None)

    def exists_edge(self, v1, v2):
        return v1 in self.adjacency and v2 in self.adjacency[v1]

    def edge_weight(self, v1, v2):
        if self.exists_edge(v1, v2):
            return self.adjacency[v1][v2]
        raise ValueError("No existe la arista")

    def is_empty(self):
        return not self.adjacency
