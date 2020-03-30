package test1;

import java.util.List;
import java.util.Scanner;

import static test1.Main.users;

public class AccountService {
    public void showListUser() {

        for (User user: users) {
            System.out.println("UserName: "+user.getUserName()+"\nStatus:"+user.getStatus());
        }
    }
    public static void addNewAccount() {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("moi ban nhap UserName");
        String newUserName = keyboard.nextLine();
        System.out.println("moi ban nhap password");
        String newPassword = keyboard.nextLine();
        User newUser = new User();
        newUser.setId((long) users.size() + 1);
        newUser.setUserName(newUserName);
        newUser.setPassword(newPassword);
        newUser.setMoney((long)0);
        newUser.setRole("user");
        newUser.setStatus(1);
        users.add(newUser);
        FileUtil fileUtil = new FileUtil();
        fileUtil.writeFile(null,users,null,null);
    }
    public static void changeAccountStatus(int status,Long userId) {
        for (User user:users) {
            if (user.getId().equals(userId)) {
                user.setStatus(status);
            }
        }
        FileUtil fileUtil = new FileUtil();
        fileUtil.writeFile(null,users,null,null);
    }
}
