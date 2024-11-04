package xadrez.peças;

import tabuleiro.Position;
import tabuleiro.Tabuleiro;
import xadrez.Color;
import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;

public class Rei extends PecaDeXadrez{
    
    private PartidaDeXadrez partida;
    
    public Rei(Tabuleiro tabuleiro, Color color,PartidaDeXadrez partida) {
        super(color, tabuleiro);
        this.partida = partida;
    }
    
    @Override
   public String toString(){
       return "r";
   }
        private boolean podeMover (Position position){
        PecaDeXadrez p = (PecaDeXadrez) getTabuleiro().peca(position);
        return p == null || p.getColor() != getColor();
    }
   
    private boolean testRoque(Position position){
        
        PecaDeXadrez p =(PecaDeXadrez)getTabuleiro().peca(position);
        return p != null && p instanceof Torre && p.getColor() == getColor()&& p.getMoveCount() == 0;
    
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
        
        // special move
        if (getMoveCount() == 0 && !partida.getCheck()){
         // roque pqueno 
         Position posT1 = new Position(position.getLinha(),position.getColuna()+3);
             if(testRoque(posT1)){
             Position p1 = new Position(position.getLinha(),position.getColuna()+1);
             Position p2 = new Position(position.getLinha(),position.getColuna()+2);
             if(getTabuleiro().peca(p1)== null && getTabuleiro().peca(p2)== null){
             mat[position.getLinha()][position.getColuna() + 2 ] = true;  
             }
             }
          // roque grande  
          Position posT2 = new Position(position.getLinha(),position.getColuna()-4);
             if(testRoque(posT2)){
                Position p1 = new Position(position.getLinha(),position.getColuna()-1);
                Position p2 = new Position(position.getLinha(),position.getColuna()-2);
                Position p3 = new Position(position.getLinha(),position.getColuna()-3);
                if(getTabuleiro().peca(p1)== null && getTabuleiro().peca(p2)== null && getTabuleiro().peca(p3)== null){
                    mat[position.getLinha()][position.getColuna() - 2 ] = true;  
                }
         }
        }
        
        return mat;
    }
      
}

