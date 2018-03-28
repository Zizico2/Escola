package CloudSharing.User;

import CloudSharing.*;

public abstract class UserAbstract implements User {

    protected boolean accountType;
    protected Iterator files;
    protected String email;
    protected int memoryStorage;

    protected UserAbstract(String email, boolean accountType) {
        files = new Files();
        this.email = email;
        this.accountType = accountType;
    }
    
    @Override
    public String getID(){
        return email;
    }

    @Override
    public int getStorage(){
        return memoryStorage;
    }

    @Override
    public boolean upload(File file){
        if(!checkDuplicateFiles(file)) {
            files.add(file);
            return true;
        }
        return false;
    }

    @Override
    public Iterator getFiles(){
        return files;
    }

    private boolean checkDuplicateFiles(File file) {
        files.initializeIterator();
        File f;
        while(files.hasNext()){
            f = (FileClass) files.next();
            if(f.getName().equals(file.getName()))
                return true;
        }
        return false;
    }

}
