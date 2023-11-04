package com.amarelinha;

public class CadastroCaminhao {
        private int Tipo;
        private double valorKm, capacidade, capacidadeTotal;

        public CadastroCaminhao(int tipo){
            this.Tipo = tipo;

            this.capacidade = 0;

            if(this.Tipo == 1){
                this.capacidadeTotal = 1000.0;
                this.valorKm = 5.83;
            }else if(this.Tipo == 2){
                this.capacidadeTotal = 4000.0;
                this.valorKm = 13.42;
            }else if(this.Tipo == 3){
                this.capacidadeTotal = 10000.0;
                this.valorKm = 29.21;
            }else{
                System.out.println("Erro!!! O custo não consegue ser calculado por conta de um código inválido!!!");
            }
        }

        public double Calculo(double distancia, int quantCaminhoes){
            double Valor = this.valorKm * distancia * quantCaminhoes;
            return Valor;
        }

        public boolean Peso(double peso){
            if(peso > capacidadeTotal || peso < capacidade){
                return false;
            }else{
                return true;
            }
        }
}
