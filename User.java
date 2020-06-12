package user.action;

import java.util.Scanner;

public class User extends Person {
    //имя пользователя
    private static String userName;
    //Пол пользователя
    private static String userSex;
    //Возраст пользователя
    private static int userAge;
    //Конструктор без аргументов
    Book book = new Book();
    public User(){

    }
    //Параметризованный конструктор
    public User(String userName,String userSex,int userAge){

    }

    //Одолжить книги
    public void borrowBook(String[][] book1){
        System.out.println("Пожалуйста, введите название книги, которую вы хотите взять:");
        String m;
        int n = -1;
        m = input.next();
        for (int i = 0; i < book1.length; i++) {
            if (book1[i][1].equals(m)) {
                n = i;
                break;
            }
        }
        int p = Integer.parseInt(Book.book1[n][3]);
        if (p == 0) {
            System.out.println("Извините, это было заимствовано ~");
        } else {
            Book.book1[n][3] = (p - 1) + "";
            System.out.println("Удачного заимствования!");
        }
    }

    /**
     * Вернуть книги
     * @param book1
     */
    public void returnBook(String[][] book1){
        int BookId1,BookNum1;
        String BookName1,Author1;

        System.out.println("~~~~~~ Начните возвращать книги ~~~~~~");
        System.out.println("Пожалуйста, введите название возвращенной книги:");
        BookName1 = input.next();
        for (int i = 0; i < Book.count; i++) {
            if (book1[i][1].equals(BookName1)) {
                int p = Integer.parseInt(book1[i][3]);
                book1[i][3] = (p+1) + "";
                break;
            }
        }
        System.out.println("~~~~~~ Успешное возвращение ~~~~~~");
    }

    /**
     * Пользовательская функция работы
     */
    public void start(){
        Scanner input = new Scanner(System.in);

        boolean flag = true;
        int number;
        while(flag) {
            System.out.println("---------------------------------------------------");
            System.out.print("Пожалуйста, выберите: 1: запросить книги 2: одолжить книги 3: вернуть книги 4: выйти\n\n");
            number = input.nextInt();
            switch (number) {
                case 1:
                    selectBook(Book.book1);
                    break;
                case 2:
                    borrowBook(Book.book1);
                    break;
                case 3:
                    returnBook(Book.book1);
                    break;
                case 4:
                    System.out.println("~~~~~~ Вы вышли из системы ~~~~~~");
                    flag = false;
                    break;
                default:
                    System.out.println("ошибка ввода");
                    break;
            }
        }
    }
}

