package CloudSharing.User;

import CloudSharing.*;

public interface User {


    String getID();

    int storage();

    void upLoad(File file);

    Iterator Files();
}
