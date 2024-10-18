
package xadrez;


import java.util.ArrayList;
import java.util.List;
import tabuleiro.Peca;
import tabuleiro.Position;
import tabuleiro.Tabuleiro;
import xadrez.peças.Rei;
import xadrez.peças.Torre;



public class PartidaDeXadrez {
    
    private int turn;
    private Color currentPlayer;
    private Tabuleiro tabuleiro;
    
    private List<Peca> PecasNoTabuleiro = new ArrayList<>();
    
    private List<Peca> PecasCapturadas = new ArrayList<>();
    
    public PartidaDeXadrez(){
        tabuleiro = new Tabuleiro(8,8);
        turn = 1;
        currentPlayer = Color.WHITE;
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
    
        public int getTurn(){
            return turn;
        }
    
        public Color getCurrentPlayer(){
            return currentPlayer;
        }
    
     public PecaDeXadrez executarMovimento (xadrezPosition originPosition, xadrezPosition destinyPosition){
         Position origin = originPosition.toPosition();
         Position destiny = destinyPosition.toPosition();
         validadeOriginPosition(origin);
         validadeDestinyPosition(origin,destiny);
         Peca capturePeca = makeMove(origin, destiny);
         nextTurn();
         return (PecaDeXadrez)capturePeca;
     }
     
     public boolean[][] possiveisMovimentos(xadrezPosition originPosition){
         Position position = originPosition.toPosition();
         validadeOriginPosition(position);
         return tabuleiro.peca(position).MovimentosPossiveis();
     }
     
     private Peca makeMove(Position origin, Position destiny){
         Peca p = tabuleiro.removePeca(origin);
         Peca capturePeca = tabuleiro.removePeca(destiny);
         tabuleiro.lugarDaPeca(p, destiny);
         
         if(capturePeca != null){
             PecasNoTabuleiro.remove(capturePeca);
             PecasCapturadas.add(capturePeca);
         }
         
         return capturePeca;
         
         
     
     }
     
     private void  validadeOriginPosition(Position position ){
         if(!tabuleiro.temPecaNaposition(position)){
             throw new xadrezException("Não existe peça na posição de origem");
         }
         if(currentPlayer != ((PecaDeXadrez)tabuleiro.peca(position)).getColor()){
             throw new xadrezException("A peça escolhida não é sua.");
         }
         if(!tabuleiro.peca(position).oMovientoEPossivel()){
             throw new xadrezException("Não existe movimentos possiveis para esta peça");
         }
     }
     
     private void validadeDestinyPosition(Position origin, Position destiny){
         if(!tabuleiro.peca(origin).possivelMovimento(destiny)){
              throw new xadrezException("A peça escolhida não pode se mover para a posição de destino");
         }
     
     }
     
     private void nextTurn(){
         turn++;
         currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
     }
    
    private void novoEspacoPeca(char coluna, int linha, PecaDeXadrez peca){
        tabuleiro.lugarDaPeca(peca, new xadrezPosition(coluna, linha ).toPosition());
        PecasNoTabuleiro.add(peca);
    };
    private void iniciarPartida(){
    
        novoEspacoPeca('c', 1, new Torre(tabuleiro, Color.WHITE));
        novoEspacoPeca('c', 2, new Torre(tabuleiro, Color.WHITE));
        novoEspacoPeca('d', 2, new Torre(tabuleiro, Color.WHITE));
        novoEspacoPeca('e', 2, new Torre(tabuleiro, Color.WHITE));
        novoEspacoPeca('e', 1, new Torre(tabuleiro, Color.WHITE));
        novoEspacoPeca('d', 1, new Rei(tabuleiro, Color.WHITE));

        novoEspacoPeca('c', 7, new Torre(tabuleiro, Color.BLACK));
        novoEspacoPeca('c', 8, new Torre(tabuleiro, Color.BLACK));
        novoEspacoPeca('d', 7, new Torre(tabuleiro, Color.BLACK));
        novoEspacoPeca('e', 7, new Torre(tabuleiro, Color.BLACK));
        novoEspacoPeca('e', 8, new Torre(tabuleiro, Color.BLACK));
        novoEspacoPeca('d', 8, new Rei(tabuleiro, Color.BLACK));
    };
    
}
