
package tabuleiro;


public class Tabuleiro {
    
    private int linhas;
    private int colunas;
    private Peca[][] pecas;

    public Tabuleiro(int lihas, int colunas) {
        this.linhas = lihas;
        this.colunas = colunas;
        pecas = new Peca[linhas][colunas];
     
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    public void setLinhas(int linhas) {
        this.linhas = linhas;
    }

    public void setColunas(int colunas) {
        this.colunas = colunas;
    }
   
    public Peca peca(int linhas, int colunas){
        return pecas[linhas][colunas];
    }
    public Peca peca(Position position){
        return pecas[position.getLinha()][position.getColuna()];
    }
           
    public void lugarDaPeca(Peca peca, Position position ){
        pecas[position.getLinha()][position.getColuna()] = peca;
        peca.position = position;
    }
}
