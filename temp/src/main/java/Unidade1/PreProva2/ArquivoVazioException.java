package Unidade1.PreProva2;

public class ArquivoVazioException extends RuntimeException{

    public ArquivoVazioException() {
    }

    public ArquivoVazioException(String message) {
        super(message);
    }

    public ArquivoVazioException(String message, Throwable cause) {
        super(message, cause);
    }

    public ArquivoVazioException(Throwable cause) {
        super(cause);
    }

    public ArquivoVazioException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
