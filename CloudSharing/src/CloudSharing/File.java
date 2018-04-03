package CloudSharing;

public interface File {

    /**
     * Retorna a dimensao do ficheiro.
     *
     * @return -  Dimensao do ficheiro.
     */
    int getSize();

    /**
     * Retorna o nome do dono do ficheiro.
     *
     * @return - Nome do dono do ficheiro
     */
     String getOwner();

    /**
     * Retorna o nome do ficheiro.
     *
     * @return - Objeto -  String nome do ficheiro.
     */
     String getName();

}
