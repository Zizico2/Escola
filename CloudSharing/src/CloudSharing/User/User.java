package CloudSharing.User;

import CloudSharing.*;

public interface User {

    boolean PREMIUM = true;
    boolean BASIC = false;

    /**
     * Retorna o email do utilizador.
     *
     * @return - String email.
     */
    String getID();

    /**
     * Retorna o espaco livre do utilizador.
     *
     * @return - int memoryStorage.
     */
    int getStorage();

    /**
     * Envia o ficheiro para armazenar
     *
     * @param file - ficheiro a armazenar.
     */
    void upload(File file);

    /**
     * Retorna os ficheiros do utilizador.
     *
     * @return Iterator<File> files.
     */
    Iterator<File> getFiles();

    /**
     * Retorna se a conta e premium ou basic
     *
     * @return - true se a conta for premium,
     *           false se a conta for basic.
     */
    boolean isPremium();
}
