package src;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();
        arvoreBinaria.inserir(10);
        arvoreBinaria.inserir(5);
        arvoreBinaria.inserir(30);
        arvoreBinaria.inserir(35);
        arvoreBinaria.inserir(18);
        arvoreBinaria.inserir(20);
        arvoreBinaria.inserir(19);
        arvoreBinaria.inserir(9);
        arvoreBinaria.inserir(3);
        arvoreBinaria.inserir(15);
        arvoreBinaria.inserir(1);

        arvoreBinaria.removerNo(5);

        System.out.println("Pre-ordem: ");
        arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());

        /*
        System.out.println("Pre-ordem: ");
        arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
        System.out.println("Em ordem: ");
        arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());
        System.out.println("Pos ordem: ");
        arvoreBinaria.posOrdem(arvoreBinaria.getRaiz());
        */
    }
}