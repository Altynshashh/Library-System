package user.action;

import java.util.Scanner;

public class Test {

    public void choose() {
        while (true) {
            System.out.println("------------ Теория графов Технология управления книгами ------------\n");
            System.out.print("Пожалуйста, войдите в систему: 1: обычный пользователь 2: администраторский вход\n\n");
            Scanner in = new Scanner(System.in);

            int choose = in.nextInt();
            Scanner scan = new Scanner(System.in);
            User user = null;
            AdminPerson adminPerson = AdminPerson.getInstance();
            switch (choose) {
                case 1:
                    System.out.print("Пожалуйста, введите ваше имя \n");
                    String userName = scan.next();
                    System.out.print("Пожалуйста, введите: пол\n");
                    String userSex = scan.next();
                    System.out.print("Пожалуйста, введите: возраст\n");
                    int userAge = scan.nextInt();
                    user = new User(userName, userSex, userAge);
                    System.out.println("Текущий пользователь:" + userName + " " + userSex + " " + userAge);
                    user.start();
                    break;
                case 2:
                    System.out.println("Текущий администратор:" + adminPerson.getAdminName() + " " + adminPerson.getAdminSex() + " " + adminPerson.getAdminAge());

                    adminPerson.start();
                    break;
            }
        }
    }
    public static void main(String[] args){
        Test test = new Test();
        test.choose();
    }

}
