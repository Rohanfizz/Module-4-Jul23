import java.util.*;

class intro{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        System.out.println(10 & 12);
        System.out.println(10 | 12);
        System.out.println(10 ^ 12);
        int n = 12;
        n <<= 2;  // same as n = n<<2;
        System.out.println(n);
        scn.close();
    }
}
