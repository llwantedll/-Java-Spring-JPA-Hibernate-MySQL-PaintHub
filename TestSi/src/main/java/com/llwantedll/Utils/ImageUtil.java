package com.llwantedll.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;


//USEFUL UTILS FOR WORK WITH IMAGES
public class ImageUtil {
    public static byte[] writingImage(String fileLocation) {
        File file = new File(fileLocation);
        try {
            return Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String byteImageToBase64(byte[] image){
        return Base64.getEncoder().encodeToString(image);
    }
}
