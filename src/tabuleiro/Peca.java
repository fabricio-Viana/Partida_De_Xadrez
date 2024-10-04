
package tabuleiro;

public class Peca {
    
    protected Position position;
    private Tabuleiro tabuleiro;
    
    public Peca(Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;
        position = null;
    };

    protected Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
    
    
}
