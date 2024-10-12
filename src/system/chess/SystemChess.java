
package system.chess;

import java.util.Scanner;
import tabuleiro.Position;
import tabuleiro.Tabuleiro;
import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.xadrezPosition;

public class SystemChess {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
       PartidaDeXadrez partida = new PartidaDeXadrez();
       
       while(true){
          UI.printTabuleiro(partida.GetPecas());
           System.out.println();
           System.out.println("origin: ");
           xadrezPosition origin = UI.lerPositionXadrez(sc);
           
           System.out.println();
           System.out.println("destiny: ");
           xadrezPosition destiny = UI.lerPositionXadrez(sc);
           
           PecaDeXadrez capturePeca = partida.executarMovimento(origin, destiny);
           
       
       }
       
    }
    
}
