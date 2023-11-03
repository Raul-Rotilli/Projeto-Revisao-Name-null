package com.amarelinha;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LeitorCSV {
    private int[][] matrizDistancias;
    public HashMap<String, Integer> indice = new HashMap<>();

    public int[][] getMatrizDistancias() {
        return matrizDistancias;
    }



    public LeitorCSV(){
        run();
    }

    public void run(){
        String arquivoCSV = "src/main/java/com/amarelinha/DistanciaCidadesCSV.csv";
        BufferedReader br = null;
        String linha = "";
        int linhaAtual = 0;
        String divisorStringCSV = ";";

        String[] cidades = null;
        String[] conteudoCSV = null;
        int contador = 0;
        try {
            br = new BufferedReader(new FileReader(arquivoCSV));

            while ((linha = br.readLine()) != null){
                contador++;
                conteudoCSV = linha.split(divisorStringCSV);

                System.out.println("Volta:" + contador);
                System.out.println(cidades);

                if (cidades == null) {
                    System.out.println("aiaiai");
                    cidades = conteudoCSV;
                    matrizDistancias = new int [cidades.length][cidades.length];

                    for (int i  = 0; i < cidades.length; i++){
                        indice.put(cidades[i],i);
                        System.out.println(indice);
                    }
                }else {
                    for (int i = 0; i < conteudoCSV.length;i++){
                        // o contador i vai representar as colunas
                        matrizDistancias[linhaAtual][i] = Integer.parseInt(conteudoCSV[i]);

                    }
                    linhaAtual++;
                }



            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(indice);
//        System.out.println(matrizDistancias);

    }

}