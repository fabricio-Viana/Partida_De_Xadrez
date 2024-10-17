
package tabuleiro;

public class Position {
    
    private int linha;
    private int coluna;
    
    public Position(){};

    public Position(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public int getLinha() {
        return linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    @Override
    public String toString() {
        return "Posição " + "linha = " + linha + ", coluna = " + coluna;
    }
    
    public void setValues(int linha, int coluna ){
        this.linha =linha;
        this.coluna= coluna;
    }
    
    
    
}
