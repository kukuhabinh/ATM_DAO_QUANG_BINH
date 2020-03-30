package test1;

import java.util.Scanner;

public class ATMService {
    public void addMoneyToATM() {
        System.out.println("nhap so luong tien");
        Scanner keyboard = new Scanner(System.in);
        Long money = keyboard.nextLong();
        System.out.println("ban da thay them "+money+" vao ATM");
    }
    public void manageBill() {
        System.out.println("ban da chon chuc nang tra it to tien nhat");
    }
}
