package CloudSharing.User;

import CloudSharing.*;

public class Basic extends UserAbstract {

    private static final int DEFAULT_STORAGE = 1024*2;
    public Basic(String name){
        super(name,false);
        memoryStorage = DEFAULT_STORAGE;
    }
}
