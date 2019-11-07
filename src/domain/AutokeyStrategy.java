package domain;

import java.util.*;
import java.lang.*;
import java.math.*;

public class AutokeyStrategy implements CodingStrategyWithOffset {

    private static String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String key;

    public AutokeyStrategy(String key)
    {
        this.key = key;
    }

    public void setKey(String key)
    {
        this.key = key.toUpperCase();
    }


    @Override
    public String encode(String input) {
        int len = input.length();

        String subkey = key + input;
        subkey = subkey.substring(0,subkey.length()-key.length());

        String sb = "";
        for(int x=0;x<len;x++){
            int get1 = alpha.indexOf(input.charAt(x));
            int get2 = alpha.indexOf(subkey.charAt(x));

            int total = (get1 + get2)%26;

            sb += alpha.charAt(total);
        }

        return sb;
    }

    @Override
    public String decode(String input) {
        int len = input.length();

        String current = key;
        String result ="";

        for(int x=0;x<len;x++){
            int get1 = alpha.indexOf(input.charAt(x));
            int get2 = alpha.indexOf(current.charAt(x));

            int total = (get1 - get2)%26;
            total = (total<0)? total + 26 : total;
            result += alpha.charAt(total);

            current += alpha.charAt(total);
        }
        return result;
    }

    @Override
    public String toString(){
        return "AutokeyStrategy";
    }

    @Override
    public void setOffset(String offset) {
        this.key = offset;
    }
}
