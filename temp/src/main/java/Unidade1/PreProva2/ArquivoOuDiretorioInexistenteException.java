package Unidade1.PreProva2;

public class ArquivoOuDiretorioInexistenteException extends RuntimeException{

    public ArquivoOuDiretorioInexistenteException() {
    }

    public ArquivoOuDiretorioInexistenteException(String message) {
        super(message);
    }

    public ArquivoOuDiretorioInexistenteException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArquivoOuDiretorioInexistenteException(Throwable cause) {
        super(cause);
    }
}
