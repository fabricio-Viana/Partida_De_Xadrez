
package xadrez.peças;

import tabuleiro.Position;
import tabuleiro.Tabuleiro;
import xadrez.Color;
import xadrez.PecaDeXadrez;

public class Rei extends PecaDeXadrez{
    
    public Rei(Tabuleiro tabuleiro, Color color) {
        super(color, tabuleiro);
    }
    
    @Override
   public String toString(){
       return "r";
   }

    @Override
    public boolean[][] MovimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
        
        Position p = new Position(0,0);
        
        //above
        
        p.setValues(position.getLinha() -1, position.getColuna());
        if(getTabuleiro().positionExistis(p) && podeMover(p)){
        
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //below
        
        p.setValues(position.getLinha() +1, position.getColuna());
        if(getTabuleiro().positionExistis(p) && podeMover(p)){
        
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //esquerda
        
        p.setValues(position.getLinha() , position.getColuna() -1);
        if(getTabuleiro().positionExistis(p) && podeMover(p)){
        
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //direita
        
        p.setValues(position.getLinha(), position.getColuna() +1);
        if(getTabuleiro().positionExistis(p) && podeMover(p)){
        
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //noroeste
        
        p.setValues(position.getLinha() -1, position.getColuna() -1);
        if(getTabuleiro().positionExistis(p) && podeMover(p)){
        
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //nordeste
        
        p.setValues(position.getLinha() -1, position.getColuna() +1);
        if(getTabuleiro().positionExistis(p) && podeMover(p)){
        
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //sudoeste
        
        p.setValues(position.getLinha() +1, position.getColuna() -1);
        if(getTabuleiro().positionExistis(p) && podeMover(p)){
        
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        //Sudets
        
        p.setValues(position.getLinha() +1, position.getColuna() +1);
        if(getTabuleiro().positionExistis(p) && podeMover(p)){
        
            mat[p.getLinha()][p.getColuna()] = true;
        }
        
        return mat;
    }
    
    private boolean podeMover(Position position){
        PecaDeXadrez p = (PecaDeXadrez) getTabuleiro().peca(position);
        return p == null || p.getColor() != getColor();
    }
}
