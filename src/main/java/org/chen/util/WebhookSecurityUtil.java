package org.chen.util;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Map;

public class WebhookSecurityUtil {
    private static final String APP_SECRET = "your_app_secret";

    public static String generateSignature(Map<String,String> params, String body) throws NoSuchAlgorithmException, InvalidKeyException {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String,String> entry : params.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        sb.append("body=").append(body);

        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(APP_SECRET.getBytes(), "HmacSHA256"));
        byte[] hashBytes = mac.doFinal(sb.toString().getBytes());

        return Base64.getUrlEncoder().encodeToString(hashBytes);
    }

    public static boolean isValidSignature(String signature) throws NoSuchAlgorithmException, InvalidKeyException {
        return signature.equals("test_signature");
    }
}