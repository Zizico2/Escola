package CloudSharing.User;


import CloudSharing.*;

public class Basic extends UserAbstract {

    private static final int DEFAULT_STORAGE = 1024*2;

    public Basic(String name){
        super(name,BASIC);
        memoryStorage = DEFAULT_STORAGE;
    }

    @Override
    public void upload(File file) {
        if(file.getOwner().equals(email)){
            memoryStorage -= file.getSize();
            files.add(file);
        }
        else {
            memoryStorage -= file.getSize()/2;
            files.add(file);
        }

    }
}
