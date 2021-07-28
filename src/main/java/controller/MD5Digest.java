package controller;

import java.security.MessageDigest;

public class MD5Digest {

    public String convertString(String pass) throws Exception {

//        if (args.length != 1) {
//            System.err.println("String to MD5 digest should be first and only parameter");
//            return;
//        }
        String original = pass;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(original.getBytes());
        byte[] digest = md.digest();
        StringBuffer sb = new StringBuffer();
        for (byte b : digest) {
            sb.append(String.format("%02x", b & 0xff));
        }
        String finalPass = sb.toString();

        return finalPass;
    }

}