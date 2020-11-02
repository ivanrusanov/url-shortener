package com.myservices.urlshortener.utils;

import java.util.Random;

public class StringTools {

    /**
     * Generate random alphanumeric string with given length
     * @param length string length
     * @return alphanumeric string
     */
    public static String getRandomString(int length) {
        // Symbol codes in ascii table from '0' to 'z'
        int leftLimit = 48;
        int rightLimit = 122;

        Random random = new Random();
        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
