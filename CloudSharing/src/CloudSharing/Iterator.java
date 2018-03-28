package CloudSharing;

public interface Iterator {

    int DEFAULT_SIZE = 10;
    /**
     * Verifica se existe um elemento a seguir no vetor.
     *
     * @return - true se houver elemento a seguir;
     *           false se nao houver.
     */
    boolean hasNext();

    /**
     *
     * @return - Objeto - Object Class
     */
    Object next();

    /**
     * Inicializa o iterador.
     */
    void initializeIterator();

    /**
     * Adiciona um objeto ao vetor da class.
     *
     * @param object objeto a adicionar
     * @return - true se adicionou o objeto com sucesso;
     *           false se nao adicionou o objeto.
     */
    void add(Object object);
}
