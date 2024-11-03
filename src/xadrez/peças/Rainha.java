
package xadrez.peças;

import tabuleiro.Position;
import tabuleiro.Tabuleiro;
import xadrez.Color;
import xadrez.PecaDeXadrez;

public class Rainha extends PecaDeXadrez {
    
    public Rainha(Tabuleiro tabuleiro, Color color) {
        super(color, tabuleiro);
    }
    
    @Override 
     public String toString(){
      return "R";
     }
     
     @Override
    public boolean[][] MovimentosPossiveis() {
        boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
       
        Position p = new Position(0,0);
        
        // acima da Peça
        p.setValues(position.getLinha() -1, position.getColuna());
        while(getTabuleiro().positionExistis(p) && !getTabuleiro().temPecaNaposition(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setLinha(p.getLinha() -1);
            
        }
        
        if(getTabuleiro().positionExistis(p) && existeOponente(p)){
              mat[p.getLinha()][p.getColuna()] = true;
        
        }
        
        // Esquerda da Peça
        p.setValues(position.getLinha(), position.getColuna() -1);
        while(getTabuleiro().positionExistis(p) && !getTabuleiro().temPecaNaposition(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(p.getColuna() -1);
            
        }
        
        if(getTabuleiro().positionExistis(p) && existeOponente(p)){
              mat[p.getLinha()][p.getColuna()] = true;
        
        }
        
        // Direita da Peça
        p.setValues(position.getLinha(), position.getColuna() +1);
        while(getTabuleiro().positionExistis(p) && !getTabuleiro().temPecaNaposition(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setColuna(p.getColuna() +1);
            
        }
        
        if(getTabuleiro().positionExistis(p) && existeOponente(p)){
              mat[p.getLinha()][p.getColuna()] = true;
        
        }
        
        // Abaixo da Peça
        p.setValues(position.getLinha() +1, position.getColuna());
        while(getTabuleiro().positionExistis(p) && !getTabuleiro().temPecaNaposition(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setLinha(p.getLinha() +1);
            
        }
        
        if(getTabuleiro().positionExistis(p) && existeOponente(p)){
              mat[p.getLinha()][p.getColuna()] = true;
        
        }
        // nw
        p.setValues(position.getLinha() -1, position.getColuna()-1);
        while(getTabuleiro().positionExistis(p) && !getTabuleiro().temPecaNaposition(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setValues(p.getLinha()-1, p.getColuna()-1);
            
        }
        
        if(getTabuleiro().positionExistis(p) && existeOponente(p)){
              mat[p.getLinha()][p.getColuna()] = true;
        
        }
        
        // ne
        p.setValues(position.getLinha()-1, position.getColuna() +1);
        while(getTabuleiro().positionExistis(p) && !getTabuleiro().temPecaNaposition(p)){
            mat[p.getLinha()][p.getColuna()] = true;
            p.setValues(p.getLinha()-1, p.getColuna()+1);
            
        }
        
        if(getTabuleiro().positionExistis(p) && existeOponente(p)){
              mat[p.getLinha()][p.getColuna()] = true;
        
        }
        
        // se
        p.setValues(position.getLinha()+1, position.getColuna() +1);
        while(getTabuleiro().positionExistis(p) && !getTabuleiro().temPecaNaposition(p)){
            mat[p.getLinha()][p.getColuna()] = true;
             p.setValues(p.getLinha()+1, p.getColuna()+1);
            
        }
        
        if(getTabuleiro().positionExistis(p) && existeOponente(p)){
              mat[p.getLinha()][p.getColuna()] = true;
        
        }
        
        // sw
        p.setValues(position.getLinha() +1, position.getColuna()-1);
        while(getTabuleiro().positionExistis(p) && !getTabuleiro().temPecaNaposition(p)){
            mat[p.getLinha()][p.getColuna()] = true;
             p.setValues(p.getLinha()+1, p.getColuna()-1);
            
        }
        
        if(getTabuleiro().positionExistis(p) && existeOponente(p)){
              mat[p.getLinha()][p.getColuna()] = true;
        
        }
        
        
        return mat;
        
    }
    
    
}
