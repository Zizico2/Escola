package SocialNetwork;

/*
 * 		@author Tiago Guerreiro
 * 		@author Bernardo Borda d'Agua
 */

    public interface Person {

        // Adiciona o argumento Person (pessoa) a friendList.
        void addFriend(Person friend);

        /*
          Retorna o nome.
          @returns -
                    String nome
        */
        // @Pre: name != null;
        String getName();

        /*
          Retorna o estado.
          @returns -
                    String status.
         */
        // @Pre: status != null;
        String getStatus();

        /*
          Retorna o email.
          @returns -
                    String email
         */
        // @Pre: email != null;
        String getEmail();

        // Atualiza o estado da pessoa para o argumento.
        void setStatus(String status);

        /*
          Procura na "friendList" se existe a pessoa com o nome do argumento.
          @returns -
                    true se for amigo, false se nao for amigo
         */
        boolean checkFriend(String name);

        /*
          Retorna o objeto friendList (lista de amigos).
          @returns -
                    People friendList
         */
        People getFriendList();

        void addPost(String post,String author);

        Timeline getTimeline();
}
