package com.eduardo.estruturadados.vetor.teste;

import com.eduardo.estruturadados.vetor.Vetor;

public class Aula09 {

    public static void main(String[] args) {

        Vetor vetor = new Vetor(10);

        vetor.adiciona("D");
        vetor.adiciona("F");
        vetor.adiciona("H");
        vetor.adiciona("K");
        vetor.adiciona("M");

        System.out.println(vetor);

        // Remover elemento pela posi��o
        vetor.remove(2);


        // Encontrar posi��o de um elemento e remover do array
        int posicao = vetor.busca("F");

        if (posicao > -1){
            vetor.remove(posicao);
        } else {
            System.out.println("Elemento n�o existe no vetor");
        }

        System.out.println(vetor);
    }
}
