package src;

public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(int valor) {
        No novoNo = new No(valor);
        if(this.raiz == null) {
            this.raiz = novoNo;
        } else {
            No atual = this.raiz;
            No pai = null;
            boolean esquerda = false;
            while(atual != null) {
                if(novoNo.getValor() < atual.getValor()) {
                    pai = atual;
                    atual = atual.getEsq();
                    esquerda = true;
                } else {
                    pai = atual;
                    atual = atual.getDir();
                    esquerda = false;
                }
            }
            if(esquerda) {
                pai.setEsq(novoNo);
            } else {
                pai.setDir(novoNo);
            }
        }
    }

    public No getRaiz() {
        return this.raiz;
    }

    public void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getValor());
        preOrdem(no.getEsq());
        preOrdem(no.getDir());
    }

    public void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsq());
        System.out.println(no.getValor());
        emOrdem(no.getDir());
    }

    public void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsq());
        posOrdem(no.getDir());
        System.out.println(no.getValor());
    }

    public void removerNo(int valor) {
        if (this.raiz == null) {
            System.out.println("Árvore binária vazia.");
        } else {
            No atual = this.raiz;
            No pai = atual;
            while (atual != null) {
                if (valor == atual.getValor()) {
                    if (atual.getEsq() == null && atual.getDir() == null) {
                        System.out.println("CASO NO FOLHA.");
                        removerNoFolha(pai, atual);
                    } else if ((atual.getEsq() != null && atual.getDir() == null) || (atual.getEsq() == null && atual.getDir() != null)) {
                        System.out.println("CASO NO 1 FILHO.");
                        removerNoFilho(pai, atual);
                    } else if (atual.getEsq() != null && atual.getDir() != null) {
                        System.out.println("CASO NO 2 FILHOS.");
                        removerNoDoisFilhos(pai, atual);
                    }
                    return;
                } else if (valor < atual.getValor()) {
                    pai = atual;
                    atual = atual.getEsq();
                } else {
                    pai = atual;
                    atual = atual.getDir();
                }
            }
        }
        System.out.println("Valor " + valor + " não encontrado na Árvore Binária.");
    }

    public void removerNoFolha (No pai, No atual) {
        if (atual == pai.getEsq()) {
            pai.setEsq(null);
        } else {
            pai.setDir(null);
        }
        System.out.println("No " + atual.getValor() + " removido com sucesso.");
    }

    public void removerNoFilho (No pai, No atual) {
        // Checa onde o Nó possui um filho e transforma ele nesse filho
        if (atual.getEsq() != null) {
            if (atual == pai.getEsq()) {
                pai.setEsq(atual.getEsq());
            } else {
                pai.setDir(atual.getEsq());
            }
        } else {
            if (atual == pai.getEsq()) {
                pai.setEsq(atual.getDir());
            } else {
                pai.setDir(atual.getDir());
            }
        }
        System.out.println("No " + atual.getValor() + " removido com sucesso.");
    }

    public void removerNoDoisFilhos (No pai, No atual) {
        No apoio = atual;
        No maior = atual.getEsq();
        while (maior.getDir() != null) {
            apoio = maior;
            maior = maior.getDir();
        }
        System.out.println("Maior No: " + maior.getValor());
        atual.setValor(maior.getValor());
        apoio.setDir(maior.getEsq());
    }
}
