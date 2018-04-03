package SocialNetwork;

/*
 * 		@author Tiago Guerreiro
 * 		@author Bernardo Borda d'Agua
 */

public interface People {
//    CONSTANTES
    int FRIEND_LIST_SIZE = 50;
    int SOCIAL_NETWORK_SIZE = 500;

    // Adiciona a pessoa argumento ao vetor people.
    void add(Person person);

    // Inicializa o iterador.
    void initializeIterator();

    // @Pre: initializeIterator();
    boolean hasNext();

    /*
       Retorna a pessoa atual no iterador e avanca o iterador.
       @returns -
                 Person object
     */
    // @Pre: hasNext();
    Person next();
}
