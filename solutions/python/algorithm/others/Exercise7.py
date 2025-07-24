from structure.dynamic.DynamicGraphADT import DynamicGraphADT
from structure.dynamic.DynamicSetADT import DynamicSetADT
from structure.dynamic.DynamicSimpleDictionaryADT import DynamicSimpleDictionaryADT


def calcular_grado_entrada_salida(grafo: DynamicGraphADT):
    resultado = DynamicSimpleDictionaryADT()
    vertices = grafo.get_vertices()  # DynamicSetADT
    temp = DynamicSetADT()

    grados = {}

    # Extraer todos los vértices para inicializar grados
    while not vertices.isEmpty():
        nodo = vertices.choose()
        vertices.remove(nodo)
        temp.add(nodo)
        grados[nodo] = [0, 0]  # [grado entrada, grado salida]

    # Restaurar el conjunto original
    while not temp.isEmpty():
        nodo = temp.choose()
        temp.remove(nodo)
        vertices.add(nodo)

    # Recorremos cada vértice para contar salidas e incrementar entradas
    current_vertex = grafo.first_vertex
    while current_vertex is not None:
        origen = current_vertex.value
        # Contar salidas
        edge = current_vertex.edges
        salida_count = 0
        while edge is not None:
            salida_count += 1
            destino = edge.destination
            if destino not in grados:
                grados[destino] = [0, 0]
            grados[destino][0] += 1  # Incrementar entrada para destino
            edge = edge.next
        grados[origen][1] = salida_count  # Grado salida del nodo origen
        current_vertex = current_vertex.next

    # Cargar los resultados en un diccionario simple
    for nodo in grados:
        entrada, salida = grados[nodo]
        resultado.add(nodo, (entrada, salida))

    return resultado




grafo = DynamicGraphADT()
grafo.add_edge(1, 2, 10)
grafo.add_edge(2, 3, 5)
grafo.add_edge(1, 3, 2)

dic = calcular_grado_entrada_salida(grafo)
dic.mostrar()

# Salida esperada:
# Clave: 1 -> Valor: (0, 2)
# Clave: 2 -> Valor: (1, 1)
# Clave: 3 -> Valor: (2, 0)
