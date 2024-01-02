package vetor.teste;

import vetor.Vetor;

public class Teste {
    public static void main(String[] args) {

        Vetor vetor = new Vetor(5);

        try {
            vetor.adiciona("Elemento 1");
            vetor.adiciona("Elemento 2");
            vetor.adiciona("Elemento 3");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(vetor.busca(2));

    }
}
