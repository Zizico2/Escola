import java.util.Scanner;
import CloudSharing.*;

public class Main {


    private static final String PREMIUM = "Premium";
    private static final String BASIC = "Basic";

    private enum Message{

        ACCOUNT_ADDED ("Account was added."),
        INVALID_ACCOUNT ("Account already exists."),
        FILE_UPLOADED ("File uploaded into account."),
        ACCOUNT_NOT_EXIST ("Account does not exist."),
        FILE_ALREADY_EXISTS ("File already exists in the account."),
        TOO_BIG ("File size exceeds account capacity."),
        FILE_SHARED ("File was shared."),
        FILE_NOT_EXIST ("File does not exist."),
        UNAUTHORIZED_SHARING ("Account does not allow file sharing."),
        SHARING_ALREADY_EXISTS ("File already shared.");





        private final String msg;
        Message(String msg){
            this.msg = msg;
        }
    }
    private enum Command{
        ADD ("ADD"),
        UPLOAD ("UPLOAD"),
        SHARE  ("SHARE"),
        MINSPACE  ("MINSPACE"),
        LISTFILES  ("LISTFILES"),
        LISTALL  ("LISTALL"),
        EXIT  ("EXIT"),
        UNKNOWN  ("Unknown command!");

        private final String cmd;
        Command(String cmd){
            this.cmd = cmd;
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Cloud C = new CloudClass();
        executeCommand(input,C);

    }

    private static void executeCommand(Scanner in, Cloud Cloud ){
        String cmd = "";

        while(!cmd.equals(Command.EXIT.cmd)){
            cmd = in.next().toUpperCase();
            try {
                Command command = Command.valueOf(cmd);
                switch(command){
                    case ADD:
                        add(in, Cloud);
                        break;

                    case UPLOAD:
                        upload(in, Cloud);
                        break;

                    case SHARE:
                        share(in, Cloud);
                        break;

                    case MINSPACE:
                        break;

                    case LISTFILES:
                        break;

                    case LISTALL:
                        break;

                    case EXIT:
                        break;

                    case UNKNOWN:
                        break;
                    default:
                }
            } catch(IllegalArgumentException e){
                System.out.println(Command.UNKNOWN.cmd);
            }
        }
    }

    private static void add(Scanner in, Cloud cloud){
        String email = in.next().trim();
        String type = in.nextLine().trim();
        boolean premium = type.equals(PREMIUM.toLowerCase());

           if(cloud.addUser(email,premium))
               System.out.println(Message.ACCOUNT_ADDED.msg);
           else
               System.out.println(Message.INVALID_ACCOUNT.msg);
    }

    private static void upload(Scanner in, Cloud cloud){
        String email = in.next().trim();
        String fileName = in.next().trim();
        int fileSize = in.nextInt();
        int result = cloud.upload(email,fileName,fileSize);


        switch(result){

            case Cloud.SUCCESS:
                System.out.println(Message.FILE_UPLOADED.msg);
                break;

            case Cloud.ACCOUNT_NOT_EXIST:
                System.out.println(Message.ACCOUNT_NOT_EXIST.msg);
                break;

            case Cloud.FILE_ALREADY_EXISTS:
                System.out.println(Message.FILE_ALREADY_EXISTS.msg);
                break;

            case Cloud.TOO_BIG:
                System.out.println(Message.TOO_BIG.msg);
                break;

            default:System.out.println("ERROR");
        }
    }

    private static void share(Scanner in, Cloud cloud){
            String emailSender = in.next().trim();
            String emailReceiver = in.next().trim();
            String fileName = in.nextLine().trim();
            int result = cloud.share(emailSender,emailReceiver,fileName);

            switch(result){

                case Cloud.SUCCESS:
                    System.out.println(Message.FILE_SHARED.msg);
                    break;

                case Cloud.ACCOUNT_NOT_EXIST:
                    System.out.println(Message.ACCOUNT_NOT_EXIST.msg);
                    break;

                case Cloud.FILE_NOT_EXIST:
                    System.out.println(Message.FILE_NOT_EXIST.msg);
                    break;

                case Cloud.UNAUTHORIZED_SHARING:
                    System.out.println(Message.UNAUTHORIZED_SHARING.msg);
                    break;

                case Cloud.SHARING_ALREADY_EXISTS:
                    System.out.println(Message.SHARING_ALREADY_EXISTS.msg);
                    break;

                case Cloud.TOO_BIG:
                    System.out.println(Message.TOO_BIG.msg);
                    break;

                default:
                    System.out.println("ERROR");
            }
    }
}