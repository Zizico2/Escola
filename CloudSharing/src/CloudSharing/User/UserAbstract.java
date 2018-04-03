package CloudSharing.User;

import CloudSharing.*;

public abstract class UserAbstract implements User {

     boolean accountType;
     Iterator<File> files;
     String email;
     int memoryStorage;

     UserAbstract(String email, boolean accountType) {
        files = new IteratorClass<>();
        this.email = email;
        this.accountType = accountType;
    }

    @Override
    public  boolean isPremium(){
         return accountType;
    }

    @Override
    public String getID(){
        return email;
    }

    @Override
    public int getStorage(){
        return memoryStorage;
    }


    public abstract void upload(File file);

    @Override
    public Iterator getFiles(){
        return files;
    }

}
