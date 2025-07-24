from structure.dynamic.DynamicGraphADT import DynamicGraphADT
from structure.dynamic.DynamicSetADT import DynamicSetADT


def max_edge_cost_from(graph, v):
    if graph.is_empty():
        raise ValueError("El grafo está vacío.")

    vertices = graph.get_vertices()
    copia = copiar_conjunto(vertices)

    max_cost = None
    found = False

    while not copia.isEmpty():
        destino = copia.choose()
        copia.remove(destino)

        if graph.exists_edge(v, destino):
            cost = graph.edge_weight(v, destino)
            if (max_cost is None) or (cost > max_cost):
                max_cost = cost
                found = True

    if not found:
        raise ValueError(f"El vértice {v} no tiene aristas salientes.")

    return max_cost


def copiar_conjunto(original):
    copia = DynamicSetADT()
    temporal = DynamicSetADT()

    while not original.isEmpty():
        elem = original.choose()
        original.remove(elem)
        copia.add(elem)
        temporal.add(elem)

    while not temporal.isEmpty():
        elem = temporal.choose()
        temporal.remove(elem)
        original.add(elem)

    return copia


grafo = DynamicGraphADT()
grafo.add_vertex(1)
grafo.add_vertex(2)
grafo.add_vertex(3)
grafo.add_edge(1, 2, 10)
grafo.add_edge(1, 3, 25)

print(max_edge_cost_from(grafo, 1))  # → 25
