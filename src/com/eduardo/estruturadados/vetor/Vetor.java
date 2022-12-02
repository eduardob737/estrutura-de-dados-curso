package com.eduardo.estruturadados.vetor;

public class Vetor {

    private String [] elementos;
    // Variável para armazenar tamanho real do vetor (posições que possuem valor atribuído)
    private int tamanho;

    public Vetor (int capacidade){
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    }

    // Método de adição de valores ao vetor com exception quando adição não for possível
    /*public void adiciona(String elemento) throws Exception {
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
        } else {
            throw new Exception("Vetor já está cheio, não é possível adicionar mais elementos.");
        }
    }*/

    // Método de adição de valores ao vetor sem exception (com retorno booleano)
    public boolean adiciona(String elemento) {
        this.aumentaCapacidade();
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }

    // Método de adição de valores em uma posição específica (mesmo ela já sendo ocupada),
    // realocando os valores existentes para as posições seguintes.
    public void adiciona(int posicao, String elemento) {
        this.aumentaCapacidade();
        if (!(posicao >= 0 && posicao < tamanho)){
            throw new IllegalArgumentException("Posição inválida");
        }

        // Move os elementos necessários para posições seguintes
        for (int i=this.tamanho-1; i>=posicao; i--){
            this.elementos[i+1] = this.elementos[i];
        }

        // Insere o elemento desejado na posição desejada (agora vazia)
        this.elementos[posicao] = elemento;
        this.tamanho++;
    }

    public int getTamanho(){
        return this.tamanho;
    }

    private void aumentaCapacidade(){
        if (this.tamanho == this.elementos.length){
            String[] elementosNovos = new String[this.elementos.length * 2];
            for (int i=0; i<this.elementos.length; i++){
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

    // Método de buscar uma posição do vetor com retorno do elemento encontrado
    public String busca(int posicao){
        if (!(posicao >= 0 && posicao < tamanho)){
            throw new IllegalArgumentException("Posição inválida");
        }
            return this.elementos[posicao];
    }

    // Método de buscar uma elemento do vetor com retorno da posição encontrado
    public int busca(String elemento){
        for (int i=0; i<this.tamanho; i++){
            if (this.elementos[i].equals(elemento)){
                return i;
            }
        }
        return -1;
    }

    // Método para listar os elementos do vetor (desconsiderando as posições nulas)
    @Override
    public String toString() {

        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i=0; i<this.tamanho-1; i++){
            s.append(this.elementos[i]);
            s.append(", ");
        }

        if(this.tamanho>0){
            s.append(this.elementos[this.tamanho-1]);
        }

        s.append("]");

        return s.toString();
    }
}
