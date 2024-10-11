
package tabuleiro;

public class TabException extends RuntimeException {
    
    private static final long serialVercionUID = 1L;
    
    public TabException(String msg){
        super(msg);
    }
    
}
