package org.edteam.algorithm.simpledictionary;

import org.edteam.structure.definition.SetADT;
import org.edteam.structure.definition.SimpleDictionaryADT;
import org.edteam.structure.implementation.dynamic.DynamicSimpleDictionaryADT;

public class Exercise3 {


    public static int sumaClavePorValor(SimpleDictionaryADT diccionario) {
        SetADT claves = diccionario.getKeys();
        int suma = 0;
        while (!claves.isEmpty()) {
            int clave = claves.choose();
            claves.remove(clave);
            int valor = diccionario.get(clave);
            suma += clave * valor;
        }
        return suma;
    }

    public static void main(String[] args) {
        SimpleDictionaryADT diccionario = new DynamicSimpleDictionaryADT();

        diccionario.add(2, 5);   // 2 * 5 = 10
        diccionario.add(3, 4);   // 3 * 4 = 12
        diccionario.add(5, 1);   // 5 * 1 = 5

        int resultado = sumaClavePorValor(diccionario);
        System.out.println("La suma de claves * valores es: " + resultado); // Debería imprimir 27
    }


}
