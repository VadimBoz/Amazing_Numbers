package numbers;

import java.util.Arrays;

public enum Properties {
    BUZZ("buzz", "-buzz"),
    DUCK("duck", "-duck"),
    PALINDROMIC("palindromic", "-palindromic"),
    GAPFUL("gapful", "-gapful"),
    SPY("spy", "-spy"),
    SQUARE("square", "-square"),
    SUNNY("sunny", "-sunny"),
    JUMPING("jumping", "-jumping"),
    EVEN("even", "-even"),
    ODD("odd", "-odd"),
    HAPPY("happy", "-happy"),
    SAD("sad", "-sad");

    final String prop1;
    final String prop2;

    Properties(String prop1, String prop2) {
        this.prop1 = prop1;
        this.prop2 = prop2;
    }


    public static String getPropByOrder(int num) {
        int i = 0;
        for (Properties item: values()) {
            if (i == num) {
                return item.prop1 + " " + item.prop2;
            }
            i++;
        }
        return null;
    }

    public static String toStringValue() {
        StringBuilder res  = new StringBuilder();
        for (Properties value: values()) {
            res.append(value);
            res.append(" ");
        }
        return Arrays.asList(Properties.values()).toString();
    }

    public static String toStringProperties() {
        StringBuilder res  = new StringBuilder();
        for (Properties item: values()) {
            res.append(item.prop1);
            res.append(" ");
            res.append(item.prop2);
            res.append(" ");
        }
        return res.toString();
    }

    public static boolean containsProp(String str) {
        for (Properties item : Properties.values()) {
            if (item.prop1.equals(str) || item.prop2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsValue(String str) {
        for (Properties item : Properties.values()) {
            if (item.name().equals(str)) {
                return true;
            }
        }
        return false;
    }

//    public static void main(String[] args) {
//        System.out.println(toStringProperties());
//    }

}
