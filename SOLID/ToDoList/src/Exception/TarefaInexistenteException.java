package Exception;

public class TarefaInexistenteException extends RuntimeException {

    public TarefaInexistenteException() {
        super("Tarefa inexistente");
    }
}
