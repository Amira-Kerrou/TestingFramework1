package utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class DataProviderUtil {

    private DataProviderUtil() {
    }

    public static <T> List<T> getListFromJsonFile(String fileName, String jsonArrayName, Class<T> valueType)
            throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(fileName);
        JsonNode rootNode = objectMapper.readTree(file);
        JsonNode jsonArrayNode = rootNode.get(jsonArrayName);
        TypeFactory typeFactory = objectMapper.getTypeFactory();
        return objectMapper.readValue(jsonArrayNode.traverse(),
                typeFactory.constructCollectionType(List.class, valueType));
    }

}
