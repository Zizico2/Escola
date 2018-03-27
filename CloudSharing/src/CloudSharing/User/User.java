package CloudSharing.User;

import CloudSharing.Files;
import CloudSharing.Iterator;

public abstract class User {

    protected boolean premiumAccount;
    protected Iterator files;
    protected String email;

    public User(String email, boolean premiumAccount){
        files =  new Files();
        this.email = email;
        this.premiumAccount = premiumAccount;
    }



}
