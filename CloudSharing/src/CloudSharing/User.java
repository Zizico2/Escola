package CloudSharing;

public abstract class User {
    Iterator files;
    String name;

    public User(){
        files =  new Files();
    }

}
