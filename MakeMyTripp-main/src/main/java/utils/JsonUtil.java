package utils;

import java.io.File;
import java.net.URL;

public class JsonUtil {

    public static File readLoinDataFromJson() {
        URL resource = JsonUtil.class.getClassLoader().getResource("loginData.json");
        if (resource == null) {
            throw new RuntimeException("❌ loginData.json not found in src/test/resources folder!");
        }
        return new File(resource.getFile());
    }
}
