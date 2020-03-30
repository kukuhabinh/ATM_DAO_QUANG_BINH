package test1;

import java.util.Scanner;

public class AdminAction {
    public void mainAction() {
        boolean check = false;
        while (!check) {
            System.out.println("Moi ban chon chuc nang \n1: xem danh sach \n2: tao account moi \n3: kich hoat account \n4: disable account \n5:quan ly menh gia tien \n6: chon rut tien tra ra so to it nhat ");
            Scanner keyboard = new Scanner(System.in);
            Integer chooseAction = keyboard.nextInt();
            long chooseId = 0;
            AccountService accountService = new AccountService();
            ATMService atmService = new ATMService();
            switch (chooseAction) {
                case 1:
                    accountService.showListUser();
                    break;
                case 2:
                    accountService.addNewAccount();
                    break;
                case 3:
                    System.out.println("moi ban nhap id");
                    chooseId = keyboard.nextLong();
                    accountService.changeAccountStatus(1,chooseId);
                    break;
                case 4:
                    System.out.println("moi ban nhap id");
                    chooseId = keyboard.nextLong();
                    accountService.changeAccountStatus(0,chooseId);
                    break;
                case 5:
                    atmService.addMoneyToATM();
                    break;
                case 6:
                    atmService.manageBill();
                    break;
            }
            System.out.println("ban con muon thuc hien hanh dong khac hay khong \n 1: co \n 2: khong");
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
}
