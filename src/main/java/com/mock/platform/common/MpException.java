package com.mock.platform.common;

/**
 * @author wessonlan
 */
public class MpException extends RuntimeException{
    private MpException(String message) {
        super(message);
    }

    public static void throwException(String message) {
        throw new MpException(message);
    }
}
