
package xadrez.peças;

import tabuleiro.Tabuleiro;
import xadrez.Color;
import xadrez.PecaDeXadrez;

public class Rei extends PecaDeXadrez{
    
    public Rei(Tabuleiro tabuleiro, Color color) {
        super(color, tabuleiro);
    }
    
    @Override
   public String toString(){
       return "R";
   }
}
