
package xadrez;

import tabuleiro.Peca;
import tabuleiro.Position;
import tabuleiro.Tabuleiro;

public abstract class PecaDeXadrez extends Peca{
    
    private Color color;
    protected int moveCount;

    public PecaDeXadrez(Color color ,Tabuleiro tabuleiro) {
        super(tabuleiro);
        this.color = color;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public Color getColor() {
        return color;
    }
    
    public void addMoveCount(){
        moveCount++;
    }
    public void removeMoveCount(){
        moveCount--;
    }
    public xadrezPosition getXadrezPosition(){
        return xadrezPosition.daPosition(position);
    }
    
    protected boolean existeOponente(Position position){
        PecaDeXadrez p = (PecaDeXadrez)getTabuleiro().peca(position);
        return p != null && p.getColor() != color;
    }
}
