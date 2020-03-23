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
        UserService userService = new UserService();
        chooseUser = userService.getLoginUser(users);
        userService.mainAction(chooseUser,users);
//        fileUtil.writeFile();
    }
}
