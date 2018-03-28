package CloudSharing.User;

import CloudSharing.*;

public class Premium extends UserAbstract {

    private static final int DEFAULT_STORAGE = 1024*5;
    public Premium(String email) {
        super(email,PREMIUM);
        memoryStorage = DEFAULT_STORAGE;
    }
}
