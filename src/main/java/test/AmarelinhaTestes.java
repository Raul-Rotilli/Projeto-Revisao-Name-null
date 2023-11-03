package test;

import com.amarelinha.LeitorCSV;
import org.junit.Test;

public class AmarelinhaTestes {

    //TESTES Leitor CSV/DistanciaCidadesCSV

    LeitorCSV leitorCSV = new LeitorCSV();

    @Test
    public void imprimeArrayDistancias(){
        for (int i = 0; i < leitorCSV.getMatrizDistancias().length; i++) {
            for (int j = 0; j < leitorCSV.getMatrizDistancias()[i].length; j++) {
                System.out.print(leitorCSV.getMatrizDistancias()[i][j] + " ");
            }
            System.out.println(); // Para pular para a próxima linha após cada linha da matriz
        }
    }

    @Test
    public void imprimeCidades(){
        for (int i = 0; i < leitorCSV.indice.size(); i++){
            System.out.println(leitorCSV.indice.get(i));
        }
        System.out.println(leitorCSV.indice);
    }

}
