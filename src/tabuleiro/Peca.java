
package tabuleiro;

public abstract class Peca {
    
    protected Position position;
    private Tabuleiro tabuleiro;
    
    public Peca(Tabuleiro tabuleiro){
        this.tabuleiro = tabuleiro;
        position = null;
    };

    protected Tabuleiro getTabuleiro() {
        return tabuleiro;
    }
    
    public abstract boolean[][] MovimentosPossiveis();
    
    public boolean possivelMovimento(Position position){
        return MovimentosPossiveis()[position.getLinha()][position.getColuna()];
    }
    
    public boolean oMovientoEPossivel(){
        boolean[][] mat = MovimentosPossiveis();
        for(int i = 0 ;i < mat.length; i++){
            for (int j = 0 ; j < mat.length; j++){
                if(mat[i][j]){
                    return true;
                }
            }
        }
            return false;
    }
}
