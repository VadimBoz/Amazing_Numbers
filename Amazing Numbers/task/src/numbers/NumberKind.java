package numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class NumberKind {

    static long[] numFound2(long num, int count, String kind1, String kind2) {
        long[] res = new long[count];
        String nums;
        int i = 0;
        while (i < count) {
            nums = numberKind(num);
            if (nums.contains(kind1.toLowerCase()) && nums.contains(kind2.toLowerCase())) {
                res[i] = num;
                i++;
            }
            num++;
        }
        return res;
    }

    static long[] numFound3(long num, int count, String[] kind) {
        HashSet<String> h = new HashSet<>(Arrays.asList(kind));
        int len = h.size();
        long[] res = new long[count];
        String nums;
        int i = 0;
        int flag = 0;
        while (i < count) {
            nums = numberKind(num);
            flag = 0;
            for (String item : h) {
                if (item.contains("-")) {
                    item = item.substring(1);
                    if (nums.contains(item)) {
                        flag = 1;
                        break;
                    }
                }
                else if (!nums.contains(item)) {
                    flag = 1;
                    break;
                }
            }
            num++;
            if (flag != 0) {
                continue;
            }
            res[i] = num -1 ;
            i++;
        }
        return res;
    }

    static String  numberKind(long num) {
        String strBuzz = "", strDuck = "", strPalindromic = "", strGapful = "", strSpy = "", strEven = "", strOdd = "";
        String strSquare = "", strSunny = "", strJumping = "", strHappy = "",  strSad = "";
        if (buzz(num, 2)) strBuzz = "buzz ";
        if (duck(num, 2)) strDuck = "duck ";
        if (palindromic(num, 2)) strPalindromic = "palindromic ";
        if (gapful(num, 2)) strGapful = "gapful ";
        if (spy(num, 2)) strSpy = "spy ";
        if (square(num, 2)) strSquare = "square ";
        if (even(num, 2)) strEven = "even ";
        if (odd(num, 2)) strOdd = "odd ";
        if (sunny(num, 2)) strSunny = "sunny ";
        if (jumping(num, 2)) strJumping = "jumping ";
        if (happy(num, 2)) strHappy = "happy";
        if (sad(num, 2)) strSad = "sad";
        String str = strBuzz + strDuck + strPalindromic  + strGapful + strSpy + strSquare + strSunny + strJumping +
                strEven  + strOdd  +  strHappy + strSad;
        String[] array = str.split(" ");
        StringBuilder strRes = new StringBuilder();
        for (int i = 0; i < array.length -1 ; i++) {
            strRes.append(array[i]);
            strRes.append(", ");
        }
        strRes.append(array[array.length -1]);
        return strRes.toString();
    }

    static boolean jumping(long num, int flag) {
        long remains;
        long numTemp;
        if (num > 0 && num < 11) {
            if (flag == 1) System.out.println("jumping: true");
            return true;
        } else {
            do {
                remains = num % 10;
                numTemp = (num / 10) % 10 - remains ;
                if (numTemp == 1 || numTemp == -1) {
                    num /= 10;
                } else {
                    if (flag == 1) System.out.println("jumping: false");
                    return false;
                }
            } while (num > 9);
        }
        if (flag == 1) System.out.println("jumping: true");
        return true;
    }

    static boolean spy(Long num, int flag) {
        if (num < 10) {
            if (flag == 1) System.out.println("spy: true");
            return true;
        }
        else {
            long sum = 0;
            long mult = 1;
            long temp;
            while (num > 0) {
                temp = num % 10;
                num = num / 10;
                sum += temp;
                mult *= temp;
            }
            if (sum == mult) {
                if (flag == 1) System.out.println("spy: true");
                return true;
            }
            else {
                if (flag == 1) System.out.println("spy: false");
                return false;
            }
        }
    }

    static boolean square(Long num, int flag) {
        long temp = (long) Math.sqrt(num);
        if (temp * temp == num ) {
            if (flag == 1) System.out.println("square: true");
            return true;
        }
        else {
            if (flag == 1) System.out.println("square: false");
            return false;
        }
    }

    static boolean sunny(Long num, int flag) {
        if (square(num  + 1, 2)) {
            if (flag == 1) System.out.println("sunny: true");
            return true;
        }
        else {
            if (flag == 1) System.out.println("sunny: false");
            return false;
        }
    }

    static boolean even(long num, int flag) {
        if (num % 2 == 0) {
            if (flag == 1)  System.out.println("even: true");
            return true;
        }
        else {
            if (flag == 1) System.out.println("even: false");
            return false;
        }
    }

    static boolean odd(long num, int flag) {
        if (num % 2 != 0) {
            if (flag == 1) System.out.println(" odd: true");
            return true;
        }
        else {
            if (flag == 1) System.out.println(" odd: false");
            return false;
        }
    }

    static boolean buzz(long num, int flag) {
        if (num % 7 == 0 || num % 10 == 7) {
            if (flag == 1) System.out.println("buzz: true");
            return true;
        }
        else {
            if (flag == 1) System.out.println("buzz: false");
            return false;
        }
    }

    static boolean duck(long num, int flag) {
        String numStr = Long.toString(num);

        if (numStr.contains("0")) {
            if (flag == 1) System.out.println("duck: true");
            return true;
        }
        else {
            if (flag == 1) System.out.println("duck: false");
            return false;
        }
    }

    static boolean palindromic(long num, int flag) {
        String numStr = Long.toString(num);
        String numStr2 = reverseString(numStr);
        if (numStr.equals(numStr2)) {
            if (flag == 1) System.out.println("palindromic: true");
            return true;
        } else {
            if (flag == 1) System.out.println("palindromic: false");
            return false;
        }
    }

    private static String reverseString(String str) {
        String rightStr;
        String leftStr;
        int length = str.length();

        if (length <= 1) {
            return str;
        }
        leftStr = str.substring(0, length / 2);
        rightStr = str.substring(length / 2, length);
        return reverseString(rightStr) + reverseString(leftStr);
    }


    static boolean gapful(Long num, int flag) {
        if (num > 99){
            String numStr = Long.toString(num);
            int len = numStr.length();
            long firstLast = Long.parseLong("" + numStr.charAt(0)+ numStr.charAt(len-1));
            if (num % firstLast == 0 ){
                if (flag == 1) System.out.println("gapful: true");
                return true;
            }
            else {
                if (flag == 1) System.out.println("gapful: false");
                return false;
            }
        }
        else {
            if (flag == 1) System.out.println("gapful: false");
            return false;
        }
    }

    private static boolean happyNum(long num, int i, int flag) {
        if (num == 1 && i < 30) return true;
        if  (i > 30) return false;
        ArrayList<Long> gigits = new ArrayList<>();
        while (num > 0) {
            gigits.add(num % 10);
            num /= 10;
        }
        int sum = 0;
        for (Long item : gigits) {
            sum += item*item;
        }
        i++;
        return happyNum(sum, i,2);
    }


    static boolean happy(long num, int flag) {
        if (happyNum(num, 0, flag)) {
            if (flag == 1) System.out.println("happy: true");
            return true;
        }  else {
            if (flag == 1) System.out.println("happy: false");
            return false;
        }
    }


    static boolean sad(long num, int flag) {
        if (!happyNum(num, 0, flag)) {
            if (flag == 1) System.out.println("sad: true");
            return true;
        }  else {
            if (flag == 1) System.out.println("sad: false");
            return false;
        }
    }


//    public static void main(String[] args) {
//        System.out.println(happy(999, 0, 2));
//    }


}


