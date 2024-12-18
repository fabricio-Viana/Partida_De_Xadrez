
package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import xadrez.Color;
import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.xadrezPosition;

public class UI {
    
    
    
        public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSIL_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    
      
        public static void clearScreen() {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
        
        
        public static xadrezPosition lerPositionXadrez(Scanner sc ){
            try{
                String s = sc.nextLine();
                char coluna = s.charAt(0);
                int linha = Integer.parseInt(s.substring(1));
                return new xadrezPosition(coluna ,linha);
            }
            catch(RuntimeException e ){
                throw new InputMismatchException("error lendo posição de xadrez, valores validos são de a1 a h8");
            }
        }
    public static void printTabuleiro(PecaDeXadrez[][] pecas){
        
        for(int i = 0 ; i < pecas.length; i++){
            System.out.print( (8-i) + " ");
            for(int j =0; j < pecas.length; j++){
            printPeca(pecas[i][j],false);
            }
            System.out.println();       
        }
        
            System.out.println("  a b c d e f g h");
    
    }
    
    
    public static void printPartida(PartidaDeXadrez partida, List<PecaDeXadrez> capiturado){
    
        printTabuleiro(partida.GetPecas());
        System.out.println("");
        printPecasCapituradas(capiturado);
        System.out.println("");
        System.out.println("Turno : " + partida.getTurn());
        if(!partida.getCheckMate()){
            System.out.println("Esperando o Jogador "+ partida.getCurrentPlayer());
            if(partida.getCheck()){
                System.out.println("CHECK!");
            }
        }
        else{
            System.out.println("CHECKMATE!");
            System.out.println("VENCEDOR: "+ partida.getCurrentPlayer());
        }
    } 
    
    
    public static void printTabuleiro(PecaDeXadrez[][] pecas, boolean[][] possivelMovimento){
        
        for(int i = 0 ; i < pecas.length; i++){
            System.out.print( (8-i) + " ");
            for(int j =0; j < pecas.length; j++){
            printPeca(pecas[i][j], possivelMovimento[i][j]);
            }
            System.out.println();       
        }
        
            System.out.println("  a b c d e f g h");
    
    }
    
    private static void printPeca(PecaDeXadrez piece, boolean planoDeFundo) {
        if(planoDeFundo){
            System.out.print(ANSI_RED_BACKGROUND);
        }
    	if (piece == null) {
            System.out.print("-" + ANSI_RESET);
        }
        else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_GREEN + piece + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_PURPLE + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");
	}
    
    private static void printPecasCapituradas(List<PecaDeXadrez> capiturado){
        List<PecaDeXadrez> white = capiturado.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
        List<PecaDeXadrez> black = capiturado.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());
        
        System.out.println("Peças capiturdas: ");
        System.out.print("WHITE: ");
        System.out.print(ANSI_GREEN);
        System.out.println(Arrays.toString(white.toArray()));
        System.out.print(ANSI_RESET);
        
        System.out.print("BLACK: ");
        System.out.print(ANSI_PURPLE);
        System.out.println(Arrays.toString(black.toArray()));
        System.out.print(ANSI_RESET);
        
    }   
    
}
