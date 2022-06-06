
package process;

import java.util.Random;

public class Randomtext {
 public String generaterandom()
 {
 
 final String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final int N = alphabet.length();
    Random r = new Random();
    char []text= new char[9];
    for (int i = 0; i < 8; i++) {
          text[i]=alphabet.charAt(r.nextInt(N));
        System.out.print(text[i]);
    }
    String st=new String(text);
  return st;
 }
}
