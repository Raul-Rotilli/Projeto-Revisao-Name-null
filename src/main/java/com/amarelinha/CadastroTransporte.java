package com.amarelinha;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;

public class CadastroTransporte extends ListaProdutos{
    private int caminhoesPequenos, caminhoesMedios, caminhoesGrandes, numeroDeTrechos;

    private double custoPorCaminhoesPequenos, custoPorCaminhoesMedios, custoPorCaminhoesGrandes;
    ArrayList<Double> distanciaTrechos = new ArrayList<>();
    ArrayList<Double> precosTotais = new ArrayList<>();
    ArrayList<Double> precosAdicionados = new ArrayList<>();
    DecimalFormat df = new DecimalFormat("###.##");

    public double calculaCustoTotal(ArrayList precosTotais){
        double precoTotal = 0;
        for(Object preco : precosTotais){
            precoTotal += (double) preco;
        }
        return precoTotal;
    }

    public double calculaDistanciaTotalDeTrechos(ArrayList distanciaDeTrechos){
        double distanciaTotal = 0;
        for (Object distanciaDeTrecho : distanciaDeTrechos) {
            distanciaTotal += (double)distanciaDeTrecho;
        }
        return distanciaTotal;
    }

    public double calculaCustoPorTrecho(int numeroDeTrechos){
        return calculaCustoTotal(this.precosTotais) / numeroDeTrechos;
    }

    public double calculaCustoMedioPorKm(){
        return calculaCustoTotal(this.precosTotais) / calculaDistanciaTotalDeTrechos(this.distanciaTrechos);
    }

    public void calculaCustoMedioPorProduto(Map<String,Double> selectProducts, Map<String, Integer> productsQuantity, ArrayList<Double> precos){
        for (Map.Entry<String,Double> chaveAtual : selectProducts.entrySet()){
            if(chaveAtual.getKey() != null && chaveAtual.getValue() != null) {
                double precoMedioPorProduto = precos.get(0) / productsQuantity.get(chaveAtual.getKey() );
                System.out.println("O preço médio por " + chaveAtual.getKey() + " é de : R$" + df.format(precoMedioPorProduto));
            }
        }
    };

    public void contaTotalDeItensTransportados(Map<String,Integer> productsQuantity){
        int totalDeItens = 0;
        for(Map.Entry<String,Integer> chaveAtual : productsQuantity.entrySet()){
            totalDeItens += chaveAtual.getValue();
        }
        System.out.println("Total de itens transportados: " + totalDeItens);
    }


    public double calculaCustoPorCaminhaoPequeno(double distancia){
        return (this.caminhoesPequenos * distancia) * 5.83;
    };

    public double calculaCustoPorCaminhaoMedio(double distancia){
        return (this.caminhoesMedios * distancia) * 13.42;
    }

    public double calculaCustoPorCaminhaoGrande(double distancia){
        return (this.caminhoesGrandes * distancia) * 29.21;
    }



    public void exibeEstatisticas(){
        System.out.println("Preco total: R$ " + calculaCustoTotal(precosTotais));
        System.out.println("Custo médio por KM: R$" + calculaCustoMedioPorKm());
        System.out.println("Custo por trecho: R$" + calculaCustoPorTrecho(numeroDeTrechos));
        System.out.println("Total de caminhões pequenos utilizados: " + this.caminhoesPequenos);
        System.out.println("Total de caminhões médios utilizados: " + this.caminhoesMedios);
        System.out.println("Total de caminhões grandes utilizados: " + this.caminhoesGrandes);
    }
}

