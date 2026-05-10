package dataproviders;

import utils.JsonUtil;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.util.List;
import java.util.Map;

public class jsonDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] getLoginDataFromJson() {
        try {
            File jsonFile = JsonUtil.readLoinDataFromJson();
            ObjectMapper mapper = new ObjectMapper();
            List<Map<String, String>> data = mapper.readValue(jsonFile, new TypeReference<>() {});

            Object[][] result = new Object[data.size()][2];
            for (int i = 0; i < data.size(); i++) {
                result[i][0] = data.get(i).get("email");
                result[i][1] = data.get(i).get("password");
            }
            return result;
        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to read JSON data: " + e.getMessage(), e);
        }
    }
}
