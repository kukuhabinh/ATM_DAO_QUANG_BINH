package test1;

import java.util.List;
import java.util.Scanner;
import test1.Constant;


public class UserService {

    public User getLoginUser (List<User> users) {
        User chooseUser = new User();
        while (chooseUser.getId() == null ) {
            System.out.println("Moi ban nhap user name");
            Scanner keyboard = new Scanner(System.in);
            String userName = keyboard.nextLine();
            System.out.println("Moi ban nhap mat khau");
            String password = keyboard.nextLine();
            for (User user: users) {
                if (user.getUserName().equals(userName)  && user.getPassword().equals(password) )
                    chooseUser = user;
                return user;
            }
        }
        return null;
    }
    public void mainAction(User chooseUser,List<User> users) {
        boolean check = false;
        while (!check) {
            System.out.println("Moi ban chon hanh dong bang cach nhap so \n 1: rut tien \n 2:chuyen tien \n 3:xem so du ");
            Scanner keyboard = new Scanner(System.in);
            Integer chooseAction = keyboard.nextInt();
            switch (chooseAction) {
                case Constant.ACTION_GET_MONEY:
                    this.getMoney(chooseUser,users);
                    check = true;
                    break;
                case Constant.ACTION_TRANSFER_MONEY:
                    transferMoney(chooseUser,users);
                    check = true;
                    break;
                case Constant.ACTION_GET_AVAILABLE_MONEY:
                    getAvailableMoney(chooseUser);
                    check = true;
                    break;
                default:
                    System.out.println("Ban nhap khong hop le");
                    check = false;
            }
            System.out.println("ban con muon thuc hien tiep giao dich hay khong \n 1: co \n 2: khong");
            switch (keyboard.nextInt()) {
                case Constant.ACTION_AGAIN:
                    check = false;
                    break;
                case Constant.ACTION_STOP:
                    check = true;
                    break;
            }
        }

    }
    public void getMoney(User chooseUser,List<User> users) {
        boolean check = false;
        while (!check) {
            System.out.println("moi ban nhap so tien");
            Scanner keyboard = new Scanner(System.in);
            Long money = Long.parseLong(keyboard.nextLine());
            if (money > chooseUser.getMoney()) {
                System.out.println("tai khoan cua ban khong du");
                check = false;
            }
            else {

                FileUtil fileUtil = new FileUtil();
                fileUtil.writeFile(chooseUser, users, null, money);
                System.out.println("giao dich thanh cong");
                check = true;
            }

        }
    }
    public void transferMoney(User chooseUser,List<User> users) {
        boolean check = false;
        while (!check) {
            System.out.println("moi ban nhap ten tai khoan");
            Scanner keyboard = new Scanner(System.in);
            String tenTaiKhoan = keyboard.nextLine();
            for (User user: users) {
                if (user.getUserName().equals(tenTaiKhoan)) {

                    boolean checkMoney = false;
                    while (!checkMoney) {
                        System.out.println("moi ban nhap so tien");

                        Long money = Long.parseLong(keyboard.nextLine());
                        if (money > chooseUser.getMoney()) {
                            System.out.println("tai khoan cua ban khong du");
                            checkMoney = false;
                        }
                        else {

                            FileUtil fileUtil = new FileUtil();
                            fileUtil.writeFile(chooseUser, users, tenTaiKhoan, money);
                            System.out.println("giao dich thanh cong");
                            checkMoney = true;
                        }

                    }

                    check = true;
                    return;
                }
            }
            System.out.println("tai khoan ban nhap khong ton tai");
            check = false;
        }
    }
    public void getAvailableMoney(User chooseUser) {
        System.out.println("tai khoan cua ban con " + chooseUser.getMoney());
    }
}
