
package xadrez;

import tabuleiro.Peca;
import tabuleiro.Tabuleiro;

public abstract class PecaDeXadrez extends Peca{
    
    private Color color;

    public PecaDeXadrez(Color color ,Tabuleiro tabuleiro) {
        super(tabuleiro);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
    
    
}
