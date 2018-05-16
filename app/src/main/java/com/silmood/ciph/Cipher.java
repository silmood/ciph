package com.silmood.ciph;


public class Cipher {

    public static String rot13(String text) {
        char[] chars = text.toCharArray();
        StringBuilder result = new StringBuilder();

        for (char c : chars) {
            if       (c >= 'a' && c <= 'm') c += 13;
            else if  (c >= 'A' && c <= 'M') c += 13;
            else if  (c >= 'n' && c <= 'z') c -= 13;
            else if  (c >= 'N' && c <= 'Z') c -= 13;

            result.append(c);
        }
        return result.toString();
    }
}
