package app;

import java.util.Scanner;

import static app.TestHelper.*;

public abstract class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("1. Случайный год: " + getRandomYear());
        System.out.println("2. Случайное число Long: " + getRandomNumber());
        System.out.println("3. Генерация случайной строки: " + getRandomString());
        System.out.println("4. Hash-map из файла: " + getReadHashMap());
        System.out.println("5. Преобразование формата даты. Введите дату в формате yyyy.mm.dd.");
        Scanner scanner = new Scanner(System.in);
        String oldDateString = scanner.next();
        System.out.println(getDateFormat(oldDateString));
        System.out.println("6. Преобразование строки в число Double. Введите число Double.");
        Scanner scanner2 = new Scanner(System.in);
        String str = scanner2.next();
        System.out.println(getStringToDouble(str));
    }
}
