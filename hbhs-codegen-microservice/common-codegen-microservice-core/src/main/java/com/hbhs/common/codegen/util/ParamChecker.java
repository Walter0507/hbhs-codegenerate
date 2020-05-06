package com.hbhs.common.codegen.util;

public class ParamChecker {

    public static void assertNotNull(Object o, String message){
        assertTrue(o!=null,message);
    }

    public static void assertNotEmpty(String str, String message){
        assertTrue(str!=null&&!"".equalsIgnoreCase(str),message);
    }

    private static void assertTrue(boolean result, String message){
        if (!result){
            throw new RuntimeException(message);
        }
    }
}
