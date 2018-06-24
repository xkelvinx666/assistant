package cn.caijinbiao.assistant.util;

import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class ImageUtil {
    public static byte[] fetchImageByUrl(String url) throws IOException {
        return IOUtils.toByteArray(new URL(url));
    }

    public static String ImageToBase64(byte[] images) {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(images);
    }
}
