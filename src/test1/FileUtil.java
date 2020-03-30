package test1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtil {
    public static Constant constant;
    private static final File file = new File(constant.FILE_PATH);

    public List<User> readFile() {
        List<User> users = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String stringData = scanner.nextLine();
                String[] data = stringData.split(" ");
                User userModel = new User();
                userModel.setId(Long.parseLong(data[0]));
                userModel.setUserName(data[1]);
                userModel.setPassword(data[2]);
                userModel.setMoney(Long.parseLong(data[3]));
                userModel.setRole(data[4]);
                userModel.setStatus(Integer.valueOf(data[5]));
                users.add(userModel);
//                System.out.println(userModel.getMonney());
            }
            return users;
        }
        catch (FileNotFoundException ex)
        {
            // insert code to run when exception occurs
            System.out.println(ex);
        }

        return null;
    }
    public void writeFile(User chooseUser, List<User> users, String tenTaiKhoan, Long money) {
        FileWriter writer = null;
        String dbText = "";
        for (User user: users) {
            if (chooseUser != null) {
                if (user.getId().equals(chooseUser.getId())) {
                    user.setMoney(chooseUser.getMoney() - money);
                }
            }
            if (tenTaiKhoan != null && user.getUserName().equals(tenTaiKhoan)) {
                user.setMoney(user.getMoney() + money);
            }
            dbText += user.getId() + " " + user.getUserName() + " " + user.getPassword() + " " + user.getMoney() + " "+user.getRole()+ " "+ user.getStatus()+ " \n";
        }
        try {
            writer = new FileWriter(file);
            writer.write(dbText);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
