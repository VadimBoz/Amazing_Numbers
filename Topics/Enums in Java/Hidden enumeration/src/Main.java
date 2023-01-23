public class Main {

    public static void main(String[] args) {
        int counter = 0;

        for (Secret item: Secret.values()) {
            String str = item.toString();
            if (str.contains("STAR")) {
                counter++;
//                System.out.println(item);
            }
        }


        System.out.println(counter);
    }
}


//enum Secret {
//    STAR, CRASH, START
//}
