package org.selenium.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import java.io.InputStream;

public final class JacksonUtils {

    private JacksonUtils() {}

    @SneakyThrows
    public static <T> T deserializeJson (String fileName, Class<T> T) {
        InputStream is = JacksonUtils.class.getClassLoader().getResourceAsStream(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(is, T);
    }
}

