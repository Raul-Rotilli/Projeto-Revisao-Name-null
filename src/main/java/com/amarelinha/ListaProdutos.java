package com.amarelinha;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ListaProdutos {
    Scanner s = new Scanner(System.in);
    Scanner sInt = new Scanner(System.in);
    private Map<String,Double> produtos;
    public Map<String,Double> produtosSelecionados = new HashMap<>();
    //utilizando o HashMap para dar exclusividade aos produtos
    public Map<String,Integer> quantidade = new HashMap<>();

    public ListaProdutos() {
        produtos = new HashMap<>();
        produtos.put("Celular", 0.7);
        produtos.put("Geladeira", 50.0);
        produtos.put("Air fryer", 3.5);
        produtos.put("Cadeira", 5.0);
        produtos.put("Luminaria", 0.8);
        produtos.put("Lavadora de roupa", 15.0);
        produtos.put("Playstation 5", 3.9);
        produtos.put("Nintendo Switch", 0.3);
    }

    public void listarProdutos() {
        System.out.println("Produtos disponíveis:");
        for (String produto : produtos.keySet()) {
            System.out.println(produto + " - Peso: " + produtos.get(produto) + " kg");
        }
    }

    public void selecionarProdutos() {
        int sair;
        do{
            System.out.println(produtos);

            System.out.println("Qual item voce deseja adicionar na carga? (Digite o item como ele é exibido na lista) ");
            String item = s.nextLine().toUpperCase();

            System.out.println("Qual a quantidade de itens você deseja transportar?");
            int quantidade = sInt.nextInt();

            switch (item) {
                case "CELULAR" :
                    produtosSelecionados.put(item, (quantidade * 0.70));
                    this.quantidade.put(item,quantidade);

                case "GELADEIRA" :
                    produtosSelecionados.put(item, (quantidade * 50.0));
                    this.quantidade.put(item,quantidade);

                 case "AIR FRYER" :
                    produtosSelecionados.put(item, (quantidade * 3.50));
                    this.quantidade.put(item,quantidade);

                case "CADEIRA" :
                    produtosSelecionados.put(item, (quantidade * 5.0));
                    this.quantidade.put(item,quantidade);

                case "LUMINARIA" :
                    produtosSelecionados.put(item, (quantidade * 0.80));
                    this.quantidade.put(item,quantidade);

                case "LAVADORA DE ROUPA" :
                    produtosSelecionados.put(item, (quantidade * 15.0));
                    this.quantidade.put(item,quantidade);

                case "PLAYSTATION 5" :
                    produtosSelecionados.put(item, (quantidade * 3.90));
                    this.quantidade.put(item,quantidade);

                case "NINTENDO SWITCH" :
                    produtosSelecionados.put(item, (quantidade * 0.3));
                    this.quantidade.put(item,quantidade);

                default : System.out.println("O produto não está na lista. Tente novamente inserir o produto");

            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Continuar adicionando produtos ");
            System.out.println("2 - Sair ");
            sair = sInt.nextInt();
        }

    }while(sair != 2);
        System.out.println("Lista de carga: (Produto / Peso total em KG) " + produtosSelecionados);
}
}
