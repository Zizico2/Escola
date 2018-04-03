package CloudSharing;

public class FileClass implements File {
    private int size;
    private String owner;
    private String name;

    FileClass(String name, String owner, int size){
        this.name = name;
        this.owner = owner;
        this.size = size;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getOwner() {
        return owner;
    }

    @Override
    public String getName() {
        return name;
    }
}
