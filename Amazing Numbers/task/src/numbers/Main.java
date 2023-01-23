package numbers;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Welcome to Amazing Numbers!

                Supported requests:
                - enter a natural number to know its properties;
                - enter two natural numbers to obtain the properties of the list:
                  * the first parameter represents a starting number;
                  * the second parameter shows how many consecutive numbers are to be processed;
                - two natural numbers and properties to search for;
                - a property preceded by minus must not be present in numbers;
                - separate the parameters with one space;
                - enter 0 to exit.
                """);

        while (true) {
            System.out.println("\nEnter a request: ");
            String string = scanner.nextLine().toLowerCase();
            String[] str = string.split(" ");
            try {
                Long.parseLong(str[0]);
            } catch (NumberFormatException e) {
                System.out.println("The first parameter should be a natural number or zero.");
                continue;
            }
            long num1 = Long.parseLong(str[0]);
            if (num1 < 0) {
                System.out.println("The first parameter should be a natural number or zero.");
                continue;
            } else if (num1 == 0) {
                System.out.println("Goodbye!");
                return;
            }

            if (str.length < 2) {
                System.out.println("Properties of " + num1);
                NumberKind.buzz(num1, 1);
                NumberKind.duck(num1, 1);
                NumberKind.palindromic(num1, 1);
                NumberKind.gapful(num1, 1);
                NumberKind.spy(num1, 1);
                NumberKind.square(num1, 1);
                NumberKind.jumping(num1, 1);
                NumberKind.sunny(num1, 1);
                NumberKind.even(num1, 1);
                NumberKind.odd(num1, 1);
                NumberKind.happy(num1, 1);
                NumberKind.sad(num1, 1);

            } else if (str.length == 2) {
                int num2 = Integer.parseInt(str[1]);
                if (num2 < 1) {
                    System.out.println("The second parameter should be a natural number.");
                    continue;
                }
                for (int i = 0; i < num2; i++) {
                    String strOut = num1 + " is " + NumberKind.numberKind(num1);
                    System.out.println(strOut);
                    num1++;
                }


            } else if (str.length > 2) {
                int num2 = Integer.parseInt(str[1]);
                if (num2 < 1) {
                    System.out.println("The second parameter should be a natural number.");
                    continue;
                }
                String[] strKindArray = new String[str.length - 2];
                System.arraycopy(str, 2, strKindArray, 0, str.length - 2);

                int countWrong = 0;
                ArrayList<String> wrongItems = new ArrayList<>();
                for (String item : strKindArray) {
                    if (!Properties.containsProp(item)) {
                        countWrong++;
                        wrongItems.add(item);
                    }
                }
                if (countWrong == 1) {
                    System.out.println("The property [" + wrongItems.get(0).toUpperCase() + "] is wrong.");
                    System.out.println("Available properties: " + Properties.toStringValue());
                    continue;
                } else if (countWrong > 1) {
                    System.out.println("The properties " + wrongItems.toString().toUpperCase() + " are wrong.");
                    System.out.println("Available properties: " + Properties.toStringValue());
                    continue;
                }

                ArrayList<String> stringArrayList = new ArrayList<>(List.of(strKindArray));
                int flag = 0;
                for (Properties item: Properties.values()) {
                    if (stringArrayList.contains(item.prop1) && stringArrayList.contains(item.prop2)) {
                        System.out.println("The request contains mutually exclusive properties: [" +
                                item.prop1.toUpperCase() + ", " + item.prop2.toUpperCase() +
                                "]\n" + "There are no numbers with these properties.");
                        flag = 1;
                    }
                }
                if (flag == 1) {
                    continue;
                }
                if (stringArrayList.contains("-square") && stringArrayList.contains("-sunny")) {
                    System.out.println("The request contains mutually exclusive properties: [" +
                            "-square".toUpperCase() + ", " + "-sunny".toUpperCase() +
                            "]\n" + "There are no numbers with these properties.");
                    continue;
                }
                if (stringArrayList.contains("square") && stringArrayList.contains("sunny")) {
                    System.out.println("The request contains mutually exclusive properties: [" +
                            "square".toUpperCase() + ", " + "sunny".toUpperCase() +
                            "]\n" + "There are no numbers with these properties.");
                    continue;
                }
                if (stringArrayList.contains("-odd") && stringArrayList.contains("-even")) {
                    System.out.println("The request contains mutually exclusive properties: [" +
                            "-odd".toUpperCase() + ", " + "-even".toUpperCase() +
                            "]\n" + "There are no numbers with these properties.");
                    continue;
                }
                if (stringArrayList.contains("odd") && stringArrayList.contains("even")) {
                    System.out.println("The request contains mutually exclusive properties: [" +
                            "odd".toUpperCase() + ", " + "even".toUpperCase() +
                            "]\n" + "There are no numbers with these properties.");
                    continue;
                }
                if (stringArrayList.contains("-spy") && stringArrayList.contains("-duck")) {
                    System.out.println("The request contains mutually exclusive properties: [" +
                            "-spy".toUpperCase() + ", " + "-duck".toUpperCase() +
                            "]\n" + "There are no numbers with these properties.");
                    continue;
                }
                if (stringArrayList.contains("spy") && stringArrayList.contains("duck")) {
                    System.out.println("The request contains mutually exclusive properties: [" +
                            "spy".toUpperCase() + ", " + "duck".toUpperCase() +
                            "]\n" + "There are no numbers with these properties.");
                    continue;
                }
                if (stringArrayList.contains("-happy") && stringArrayList.contains("-sad")) {
                    System.out.println("The request contains mutually exclusive properties: [" +
                            "-sad".toUpperCase() + ", " + "-happy".toUpperCase() +
                            "]\n" + "There are no numbers with these properties.");
                    continue;
                }
                if (stringArrayList.contains("happy") && stringArrayList.contains("sad")) {
                    System.out.println("The request contains mutually exclusive properties: [" +
                            "sad".toUpperCase() + ", " + "happy".toUpperCase() +
                            "]\n" + "There are no numbers with these properties.");
                    continue;
                }


                    long[] nums = NumberKind.numFound3(num1, num2, strKindArray);
                    for (long num : nums) {
                        System.out.println(num + " is " + NumberKind.numberKind(num));
                    }
                }
            }
        }


    private static long[] numFound(long num, int count, Properties kind) {
        long[] res = new long[count];
        int guantity = 0;
        switch (kind) {
            case BUZZ:
                while (guantity != count) {
                    if  (NumberKind.buzz(num, 2)) {
                        res[guantity] = num;
                        guantity++;
                    }
                    num++;
                }
            break;
            case DUCK:
                while (guantity != count) {
                    if  (NumberKind.duck(num, 2)) {
                        res[guantity] = num;
                        guantity++;
                    }
                    num++;
                }
            break;
            case PALINDROMIC:
                while (guantity != count) {
                    if  (NumberKind.palindromic(num, 2)) {
                        res[guantity] = num;
                        guantity++;
                    }
                    num++;
                }
                break;
            case GAPFUL:
                while (guantity != count) {
                    if  (NumberKind.gapful(num, 2)) {
                        res[guantity] = num;
                        guantity++;
                    }
                    num++;
                }
                break;
            case SPY:
                while (guantity != count) {
                    if  (NumberKind.spy(num, 2)) {
                        res[guantity] = num;
                        guantity++;
                    }
                    num++;
                }
                break;
            case EVEN:
                while (guantity != count) {
                    if  (NumberKind.even(num, 2)) {
                        res[guantity] = num;
                        guantity++;
                    }
                    num++;
                }
                break;
            case ODD:
                while (guantity != count) {
                    if  (NumberKind.odd(num, 2)) {
                        res[guantity] = num;
                        guantity++;
                    }
                    num++;
                }
                break;
            case SQUARE:
                while (guantity != count) {
                    if  (NumberKind.square(num, 2)) {
                        res[guantity] = num;
                        guantity++;
                    }
                    num++;
                }
                break;
            case SUNNY:
                while (guantity != count) {
                    if  (NumberKind.sunny(num, 2)) {
                        res[guantity] = num;
                        guantity++;
                    }
                    num++;
                }
                break;
            case JUMPING:
                while (guantity != count) {
                    if  (NumberKind.jumping(num, 2)) {
                        res[guantity] = num;
                        guantity++;
                    }
                    num++;
                }
                break;
            case HAPPY:
                while (guantity != count) {
                    if  (NumberKind.happy(num, 2)) {
                        res[guantity] = num;
                        guantity++;
                    }
                    num++;
                }
                break;
            case SAD:
                while (guantity != count) {
                    if  (NumberKind.sad(num, 2)) {
                        res[guantity] = num;
                        guantity++;
                    }
                    num++;
                }
                break;


        }
        return res;
    }

}