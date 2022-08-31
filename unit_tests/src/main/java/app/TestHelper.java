package app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public abstract class TestHelper {
    public static int getRandomYear() {
        return randomYear();
    }

    private static int randomYear() {
        int minYear = 1970;
        int maxYear = 2021;
        int diff = maxYear - minYear;
        Random random = new Random();
        int year = random.nextInt(diff + 1);
        year += minYear;
        return year;
    }

    public static long getRandomNumber() {
        return randomNumber();
    }

    private static long randomNumber() {
        Random random = new Random();
        long number = random.nextLong();
        return number;
    }

    public static String getRandomString() {
        return randomString();
    }

    private static String randomString() {
        Random random = new Random();
        int leftLimit = 97;
        int rightLimit = 122;
        ArrayList<String> text = new ArrayList<>();
        for (int word = 1; word < 4; word++) {
            int minStrLength = 5;
            int maxStrLength = 10;
            int diff = maxStrLength - minStrLength;
            int targetStrLength = random.nextInt(diff + 1);
            targetStrLength += minStrLength;
            StringBuilder buffer = new StringBuilder(targetStrLength);
            for (int i = 0; i < targetStrLength; i++) {
                int randomLimitedInt = leftLimit + (int)
                        (random.nextFloat() * (rightLimit - leftLimit + 1));
                buffer.append((char) randomLimitedInt);
            }
            String generatedString = buffer.substring(0, 1).toUpperCase() + buffer.substring(1);
            text.add(generatedString);
        }
        String newString = text.get(0).toString() + " " + text.get(1).toString() + " " + text.get(2).toString();
        return newString;
    }

    public static HashMap<Integer, String> getReadHashMap() throws Exception {
        return readHashMap();
    }

    private static HashMap<Integer, String> readHashMap() throws Exception {
        HashMap<Integer, String> map = new HashMap<>();
        Path path = Path.of("C:/Projects/khakimullina_attestation1/src/main/resources/text.txt");
        BufferedReader br = new BufferedReader(new FileReader(String.valueOf(path)));
        String sCurrentLine;
        while ((sCurrentLine = br.readLine()) != null) {
            String[] string = sCurrentLine.split(" :: ");
            Integer key = Integer.valueOf(string[0]);
            String value = string[1];
            map.put(key, value);
        }
        return map;
    }

    public static String getDateFormat(String oldDateString) throws ParseException {
        return dateFormat(oldDateString);
    }

    private static String dateFormat(String oldDateString) throws ParseException {
        String result;
        if (oldDateString.matches("[0-9][0-9][0-9][0-9]\\.[0-9][0-9]\\.[0-9][0-9]")) {
            SimpleDateFormat oldDateFormat = new SimpleDateFormat("yyyy.MM.dd");
            SimpleDateFormat newDateFormat = new SimpleDateFormat("dd.MM.yyyy");
            Date date = oldDateFormat.parse(oldDateString);
            result = newDateFormat.format(date);
        } else {
            result = "Неверный формат. Введите дату в формате yyyy.mm.dd.";
        }
        return result;
    }

    public static Double getStringToDouble(String str) {
        return stringToDouble(str);
    }

    private static Double stringToDouble(String str) {

        try {
            Double d = Double.parseDouble(str);
            return d;
        } catch (NumberFormatException e) {
            Double d = Double.POSITIVE_INFINITY;
            return d;
        }
    }
}