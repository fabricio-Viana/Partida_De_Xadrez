
package xadrez;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import tabuleiro.Peca;
import tabuleiro.Position;
import tabuleiro.Tabuleiro;
import xadrez.peças.Bispo;
import xadrez.peças.Cavalo;
import xadrez.peças.Peao;
import xadrez.peças.Rainha;
import xadrez.peças.Rei;
import xadrez.peças.Torre;



public class PartidaDeXadrez {
    
    private int turn;
    private Color currentPlayer;
    private Tabuleiro tabuleiro;
    private boolean check;
    private boolean checkMate;
    private PecaDeXadrez enPassantVul;
    
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

    public boolean getCheck() {
        return check;
    }

    public boolean getCheckMate() {
        return checkMate;
    }

    public PecaDeXadrez getEnPassantVul() {
        return enPassantVul;
    }
        
        
    
     public PecaDeXadrez executarMovimento (xadrezPosition originPosition, xadrezPosition destinyPosition){
         Position origin = originPosition.toPosition();
         Position destiny = destinyPosition.toPosition();
         validadeOriginPosition(origin);
         validadeDestinyPosition(origin,destiny);
         Peca capturePeca = makeMove(origin, destiny);
         
         if (testCheck(currentPlayer)){
         
          UndoMove(origin,destiny,capturePeca);
          throw new xadrezException("Você não pode se colocar em check");
          
         }
         PecaDeXadrez movePeca = (PecaDeXadrez)tabuleiro.peca(destiny);
         
         
         
         check = (testCheck(opponent(currentPlayer))) ? true : false;
         
         if(testCheckMate(opponent(currentPlayer))){
             checkMate = true;
         }
         else{
            nextTurn();
         }
         
         // special move En passant
         
         if(movePeca instanceof Peao && (destiny.getLinha()== origin.getLinha()-2 || destiny.getLinha()== origin.getLinha()+2)){
             enPassantVul = movePeca;
         }
         else{
             enPassantVul = null;
         }
         
            return (PecaDeXadrez)capturePeca;
     }
     
     public boolean[][] possiveisMovimentos(xadrezPosition originPosition){
         Position position = originPosition.toPosition();
         validadeOriginPosition(position);
         return tabuleiro.peca(position).MovimentosPossiveis();
     }
     
     private Peca makeMove(Position origin, Position destiny){
         PecaDeXadrez p = (PecaDeXadrez)tabuleiro.removePeca(origin);
         p.addMoveCount();
         Peca capturePeca = tabuleiro.removePeca(destiny);
         tabuleiro.lugarDaPeca(p, destiny);
         
         if(capturePeca != null){
             PecasNoTabuleiro.remove(capturePeca);
             PecasCapturadas.add(capturePeca);
         }
         
         // roque pequeno
         if(p instanceof Rei && destiny.getColuna() == origin.getColuna() +2 ){
             Position originT = new Position(origin.getLinha(), origin.getColuna()+3);
             Position destinyT = new Position(origin.getLinha(), origin.getColuna()+1);
             PecaDeXadrez torre = (PecaDeXadrez)tabuleiro.removePeca(originT);
             tabuleiro.lugarDaPeca(torre, destinyT);
             torre.addMoveCount();
         }
         
         // roque grande
         if(p instanceof Rei && destiny.getColuna() == origin.getColuna() -2 ){
             Position originT = new Position(origin.getLinha(), origin.getColuna()-4);
             Position destinyT = new Position(origin.getLinha(), origin.getColuna()-1);
             PecaDeXadrez torre = (PecaDeXadrez)tabuleiro.removePeca(originT);
             tabuleiro.lugarDaPeca(torre, destinyT);
             torre.addMoveCount();
         }
         
         // Enpassant
         
         if(p instanceof Peao){
             if(origin.getColuna() != destiny.getColuna() && capturePeca == null){
                 Position peaoPosition;
                 if(p.getColor()== Color.WHITE){
                     peaoPosition = new Position(destiny.getLinha()+1,destiny.getColuna());
                 }
                 else{
                     peaoPosition = new Position(destiny.getLinha()-1,destiny.getColuna());

                 }
                 
                 capturePeca = tabuleiro.removePeca(peaoPosition);
                 PecasCapturadas.add(capturePeca);
                 PecasNoTabuleiro.add(capturePeca);
             }
         }
         
         return capturePeca;
     }
     
        private void UndoMove(Position origin, Position destiny, Peca capturePeca){
            PecaDeXadrez p = (PecaDeXadrez)tabuleiro.removePeca(destiny);
            p.removeMoveCount();
            tabuleiro.lugarDaPeca(p, origin);
            
            if(capturePeca != null){
             tabuleiro.lugarDaPeca(capturePeca, destiny);
             PecasCapturadas.remove(capturePeca);
             PecasNoTabuleiro.add(capturePeca);
            }
            
            // desfazer roque pequeno
         if(p instanceof Rei && destiny.getColuna() == origin.getColuna() +2 ){
             Position originT = new Position(origin.getLinha(), origin.getColuna()+3);
             Position destinyT = new Position(origin.getLinha(), origin.getColuna()+1);
             
             PecaDeXadrez torre = (PecaDeXadrez)tabuleiro.removePeca(destinyT);
             tabuleiro.lugarDaPeca(torre,originT);
             torre.removeMoveCount();
         }
         
         // desfzer roque grande
         if(p instanceof Rei && destiny.getColuna() == origin.getColuna() -2 ){
             Position originT = new Position(origin.getLinha(), origin.getColuna()-4);
             Position destinyT = new Position(origin.getLinha(), origin.getColuna()-1);
             PecaDeXadrez torre = (PecaDeXadrez)tabuleiro.removePeca(destinyT);
             tabuleiro.lugarDaPeca(torre,originT);
             torre.removeMoveCount();
         }
         
         // Enpassant
         
         if(p instanceof Peao){
             if(origin.getColuna() != destiny.getColuna() && capturePeca == enPassantVul){
                 PecaDeXadrez peao = ( PecaDeXadrez) tabuleiro.removePeca(destiny);
                 
                 Position peaoPosition;
                 if(p.getColor()== Color.WHITE){
                     peaoPosition = new Position(3,destiny.getColuna());
                 }
                 else{
                     peaoPosition = new Position(4,destiny.getColuna());

                 }
                 tabuleiro.lugarDaPeca(peao, peaoPosition);
             }
         }
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
     
     private Color opponent(Color color){
        return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }
     private PecaDeXadrez rei(Color color){
         List<Peca> list =  PecasNoTabuleiro.stream().filter(x -> ((PecaDeXadrez)x).getColor() == color).collect(Collectors.toList());
         for(Peca p : list){
             if(p instanceof Rei){
                 return (PecaDeXadrez) p;
             }
         }
         throw new IllegalStateException("Não existe o Rei da cor " + color +" no tabuleiro ");
     }
     
     private boolean testCheck(Color color){
         Position ReiPosition = rei(color).getXadrezPosition().toPosition();
         List <Peca> PecaOpponet = PecasNoTabuleiro.stream().filter(x -> ((PecaDeXadrez)x).getColor() == opponent(color)).collect(Collectors.toList());
         
         for(Peca p : PecaOpponet){
         boolean[][] mat = p.MovimentosPossiveis();
            if (mat[ReiPosition.getLinha()][ReiPosition.getColuna()]){
                return true;
            }
         }
         return false;
     }
     
     private boolean testCheckMate(Color color){
     
         if(!testCheck(color)){
             return false;
         }
         
         List<Peca> list = PecasNoTabuleiro.stream().filter(x -> ((PecaDeXadrez)x).getColor() == color).collect(Collectors.toList());
         for(Peca p : list){
             boolean[][] mat = p.MovimentosPossiveis();
             for (int i = 0;  i < tabuleiro.getLinhas(); i++){
                 for(int j = 0; j < tabuleiro.getColunas(); j++){
                     if(mat[i][j]){
                         
                         Position origin = ((PecaDeXadrez)p).getXadrezPosition().toPosition();
                         Position destiny = new Position(i,j);
                         Peca capturePeca = makeMove(origin, destiny);
                         boolean testCheck = testCheck(color);
                         UndoMove(origin,destiny,capturePeca);
                         if(!testCheck){
                             return false;
                         }
                     }
                 }
             }
         }   
         return true;
     
     }
    
    private void novoEspacoPeca(char coluna, int linha, PecaDeXadrez peca){
        tabuleiro.lugarDaPeca(peca, new xadrezPosition(coluna, linha ).toPosition());
        PecasNoTabuleiro.add(peca);
    };
    private void iniciarPartida(){
   
        novoEspacoPeca('b', 1, new Cavalo(tabuleiro, Color.WHITE));
        novoEspacoPeca('g', 1, new Cavalo(tabuleiro, Color.WHITE));
        novoEspacoPeca('a', 1, new Torre(tabuleiro, Color.WHITE));
        novoEspacoPeca('c', 1, new Bispo(tabuleiro, Color.WHITE));
        novoEspacoPeca('f', 1, new Bispo(tabuleiro, Color.WHITE));
        novoEspacoPeca('h', 1, new Torre(tabuleiro, Color.WHITE));
        novoEspacoPeca('e', 1, new Rei(tabuleiro, Color.WHITE, this));
        novoEspacoPeca('d', 1, new Rainha(tabuleiro, Color.WHITE));
        novoEspacoPeca('a', 2, new Peao(tabuleiro, Color.WHITE,this));
        novoEspacoPeca('b', 2, new Peao(tabuleiro, Color.WHITE,this));
        novoEspacoPeca('c', 2, new Peao(tabuleiro, Color.WHITE,this));
        novoEspacoPeca('d', 2, new Peao(tabuleiro, Color.WHITE,this));
        novoEspacoPeca('e', 2, new Peao(tabuleiro, Color.WHITE,this));
        novoEspacoPeca('f', 2, new Peao(tabuleiro, Color.WHITE,this));
        novoEspacoPeca('g', 2, new Peao(tabuleiro, Color.WHITE,this));
        novoEspacoPeca('h', 2, new Peao(tabuleiro, Color.WHITE,this));
        
        novoEspacoPeca('b', 8, new Cavalo(tabuleiro, Color.BLACK));
        novoEspacoPeca('g', 8, new Cavalo(tabuleiro, Color.BLACK));
        novoEspacoPeca('a', 8, new Torre(tabuleiro, Color.BLACK));
        novoEspacoPeca('c', 8, new Bispo(tabuleiro, Color.BLACK));
        novoEspacoPeca('f', 8, new Bispo(tabuleiro, Color.BLACK));
        novoEspacoPeca('h', 8, new Torre(tabuleiro, Color.BLACK));
        novoEspacoPeca('d', 8, new Rainha(tabuleiro, Color.BLACK));
        novoEspacoPeca('e', 8, new Rei(tabuleiro, Color.BLACK,this));
        novoEspacoPeca('a', 7, new Peao(tabuleiro, Color.BLACK,this));
        novoEspacoPeca('b', 7, new Peao(tabuleiro, Color.BLACK,this));
        novoEspacoPeca('c', 7, new Peao(tabuleiro, Color.BLACK,this));
        novoEspacoPeca('d', 7, new Peao(tabuleiro, Color.BLACK,this));
        novoEspacoPeca('e', 7, new Peao(tabuleiro, Color.BLACK,this));
        novoEspacoPeca('f', 7, new Peao(tabuleiro, Color.BLACK,this));
        novoEspacoPeca('g', 7, new Peao(tabuleiro, Color.BLACK,this));
        novoEspacoPeca('h', 7, new Peao(tabuleiro, Color.BLACK,this));
    };
    
    
}