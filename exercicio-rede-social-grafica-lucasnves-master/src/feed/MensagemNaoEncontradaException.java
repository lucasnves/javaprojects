package feed;
import java.util.NoSuchElementException;

public class MensagemNaoEncontradaException extends NoSuchElementException {
    //private int idPostagem;
    
    public MensagemNaoEncontradaException(int idPostagem) {
        //this.idPostagem = idPostagem;
    }
}
