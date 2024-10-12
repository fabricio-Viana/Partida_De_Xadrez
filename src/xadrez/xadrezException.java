
package xadrez;

import tabuleiro.TabException;

public class xadrezException extends TabException{
    
    private static final long serialVersionUDI = 1L;
    
    public xadrezException(String msg){
        super(msg);
    }
}
