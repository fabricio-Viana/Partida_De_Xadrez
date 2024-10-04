
package system.chess;

import tabuleiro.Position;
import tabuleiro.Tabuleiro;
import xadrez.PartidaDeXadrez;

public class SystemChess {

    public static void main(String[] args) {

       PartidaDeXadrez partida = new PartidaDeXadrez();
       UI.printTabuleiro(partida.GetPecas());
    }
    
}
