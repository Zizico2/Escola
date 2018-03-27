package CloudSharing.User;

import CloudSharing.*;

public abstract class UserAbstract implements User {

    protected boolean premiumAccount;
    protected Iterator files;
    protected String email;
    protected int memoryStorage;

    protected UserAbstract(String email, boolean premiumAccount){
        files =  new Files();
        this.email = email;
        this.premiumAccount = premiumAccount;
    }

    @Override
    public String getID(){
        return email;
    }

    public int storage(){
        return memoryStorage;
    }

    public void upLoad(File file){
        files.add(file);
    }

    public Iterator Files(){
        return files;
    }

}
