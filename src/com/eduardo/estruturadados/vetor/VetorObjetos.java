package com.eduardo.estruturadados.vetor;

public class VetorObjetos {

    private Object[] elementos;
    // Vari�vel para armazenar tamanho real do vetor (posi��es que possuem valor atribu�do)
    private int tamanho;

    public VetorObjetos (int capacidade){
        this.elementos = new Object[capacidade];
        this.tamanho = 0;
    }

    // M�todo de adi��o de valores ao vetor com exception quando adi��o n�o for poss�vel
    /*public void adiciona(String elemento) throws Exception {
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
        } else {
            throw new Exception("Vetor j� est� cheio, n�o � poss�vel adicionar mais elementos.");
        }
    }*/

    // M�todo de adi��o de valores ao vetor sem exception (com retorno booleano)
    public boolean adiciona(Object elemento) {
        this.aumentaCapacidade();
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
            return true;
        }
        return false;
    }

    // M�todo de adi��o de valores em uma posi��o espec�fica (mesmo ela j� sendo ocupada),
    // realocando os valores existentes para as posi��es seguintes.
    public void adiciona(int posicao, Object elemento) {
        this.aumentaCapacidade();
        if (!(posicao >= 0 && posicao < tamanho)){
            throw new IllegalArgumentException("Posi��o inv�lida");
        }

        // Move os elementos necess�rios para posi��es seguintes
        for (int i=this.tamanho-1; i>=posicao; i--){
            this.elementos[i+1] = this.elementos[i];
        }

        // Insere o elemento desejado na posi��o desejada (agora vazia)
        this.elementos[posicao] = elemento;
        this.tamanho++;
    }

    public int getTamanho(){
        return this.tamanho;
    }

    private void aumentaCapacidade(){
        if (this.tamanho == this.elementos.length){
            Object[] elementosNovos = new Object[this.elementos.length * 2];
            for (int i=0; i<this.elementos.length; i++){
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

    // M�todo de buscar uma posi��o do vetor com retorno do elemento encontrado
    public Object busca(int posicao){
        if (!(posicao >= 0 && posicao < tamanho)){
            throw new IllegalArgumentException("Posi��o inv�lida");
        }
        return this.elementos[posicao];
    }

    // M�todo de buscar uma elemento do vetor com retorno da posi��o encontrado
    public int busca(String elemento){
        for (int i=0; i<this.tamanho; i++){
            if (this.elementos[i].equals(elemento)){
                return i;
            }
        }
        return -1;
    }

    public void remove(int posicao){
        if (!(posicao >= 0 && posicao < tamanho)){
            throw new IllegalArgumentException("Posi��o inv�lida");
        }
        for (int i=posicao; i<tamanho; i++){
            this.elementos[i] = this.elementos[i+1];
        }
        this.tamanho--;
    }

    // M�todo para listar os elementos do vetor (desconsiderando as posi��es nulas)
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

