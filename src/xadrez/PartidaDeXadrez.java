
package xadrez;


import tabuleiro.Position;
import tabuleiro.Tabuleiro;
import xadrez.peças.Rei;
import xadrez.peças.Torre;



public class PartidaDeXadrez {
    
    private Tabuleiro tabuleiro;
    
    public PartidaDeXadrez(){
        tabuleiro = new Tabuleiro(8,8);
        iniciarPartida();
    };
    
    public PecaDeXadrez[][] GetPecas(){
        PecaDeXadrez[][] mat = new PecaDeXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        for(int i=0; i < tabuleiro.getLinhas();i++ ){
            for(int j = 0 ; j < tabuleiro.getColunas();j++){
                mat[i][j] = (PecaDeXadrez) tabuleiro.peca(i, j);
        }
        }
        return mat;
    }
    
    private void iniciarPartida(){
    
       tabuleiro.lugarDaPeca(new Torre(tabuleiro, Color.WHITE), new Position(2,1));
       tabuleiro.lugarDaPeca(new Rei(tabuleiro, Color.BLACK), new Position(0,4));
       tabuleiro.lugarDaPeca(new Rei(tabuleiro, Color.WHITE), new Position(7,4));
    };
    
}
