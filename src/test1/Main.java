package test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<User> users = new ArrayList<>();
    public static User chooseUser = new User();


    public static void main(String[] args) {
        FileUtil fileUtil = new FileUtil();

        users = fileUtil.readFile();
        UserAction userAction = new UserAction();
        chooseUser = userAction.getLoginUser(users);
        if (chooseUser.getRole().equals("admin")) {
            System.out.println("Chon 1 de thuc hien admin, chon 2 de thuc hien hoat dong");
            Scanner keyboard = new Scanner(System.in);
            Integer chooseAction = keyboard.nextInt();
            switch (chooseAction) {
                case 1:
                    AdminAction adminAction = new AdminAction();
                    adminAction.mainAction();
                    break;
                case 2:
                    userAction.mainAction(chooseUser,users);
                    break;
            }
        }
        else {
            userAction.mainAction(chooseUser,users);
        }

//        fileUtil.writeFile();
    }
}
