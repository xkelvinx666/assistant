package cn.caijinbiao.assistant.util;

import cn.caijinbiao.assistant.exception.IsNullOrEmptyException;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;

@Slf4j
public class CommonUtil {
    public static void isNotNullOrEmpty(Object obj, String description) {
        if (null == obj) {
            throw new IsNullOrEmptyException(description);
        }
        if (obj instanceof String && "".equals(String.valueOf(obj))) {
            throw new IsNullOrEmptyException(description);
        }
        if (obj instanceof CharSequence) {
            if (((CharSequence) obj).length() == 0) {
                throw new IsNullOrEmptyException(description);
            }
        }
        if (obj instanceof Collection) {
            if (((Collection) obj).isEmpty()) {
                throw new IsNullOrEmptyException(description);
            }
        }
        if (obj instanceof Map) {
            if (((Map) obj).isEmpty()) {
                throw new IsNullOrEmptyException(description);
            }
        }
        if (obj instanceof Object[]) {
            Object[] object = (Object[]) obj;
            if (object.length == 0) {
                throw new IsNullOrEmptyException(description);
            }
            for (int i = 0; i < object.length; i++) {
                isNotNullOrEmpty(object[i], description);
            }
        }
    }

    public static String getProperty(String fileName, String property) {
        Properties props = new Properties();
        File file = new File(fileName);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            props.load(fis);
        } catch (Exception e) {
            log.error("未找到properties", e);
        }
        return props.getProperty(property);
    }
}
