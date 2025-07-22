class StaticGraphADT:
    def __init__(self, max_vertices):
        self.max_vertices = max_vertices
        self.matrix = [[None for _ in range(max_vertices)] for _ in range(max_vertices)]
        self.vertices = set()

    def get_vertices(self):
        return self.vertices

    def add_vertex(self, vertex):
        if 0 <= vertex < self.max_vertices:
            self.vertices.add(vertex)

    def remove_vertex(self, vertex):
        if vertex in self.vertices:
            self.vertices.remove(vertex)
            for i in range(self.max_vertices):
                self.matrix[vertex][i] = None
                self.matrix[i][vertex] = None

    def add_edge(self, v1, v2, weight):
        if v1 in self.vertices and v2 in self.vertices:
            self.matrix[v1][v2] = weight

    def remove_edge(self, v1, v2):
        if v1 in self.vertices and v2 in self.vertices:
            self.matrix[v1][v2] = None

    def exists_edge(self, v1, v2):
        return self.matrix[v1][v2] is not None

    def edge_weight(self, v1, v2):
        if self.exists_edge(v1, v2):
            return self.matrix[v1][v2]
        raise ValueError("No existe la arista")

    def is_empty(self):
        return len(self.vertices) == 0
