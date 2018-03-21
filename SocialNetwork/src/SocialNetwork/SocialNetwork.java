package SocialNetwork;

/*
 * 		@author Tiago Guerreiro
 * 		@author Bernardo Borda d'Agua
 */

public interface SocialNetwork {
    // CONSTANTES
    int SUCCESSFUL_FRIENDSHIP = 0;
    int NO_REGISTRY = 1;
    int FRIENDSHIP_ALREADY_EXISTS = 2;
    int INVALID_FRIENDSHIP = 3;
    int FRIENDSHIP_NOT_EXISTENT = 4;
    int SUCCESSFUL_POST = 5;

    /*
      Determina se existe um utilizador com nome igual ao do argumento.
      @returns -
                true se existir, false se nao
     */
    boolean checkPerson(String name);

    /*
      Regista uma pessoa dentro da rede social e retorna o resultado do registo.
      @returns -
                true se conseguir registar, false se nao
     */
    boolean register(String name, String email, String status);

    /*
      Verifica se existe amizade entre duas pessoas na rede social.
      @returns -
                true se existe, false se nao
     */
    boolean checkFriendship(String name1, String name2);

    /*
      Cria uma amizade entre duas pessoas na rede social.
      @returns -
                o resultado do processo;
                SUCCESSFUL_FRIENDSHIP: se nao houve problemas;
                NO_REGISTRY: se pelo menos um dos nomes nao corresponde com uma pessoa na rede social;
                FRIENDSHIP_ALREADY_EXISTS: se as pessoas ja sao amigos;
                INVALID_FRIENDSHIP: se os argumentos forem iguais(amizade entre uma pessoa).
     */
    int friend(String name1, String name2);

    /*
      Procura a pessoa com o mesmo nome do argumento e retorna a sua friendlist.
      @returns -
                People friendlist
     */
    // @Pre: checkPerson(name);
    People checkFriendList(String name);

    // Altera o estado da pessoa com o nome do argumento.
    // @Pre: checkPerson(name);
    void changeStatus(String name, String status);

    /*
      Procura a pessoa com o mesmo nome do argumento e retorna o seu estado
      @returns -
                String status
     */
    // @Pre: checkPerson(name);
    String checkStatus(String name);

    /*
      Retorna a vetor que guarda todos os utilizadores da rede social
      @returns -
                People users
     */
    People getUsers();

    Timeline getTimeline(String user, String subject);

}
