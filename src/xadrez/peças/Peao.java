
package xadrez.peças;

import tabuleiro.Position;
import tabuleiro.Tabuleiro;
import xadrez.Color;
import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;

public class Peao extends PecaDeXadrez{
    
    private PartidaDeXadrez partida;

    public Peao(Tabuleiro tabuleiro ,Color color,PartidaDeXadrez partida ) {
        super(color, tabuleiro);
        this.partida = partida;
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
            // special move EN passant whitw
            
            if(position.getLinha() == 3){
                Position left = new Position(position.getLinha(),position.getColuna()-1);
                if(getTabuleiro().positionExistis(left) && existeOponente(left) && getTabuleiro().peca(left) == partida.getEnPassantVul()){
                    mat[left.getLinha()-1][left.getColuna()]= true;
                }
                Position right = new Position(position.getLinha(),position.getColuna()+1);
                if(getTabuleiro().positionExistis(right) && existeOponente(right) && getTabuleiro().peca(right) == partida.getEnPassantVul()){
                    mat[right.getLinha()-1][right.getColuna()]= true;
                }
            }
            
        }
        else{
            p.setValues(position.getLinha()+1, position.getColuna());
            if(getTabuleiro().positionExistis(p) && !getTabuleiro().temPecaNaposition(p)){
                mat[p.getLinha()][p.getColuna()] = true;
            }
            p.setValues(position.getLinha()+2, position.getColuna());
            Position p2 = new Position(position.getLinha()+1, position.getColuna());
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
            
            
            // special move EN passant black
            
            if(position.getLinha() == 4){
                Position left = new Position(position.getLinha(),position.getColuna()-1);
                if(getTabuleiro().positionExistis(left) && existeOponente(left) && getTabuleiro().peca(left) == partida.getEnPassantVul()){
                    mat[left.getLinha()+1][left.getColuna()]= true;
                }
                Position right = new Position(position.getLinha(),position.getColuna()+1);
                if(getTabuleiro().positionExistis(right) && existeOponente(right) && getTabuleiro().peca(right) == partida.getEnPassantVul()){
                    mat[right.getLinha()+1][right.getColuna()]= true;
                }
            }
        }
        return mat;
    }
        @Override
        public String toString(){
            return "P";
        }
  
    }