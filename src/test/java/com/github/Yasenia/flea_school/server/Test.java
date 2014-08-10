package com.github.Yasenia.flea_school.server;

public class Test {
    public static String trim(String s) {
        StringBuffer bs = new StringBuffer();
        char[] cArray = s.toCharArray();
        for (int i = 0; i < cArray.length; i++) {
            if (cArray[i] != ' ') {
                bs.append(cArray[i]);
            }
        }
        return bs.toString();
    } 
    public static void main(String[] args) {
        String s = " 邓                 屿 松 ";
        System.out.println(trim(s));
    }
}
