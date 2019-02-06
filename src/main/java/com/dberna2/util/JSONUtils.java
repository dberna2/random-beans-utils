package com.dberna2.util;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class JSONUtils {

    private static final String FORMAT_FILE = ".json";

    public static <T> List<T> getListByClass(Class<T> object) {
        try {
            final InputStream jsonData = getFileByName(object.getSimpleName());

            if(Objects.isNull(jsonData)){
                return getDefaultValue(object);
            }

            StringWriter writer = new StringWriter();
            ObjectMapper mapper = new ObjectMapper();

            IOUtils.copy(jsonData, writer, "UTF-8");

            String jsonString = writer.toString();

            Class<?> clz = Class.forName(object.getName());
            JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, clz);

            return mapper.readValue(jsonString, type);
        } catch (ClassNotFoundException | IOException e) {
            System.out.println(e);
            return getDefaultValue(object);
        }
    }

    private static <T> List<T> getDefaultValue(Class<T> object) {
        try {
            return Arrays.asList(object.newInstance());
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    private static InputStream getFileByName(String name){
        return JSONUtils.class.getResourceAsStream("/"+ name + FORMAT_FILE);
    }
}
