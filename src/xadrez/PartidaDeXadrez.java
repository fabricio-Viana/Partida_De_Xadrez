
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
    
    private void novoEspacoPeca(char coluna, int linha, PecaDeXadrez peca){
        tabuleiro.lugarDaPeca(peca, new xadrezPosition(coluna, linha ).toPosition());
    };
    private void iniciarPartida(){
    
       novoEspacoPeca('b', 6 , new Torre(tabuleiro, Color.WHITE));
       novoEspacoPeca('e', 8 , new Rei(tabuleiro, Color.BLACK));
       novoEspacoPeca('e', 1 , new Rei(tabuleiro, Color.WHITE));
    };
    
}
