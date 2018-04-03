package CloudSharing.User;

import CloudSharing.*;

public interface User {

    boolean PREMIUM = true;
    boolean BASIC = false;


    String getID();

    int getStorage();

    void upload(File file);

    Iterator getFiles();

    boolean isPremium();
}
