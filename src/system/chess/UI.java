
package system.chess;

import xadrez.PecaDeXadrez;

public class UI {
    
    public static void printTabuleiro(PecaDeXadrez[][] pecas){
        
        for(int i = 0 ; i < pecas.length; i++){
            System.out.print( (8-i) + " ");
            for(int j =0; j < pecas.length; j++){
            printPeca(pecas[i][j]);
            }
            System.out.println();       
        }
            System.out.println("  A B C D E F G H");
    
    }
    
    public static void printPeca(PecaDeXadrez peca){
        if(peca == null){
            System.out.print("-");
        }
        else{
            System.out.print(peca);
        }
        System.out.print(" ");
    };
}
