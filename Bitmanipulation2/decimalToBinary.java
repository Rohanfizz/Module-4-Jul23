import java.util.*;

class decimalToBinary{

    public static void displayBinary(int n){
        String s = "";
        for(int i = 0;i<32;i++){
            if((n & (1<<i))!=0) s="1"+s;
            else s="0"+s;
        }
        System.out.println(s);
    }

    public static void main(String[] args){
        displayBinary(Integer.MAX_VALUE);
        displayBinary(Integer.MAX_VALUE+1);
        displayBinary(Integer.MIN_VALUE);
        displayBinary(Integer.MIN_VALUE-1);
        displayBinary(-1);
        System.out.println(Integer.MAX_VALUE+1);
    
    }
}