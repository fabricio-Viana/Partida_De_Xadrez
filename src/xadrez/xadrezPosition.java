
package xadrez;

import tabuleiro.Position;


public class xadrezPosition {
    
    private char coluna;
    private int linha;

    public xadrezPosition(char coluna, int linha) {
        if(coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8){
            throw new xadrezException("erro ao estanciar Xadrez position, os valores validos são de a1 a h8 ");
        }
        this.coluna = coluna;
        this.linha = linha;
    }

    public char getColuna() {
        return coluna;
    }

    public int getLinha() {
        return linha;
    }
   
    protected Position toPosition(){
        return new Position(8 - linha, coluna -'a'); 
    }
    
    protected static xadrezPosition daPosition (Position position){
    
        return new xadrezPosition((char)('a'+ position.getColuna()),8 - position.getLinha());
    
    }  
    
    @Override
    public String toString(){
        return "" + coluna + linha;
    }
    
}
