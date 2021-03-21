package TestCase;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
    //Bu methodda Demo2_POST_Request vb için random değer üretme işini yapacağız. Her seferinde yeni value'ler girmemen için

    public static String getFirstName() {
        String generatedString = RandomStringUtils.randomAlphabetic(1);
        return ("Semih"+generatedString);
    }

    public static String getJob() {
        String generatedString = RandomStringUtils.randomAlphabetic(1);
        return ("Engineer"+generatedString);
    }

    public static String getLastName() {
        String generatedString = RandomStringUtils.randomAlphabetic(1);
        return ("Saydam"+generatedString);
    }

    public static String getUserName() {
        String generatedString = RandomStringUtils.randomAlphabetic(3);
        return ("Semih"+generatedString);
    }

    public static String getPassword() {
        String generatedString = RandomStringUtils.randomAlphabetic(3);
        return ("Semih"+generatedString);
    }

    public static String getEmail() {
        String generatedString = RandomStringUtils.randomAlphabetic(3);
        return (generatedString + "gmail.com");
    }

    public static String empName() {
        String generatedString = RandomStringUtils.randomAlphabetic(1);
        return ("Semih"+generatedString);
    }

    public static String empSal() {
        String generatedString = RandomStringUtils.randomNumeric(5);
        return (generatedString);
    }

    public static String empAge() {
        String generatedString = RandomStringUtils.randomNumeric(2);
        return (generatedString);
    }




}
