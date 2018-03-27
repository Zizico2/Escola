package CloudSharing;

public interface Cloud {

    int SUCCESS = 0;
    int ACCOUNT_NOT_EXIST = 1;
    int FILE_ALREADY_EXISTS = 2,FILE_NOT_EXIST = 2;
    int TOO_BIG = 3;
    int SHARING_ALREADY_EXISTS = 4;
    int SHARING_UNAUTHORIZED = 5;

    /**
     * Adiciona uma conta.
     *
     * @param email - Identificador da conta.
     * @param type - Tipo da conta(User.BASIC ou User.PREMIUM).
     * @return - true se adicionou com successo;
     *           false se existia uma conta com o mesmo @param email.
     */
    boolean addUser(String email, int type);

    /**
     * Adiciona um ficheiro.
     *
     * @param email - Identificador da conta.
     * @param fileName - Identificador do ficheiro.
     * @param mb - Dimensao do ficheiro.
     * @return - 0 se ficheiro adicionado com sucesso;
     *           1 se a conta nao existir;
     *           2 se o ficheiro ja existir na conta.;
     *           3 se a dimensao do ficheiro (@param mb) exceder a capacidade da conta.
     */
    int upload(String email, String fileName, int mb);

    /**
     * Partilha um ficheiro.
     *
     * @param emailOwner - Identificador da conta a que o ficheiro pertence.
     * @param emailReceiver - Identificador da conta a adicionar a partilha do ficheiro.
     * @param fileName - Identificador do ficheiro.
     * @return - 0 se partilhar com sucesso;
     *           1 se um das contas nao existir;
     *           2 se o ficheiro nao existir;
     *           3 se a dimensao do ficheiro exceder a capacidade da conta.
     *           4 se a partilha ja existir;
     *           5 se a conta nao permitir partilhar ficheiros;
     */
    int share(String emailOwner, String emailReceiver, String fileName);

    /**
     * Retorna a conta que tem menos espaco livre.
     *
     * @return - Objeto: Abstract class User.
     */
    User minSpace();

    /**
     * Retorna todos os ficheiros de uma conta.
     *
     * @param email - Identificador da conta.
     * @return - Objeto: Interface Iterator, Class Files.
     */
    Iterator listFiles(String email);

    /**
     * Retorna todas as contas.
     *
     * @return - Objeto: Interface Iterator, Class Users.
     */
    Iterator listAll();
}
