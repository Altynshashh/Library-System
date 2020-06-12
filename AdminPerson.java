package user.action;

import user.impl.Operate;

import java.util.Scanner;

public class AdminPerson extends Person implements Operate,Comparable<Book> {
    static AdminPerson adminPerson = new AdminPerson();
    //имя пользователя
    private static String adminName = "Татьяна";
    //Пол пользователя
    private static String adminSex = "женщина";
    //Возраст пользователя
    private static int adminAge = 58;

    Scanner input = new Scanner(System.in);

    Book book = new Book();


    public static String getAdminName() {
        return adminName;
    }

    public static String getAdminSex() {
        return adminSex;
    }

    public static int getAdminAge() {
        return adminAge;
    }

    //Конструктор без аргументов
    private AdminPerson(){

    }

    public static AdminPerson getInstance(){
        return adminPerson;
    };

    @Override
    public void arrangeBooks(String[][] book1) {
        String[] temp;
        for(int i = 0;i < Book.count-1;i++){
            for(int j=0;j < Book.count-1-i;j++) {
                if (book1[j][0].compareTo(book1[j + 1][0]) > 0) {
                    temp = book1[j];
                    book1[j] = book1[j + 1];
                    book1[j + 1] = temp;
                }
            }
        }
        System.out.println("Законченный！");
    }


    @Override
    public void printBooksList(String[][] book) {
        if(Book.count == 0){
            System.out.println("Складские книги пусты！");
        }else {
            System.out.println("Вся информация о книге выглядит следующим образом：");
            for (int i = 0; i < Book.count; i++) {
                System.out.print("Номер книги：" + book[i][0] + "\t\t");
                System.out.print("Название книги：" + book[i][1] + "\t\t");
                System.out.print("Название книги и автор книги：" + book[i][2] + "\t\t");
                System.out.print("Количество книг：" + book[i][3] + "\n");
            }
        }
    }


    @Override
    public void alter_s(String[][] book1) {
        String m;
        int o;
        int n = -1;
        System.out.println("Пожалуйста, введите название книги, которую вы хотите изменить：");
        m = input.next();
        for(int  i = 0;i < Book.count;i++){
            if(book1[i][1].equals(m)){
                n = i;
                break;
            }
        }
        System.out.println("Пожалуйста, выберите контент, который вы хотите изменить: 1. Номер книги 2. Название книги 3. Автор книги 4. Количество книг");
        o = input.nextInt();
        System.out.println("Пожалуйста, введите то, что вы хотите изменить：");
        book1[n][o-1] = input.next()+"";
        System.out.println("~~~~~~Информация о книге была изменена~~~~~~");
    }


    public void start(){
        boolean flag = true;
        int number;
        while(flag){
            System.out.println("---------------------------------------------------------------------------");
            System.out.print("Пожалуйста, выберите: 1: добавить книги 2: запросить книги 3: изменить книги 4: удалить книги 5: напечатать список книг 6: упорядочить книги 7: выйти\n\n");
            number = input.nextInt();
            switch (number) {
                case 1:
                    book.add(book);
                    break;
                case 2:
                    selectBook(Book.book1);
                    break;
                case 3:
                    alter_s(Book.book1);
                    break;
                case 4:
                    book.delete();
                    break;
                case 5:
                    printBooksList(Book.book1);
                    break;
                case 6:
                    arrangeBooks(Book.book1);
                    break;
                case 7:
                    System.out.println("~~~~~~Вы вышли из системы~~~~~~");
                    flag = false;
                    break;
                default :
                    System.out.println("ошибка ввода");
                    break;
            }
        }
    }

    @Override
    public int compareTo(Book o) {
        return book.getBookId()-o.getBookId();
    }
}
