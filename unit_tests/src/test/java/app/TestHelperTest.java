package app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.text.ParseException;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

class TestHelperTest {

    @Test
    void getRandomYear() {
        int random = TestHelper.getRandomYear();
        assertTrue(random >= 1970 && random <= 2021);
    }

    @Test
    void getRandomNumber() {
        long longNumber = TestHelper.getRandomNumber();
        assertTrue(longNumber >= Long.MIN_VALUE && longNumber <= Long.MAX_VALUE);
    }

    @Test
    void getRandomString() {
        String str = TestHelper.getRandomString();
        assertTrue(str.matches("[A-Z][a-z]*\\s[A-Z][a-z]*\\s[A-Z][a-z]*"));
    }

    @Test
    void getReadHashMap() throws Exception {
        HashMap<Integer, String> newHashMap = TestHelper.getReadHashMap();
        String value = newHashMap.values().toString();
        assertEquals("[John Miller, Edward Gibson]", value);
    }

    @ParameterizedTest
    @CsvSource({"2014.09.10, 10.09.2014",
            "2000-06-10, Неверный формат. Введите дату в формате yyyy.mm.dd.",
            "date, Неверный формат. Введите дату в формате yyyy.mm.dd."})
    void getDateFormat(String test, String result) throws ParseException {
        String oldDateString = new String();
        oldDateString = test;
        String str = TestHelper.getDateFormat(oldDateString);
        assert(str.equals(result));
    }

    @ParameterizedTest
    @CsvSource({"56,56.0", "-15.6,-15.6", "day,Infinity"})
    void getStringToDouble(String test, Double result) {
        String str = new String();
        str = test;
        Double st = TestHelper.getStringToDouble(str);
        assert(st.equals(result));
    }
}