
package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import tabuleiro.Position;
import tabuleiro.Tabuleiro;
import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.xadrezException;
import xadrez.xadrezPosition;

public class Program {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
       PartidaDeXadrez partida = new PartidaDeXadrez();
       List<PecaDeXadrez> capiturado = new ArrayList<>();
       
       while(true){
          try{
              
                UI.clearScreen();
                UI.printPartida(partida,capiturado);
                 System.out.println();
                 System.out.println("origin: ");
                 xadrezPosition origin = UI.lerPositionXadrez(sc);
                 
                 boolean[][] possivelMovimento = partida.possiveisMovimentos(origin);
                 UI.clearScreen();
                 UI.printTabuleiro(partida.GetPecas(),possivelMovimento);

                 System.out.println();
                 System.out.println("destiny: ");
                 xadrezPosition destiny = UI.lerPositionXadrez(sc);

                 PecaDeXadrez capturePeca = partida.executarMovimento(origin, destiny);
                 
                 if(capturePeca != null){
                     
                     capiturado.add(capturePeca);
                 }
           
          }
          catch(xadrezException | InputMismatchException e){
              System.out.println(e.getMessage());
              sc.nextLine();
          }
           
       
       }
       
    }
    
}
