package util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class EncodeUtil {

    public String getBase64TextDecoder(String encodedText) {
        byte[] decodedArr;
        try {
            decodedArr = Base64.getDecoder().decode(encodedText);

            return new String(decodedArr, "UTF-8");
        } catch (IllegalArgumentException | UnsupportedEncodingException e) {
            throw new RuntimeException("Não foi encontrado a String Base64: " + encodedText);
        }
    }
}
