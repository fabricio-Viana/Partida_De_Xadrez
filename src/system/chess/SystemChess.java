
package system.chess;

import java.util.InputMismatchException;
import java.util.Scanner;
import tabuleiro.Position;
import tabuleiro.Tabuleiro;
import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.xadrezException;
import xadrez.xadrezPosition;

public class SystemChess {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
       PartidaDeXadrez partida = new PartidaDeXadrez();
       
       while(true){
          try{
              
                UI.clearScreen();
                UI.printTabuleiro(partida.GetPecas());
                 System.out.println();
                 System.out.println("origin: ");
                 xadrezPosition origin = UI.lerPositionXadrez(sc);

                 System.out.println();
                 System.out.println("destiny: ");
                 xadrezPosition destiny = UI.lerPositionXadrez(sc);

                 PecaDeXadrez capturePeca = partida.executarMovimento(origin, destiny);
           
          }
          catch(xadrezException | InputMismatchException e){
              System.out.println(e.getMessage());
              sc.nextLine();
          }
           
       
       }
       
    }
    
}
