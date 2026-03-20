package it.univaq.aisbackend.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class FileUtils {
    private FileUtils() {
    }

    public static <T> T read(String fileName, TypeReference<T> typeReference) throws Exception {
        Resource resource = new ClassPathResource("static/%s.json".formatted(fileName));
        if (resource.exists()) {
            InputStream is = new ByteArrayInputStream(resource.getContentAsByteArray());

            Object var5;
            try {
                ObjectMapper mapper = new ObjectMapper();
                var5 = mapper.readValue(is.readAllBytes(), typeReference);
            } catch (Throwable var7) {
                try {
                    is.close();
                } catch (Throwable var6) {
                    var7.addSuppressed(var6);
                }

                throw var7;
            }

            is.close();
            return (T)var5;
        } else {
            throw new RuntimeException("File not Found");
        }
    }

    public static byte[] read(String fileName) throws Exception {
        Resource resource = new ClassPathResource("static/%s.glb".formatted(fileName));
        if (resource.exists()) {
            return resource.getContentAsByteArray();
        } else {
            throw new RuntimeException("File not Found");
        }
    }
}
