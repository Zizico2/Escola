package CloudSharing;

public class CloudClass implements Cloud {

    Iterator users;

    public CloudClass(){
        users = new Users();
    }

    @Override
    public boolean addUser(String email, int type) {
            return users.addUser(email,type);
    }

    @Override
    public int upload(String email, String fileName, int mb) {
        return 0;
    }

    @Override
    public int share(String emailOwner, String emailReceiver, String fileName) {
        return 0;
    }

    @Override
    public User minSpace() {
        return null;
    }

    @Override
    public Iterator listFiles(String email) {
        return null;
    }

    @Override
    public Iterator listAll() {
        return null;
    }
}
