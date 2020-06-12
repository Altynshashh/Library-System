package user.action;

import java.util.Scanner;

abstract class Person {
    protected static String name;
    protected static String sex;
    protected static int age;
    Scanner input = new Scanner(System.in);

    public static String getName() {
        return name;
    }

    public static String getSex() {
        return sex;
    }

    public static int getAge() {
        return age;
    }

    public static void setName(String name) {
        Person.name = name;
    }

    public static void setSex(String sex) {
        Person.sex = sex;
    }

    public static void setAge(int age) {
        Person.age = age;
    }

    /**
     * Найти информацию о книге
     * @ param book
    */
    public void selectBook(String[][] book) {
        String m;
        System.out.println("Пожалуйста, введите название книги, которую вы ищете:");
        m = input.next();
        if (Book.count == 0) {
            System.out.println("Извините, такой книги нет!");
        } else {
            boolean flag = true;
            while(flag){
                for (int i = 0; i < book.length; i++) {
                    if (book[i][1].equals(m)) {
                        System.out.println("Номер книги:" + book[i][0]);
                        System.out.println("Название книги:" + book[i][1]);
                        System.out.println("Автор книги:" + book[i][2]);
                        System.out.println("Количество книг:" + book[i][3]);
                        System.out.println("~~~~~~ Поиск информации о книге завершен ~~~~~~");
                        flag = false;
                        break;
                    }else{
                        System.out.println("Извините, такой книги нет!");
                        flag = false;
                        break;
                    }
                }
            }
        }
    }
}
