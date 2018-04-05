package CloudSharing;

import CloudSharing.User.*;

public class CloudClass implements Cloud {

    private Iterator<User> users;

    public CloudClass(){
        users = new IteratorClass<>();
    }

    @Override
    public boolean addUser(String email, boolean premiumAccount) {
        User user;
        if(premiumAccount == User.PREMIUM)
            user = new Premium(email);
        else
            user =  new Basic(email);
        if (!hasUser(email)) {
            users.add(user);
            return true;
        }
        return false;
    }

    @Override
    public int upload(String email, String fileName, int mb) {
            if(!hasUser(email))
                return ACCOUNT_NOT_EXIST;

            else if(hasFile(email,fileName))
                return FILE_ALREADY_EXISTS;

            else if(!enoughSize(email,mb))
                return TOO_BIG;

            getUser(email).upload(new FileClass(email,fileName,mb));

        return SUCCESS;
    }

    @Override
    public int share(String emailOwner, String emailReceiver, String fileName) {
            if(!hasUser(emailOwner) || !hasUser(emailReceiver))
                return ACCOUNT_NOT_EXIST;

            else if(!hasFile(emailOwner,fileName))
                return FILE_NOT_EXIST;

            else if(!getUser(emailOwner).isPremium())
                return UNAUTHORIZED_SHARING;

            else if(isSharingSameFile(emailOwner,emailReceiver,fileName))
                return SHARING_ALREADY_EXISTS;

            else if(!getUser(emailReceiver).isPremium() && getFile(emailOwner,fileName).getSize()/2 > getUser(emailReceiver).getStorage())
                return TOO_BIG;


            File file = getFile(emailOwner,fileName);
            getUser(emailReceiver).upload(file);

        return SUCCESS;
    }

    @Override
    public User minSpace() {
       users.initialize();
       User user;
       User minUser = null;
       int min = Integer.MAX_VALUE;

       while(users.hasNext()){
           user = users.next();
           if(user.getStorage() < min){
               min = user.getStorage();
               minUser = user;
           }
       }
        return minUser;
    }

    @Override
    public Iterator<File> listFiles(String email) {
      Iterator<File> files = null;
       if (hasUser(email))
           files = getUser(email).getFiles();

           return files;
    }

    @Override
    public Iterator<User> listAll() {
        return users;
    }

    private boolean enoughSize(String email, int mb){
        return getUser(email).getStorage() >= mb;
    }

    private boolean hasUser(String email) {
        users.initialize();
        User u;

        while(users.hasNext()){
              u =  users.next();
            if(u.getID().equals((email)))
                return true;
        }

        return false;
    }

    private User getUser(String email){
        users.initialize();
        User user = null;
        while(users.hasNext()){
            user = users.next();
            if(user.getID().equals(email))
                return user;
        }
        return user;
    }

    @SuppressWarnings("unchecked")
    private boolean hasFile(String email, String fileName){
        User jonhdoe =  getUser(email);
        Iterator<File> files = jonhdoe.getFiles();
        files.initialize();

        while(files.hasNext()){
            if(files.next().getName().equals(fileName)) {

                return true;
            }
        }
        return false;
    }
    @SuppressWarnings("unchecked")
    private File getFile(String email, String filename){
        User jonhdoe =  getUser(email);
        Iterator<File> files = jonhdoe.getFiles();
        files.initialize();
        boolean found = false;
        File file = null;
        while(files.hasNext() && !found) {
            file = files.next();
            if (file.getName().equals(filename))
                found  = true;
        }

        return file;
    }

    private boolean isSharingSameFile(String emailOwner,String emailReceiver, String fileName){
        if(hasFile(emailReceiver,fileName))
                return getFile(emailReceiver, fileName).getOwner().equals(emailOwner);
        return false;
    }
}
