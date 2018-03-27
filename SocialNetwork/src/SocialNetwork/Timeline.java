package SocialNetwork;

/*
 * 		@author Tiago Guerreiro
 * 		@author Bernardo Borda d'Agua
 */
public interface Timeline {

    int DEFAULT_SIZE = 3;
    int AUTHOR = 0;
    int POST = 1;
    int DIMENSIONS = 2;

    // Adiciona a pessoa argumento ao vetor people.
    void add(String post, String author);

    // Inicializa o iterador.
    void initializeIterator();

    // @Pre: initializeIterator();
    boolean hasNext();

    // @Pre: hasNext();
    String[] next();
}
