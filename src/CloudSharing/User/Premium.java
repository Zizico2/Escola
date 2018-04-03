package CloudSharing.User;


import CloudSharing.*;

public class Premium extends UserAbstract {

    private static final int DEFAULT_STORAGE = 1024*5;

    public Premium(String email) {
        super(email,PREMIUM);
        memoryStorage = DEFAULT_STORAGE;
    }


    @Override
    public void upload(File file) {
        if (file.getOwner() == email){
            memoryStorage -= file.getSize();
            files.add(file);
        }
        else
            files.add(file);
    }
}
