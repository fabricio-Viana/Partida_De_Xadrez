
package xadrez.peças;

import tabuleiro.Position;
import tabuleiro.Tabuleiro;
import xadrez.Color;
import xadrez.PecaDeXadrez;

public class Peao extends PecaDeXadrez{

    public Peao(Tabuleiro tabuleiro ,Color color) {
        super(color, tabuleiro);
    }

    @Override
    public boolean[][] MovimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
       
        Position p = new Position(0,0);
        if(getColor() == Color.WHITE){
            p.setValues(position.getLinha()-1, position.getColuna());
            if(getTabuleiro().positionExistis(p) && !getTabuleiro().temPecaNaposition(p)){
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.setValues(position.getLinha()-2, position.getColuna());
            Position p2 = new Position(position.getLinha()-1, position.getColuna());
            if(getTabuleiro().positionExistis(p) && !getTabuleiro().temPecaNaposition(p) && getTabuleiro().positionExistis(p2) && !getTabuleiro().temPecaNaposition(p2) && getMoveCount() == 0){
                mat[p.getLinha()][p.getColuna()] = true;
            }
            
            p.setValues(position.getLinha()-1, position.getColuna()-1);
            if(getTabuleiro().positionExistis(p) && existeOponente(p)){
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.setValues(position.getLinha()-1, position.getColuna()+1);
            if(getTabuleiro().positionExistis(p) && existeOponente(p)){
                mat[p.getLinha()][p.getColuna()] = true;
            }
            
        }
        else{
            p.setValues(position.getLinha()+1, position.getColuna());
            if(getTabuleiro().positionExistis(p) && !getTabuleiro().temPecaNaposition(p)){
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.setValues(position.getLinha()+2, position.getColuna());
            Position p2 = new Position(position.getLinha()-1, position.getColuna());
            if(getTabuleiro().positionExistis(p) && !getTabuleiro().temPecaNaposition(p) && getTabuleiro().positionExistis(p2) && !getTabuleiro().temPecaNaposition(p2) && getMoveCount() == 0){
                mat[p.getLinha()][p.getColuna()] = true;
            }
            
            p.setValues(position.getLinha()+1, position.getColuna()-1);
            if(getTabuleiro().positionExistis(p) && existeOponente(p)){
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.setValues(position.getLinha()+1, position.getColuna()+1);
            if(getTabuleiro().positionExistis(p) && existeOponente(p)){
                mat[p.getLinha()][p.getColuna()] = true;
            }
        
        }
        return mat;
    }
        @Override
        public String toString(){
            return "P";
        }
  
    }

