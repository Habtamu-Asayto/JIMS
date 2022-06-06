/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jservlet.serialcomm;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class test {
        static String ucsmsg = "";
        static int bb = 0, bblen = 0;
    private static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    
    public static void main(String arg[]){
    
 
    test t= new test();
       
   System.out.println(" the encoming is "+t.ucsencode("hello world"));

        
    }
    
    public static String toHexString(int b)
	{
		char[] digits = new char[2];
		b = b & 255;
		digits[0] = hexDigits[b / 0x10];
		digits[1] = hexDigits[b % 0x10];
		return new String(digits);
	}
    
    
    
    
    
    
    
    
    
    
    
    private static byte[] encodeUCS2(String message, byte[] header)
        throws UnsupportedEncodingException {
            byte[] userData, textPart;
            textPart = message.getBytes("utf-16be");
            if (header != null) {
                // Need 1 byte for UDHL
                userData = new byte[header.length + textPart.length + 1];
                userData[0] = (byte)header.length;
                System.arraycopy(header, 0, userData, 1, header.length);
                System.arraycopy(textPart, 0, userData, header.length + 1, textPart.length);
            }
            else {
                userData = textPart;
            }
            byte[] ret = new byte[userData.length+1];
            ret[0] = (byte) (userData.length & 0xff );
            System.arraycopy(userData, 0, ret, 1, userData.length);
            return ret;
    }
    
    
    
    public   String   ucsencode(String msg)
{
    String text=msg;
   try {
            byte[] textByte = text.getBytes("UTF-16BE");
            for(int i = 0; i < textByte.length; i++)
            System.out.print( textByte[i] );
            
            StringBuffer msgg = new StringBuffer(msg);
            StringBuffer encmsg = new StringBuffer(2 * 160);
            
            StringBuilder sb = new StringBuilder();
        for (byte b : textByte) {
        sb.append(String.format("%02X ", b));
    }
   // System.out.println(" the encioded message is =============>"+sb.toString().replaceAll("\\s",""));
     return sb.toString().replaceAll("\\s","");
            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
   
}
}
