package com.village.app.testHelpers;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TestHelper {

    @LocalServerPort
    private Integer port;

    public RequestSpecification request;

    public static JSONObject data;

    protected String testPath = "C:\\app\\src\\test\\java\\com\\village\\app\\";

    @BeforeEach
    public void createRestRequest() {
        request = RestAssured.given();
        RestAssured.baseURI = "http://localhost" + port;
    }

    public JSONObject getData() throws JSONException {
        if (data == null) {
            List<String> parts = Arrays.asList(this.getClass().toString().split("[.]"));
            String resourceName = testPath + "testHelpers\\data\\" +
                    parts.get(parts.size()-1) + ".json";
            Path path = Path.of(resourceName);
            InputStream is;
            JSONTokener tokener;
            data = new JSONObject();
            try {
                is = Files.newInputStream(path);
                tokener = new JSONTokener(is.toString());
                data.put("testData", new JSONObject(tokener));
            } catch (IOException e) {
                System.out.println("WARNING! " + resourceName + " not found");
            }
        }
        return data;
    }

    public Object getData(String key) throws JSONException {
        return getData().get(key);
    }

    public String testData(String... entries) throws JSONException {
        JSONObject result = (JSONObject) getData().get("testData");
        Object value = null;
        for (String entry : entries) {
            Object temp = result.get(entry);
            if (temp.getClass().toString().endsWith(".JSONObject")) {
                result = (JSONObject) result.get(entry);
            } else {
                value = result.get(entry);
            }
        }
        if (value != null) {
            return value.toString();
        }
        return result.toString();
    }

    public String testData (String entry) throws JSONException {
        return testData(new String[] {entry});
    }


    @AfterAll
    public static void cleaning () {
        data = null;
        // Cleaning here...
    }
}
