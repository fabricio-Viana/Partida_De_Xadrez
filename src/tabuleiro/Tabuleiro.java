
package tabuleiro;


public class Tabuleiro {
    
    private int linhas;
    private int colunas;
    private Peca[][] pecas;

    public Tabuleiro(int linhas, int colunas) {
        if(linhas < 1 || colunas < 1){
            throw new TabException("erro na criação do tabuleiro, tem que ter pelo menos uma linha e uma coluna");
        }
        this.linhas = linhas;
        this.colunas = colunas;
        pecas = new Peca[linhas][colunas];
     
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }
   
    public Peca peca(int linhas, int colunas){
        if(!positionExistis(linhas,colunas)){
          throw new TabException("Posição não esta no tabuleiro");
        }
        return pecas[linhas][colunas];
    }
    public Peca peca(Position position){
        if(!positionExistis(position)){
          throw new TabException("Posição não esta no tabuleiro");
        }
        return pecas[position.getLinha()][position.getColuna()];
    }
           
    public void lugarDaPeca(Peca peca, Position position ){
        
        if(temPecaNaposition(position)){
            throw new TabException("ja existe uma peça nesta posição: "+ position);
        }
        pecas[position.getLinha()][position.getColuna()] = peca;
        peca.position = position;
    }
    
    public boolean positionExistis(int linha, int coluna){
     return linha >=0 && linha < linhas && coluna >= 0 && coluna< colunas;
    }
    
    public boolean positionExistis(Position position){
     return positionExistis(position.getLinha(),position.getColuna());
    }
    
    public boolean temPecaNaposition(Position position){
        if(!positionExistis(position)){
          throw new TabException("Posição não existe no tabuleiro");
        }
        return peca(position) != null;
                
    }
}
