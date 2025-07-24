from structure.dynamic.DynamicGraphADT import DynamicGraphADT
from structure.dynamic.DynamicSetADT import DynamicSetADT


def are_graphs_equal(g1, g2):
    # Comparar conjuntos de vértices
    if not sets_are_equal(g1.get_vertices(), g2.get_vertices()):
        return False

    vertices = g1.get_vertices()
    copia_vertices = copy_set(vertices)

    while not copia_vertices.isEmpty():
        v = copia_vertices.choose()
        copia_vertices.remove(v)

        destinos = g1.get_vertices()  # Asumimos que cualquier vértice puede ser destino
        copia_destinos = copy_set(destinos)

        while not copia_destinos.isEmpty():
            destino = copia_destinos.choose()
            copia_destinos.remove(destino)

            g1_has_edge = g1.exists_edge(v, destino)
            g2_has_edge = g2.exists_edge(v, destino)

            if g1_has_edge != g2_has_edge:
                return False

            if g1_has_edge:
                if g1.edge_weight(v, destino) != g2.edge_weight(v, destino):
                    return False

    return True


def sets_are_equal(s1, s2):
    copia1 = copy_set(s1)
    copia2 = copy_set(s2)

    if count_set(copia1) != count_set(copia2):
        return False

    while not copia1.isEmpty():
        elem = copia1.choose()
        copia1.remove(elem)
        if not copia2.exist(elem):
            return False
        copia2.remove(elem)

    return copia2.isEmpty()


def count_set(s):
    copia = copy_set(s)
    c = 0
    while not copia.isEmpty():
        copia.remove(copia.choose())
        c += 1
    return c


def copy_set(original):
    copia = DynamicSetADT()
    aux = DynamicSetADT()

    while not original.isEmpty():
        elem = original.choose()
        original.remove(elem)
        copia.add(elem)
        aux.add(elem)

    while not aux.isEmpty():
        elem = aux.choose()
        aux.remove(elem)
        original.add(elem)

    return copia


g1 = DynamicGraphADT()
g1.add_vertex(1)
g1.add_vertex(2)
g1.add_edge(1, 2, 10)

g2 = DynamicGraphADT()
g2.add_vertex(1)
g2.add_vertex(2)
g2.add_edge(1, 2, 10)

print(are_graphs_equal(g1, g2))  # True
