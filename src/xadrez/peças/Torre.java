
package xadrez.peças;

import tabuleiro.Tabuleiro;
import xadrez.Color;
import xadrez.PecaDeXadrez;

public class Torre extends PecaDeXadrez {
    
    public Torre(Tabuleiro tabuleiro, Color color) {
        super(color, tabuleiro);
    }
    
    @Override 
     public String toString(){
      return "T";
     }
}
