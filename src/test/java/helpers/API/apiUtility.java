package helpers.API;

import org.apache.commons.lang3.RandomStringUtils;

import java.io.File;

public class apiUtility {
    public static File JSONSchemaFile(String JSONfile){
        return new File("src/test/java/helpers/API/jsonSchema/" + JSONfile);
    }
    public static String dinamicEmail(){
        String chars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "._-";
        String email = "";
        String template = RandomStringUtils.randomAlphabetic(8);
        email = template + "@testapi.com";
        return email;
    }
}
