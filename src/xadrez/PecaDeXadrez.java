
package xadrez;

import tabuleiro.Peca;
import tabuleiro.Position;
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
    
    protected boolean existeOponente(Position position){
        PecaDeXadrez p = (PecaDeXadrez)getTabuleiro().peca(position);
        return p != null && p.getColor() != color;
    }
}
