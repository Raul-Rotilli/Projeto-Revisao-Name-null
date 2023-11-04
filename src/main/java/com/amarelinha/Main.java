package com.amarelinha;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        LeitorCSV l = new LeitorCSV();
        CadastroCaminhao cc = new CadastroCaminhao(1);
        l.listarCidades();
        ListaProdutos lp = new ListaProdutos();
        lp.selecionarProdutos();

    }
}