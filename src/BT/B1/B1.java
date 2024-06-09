package BT.B1;

public class B1 {
    public static void main(String[] args) {
        String str1 = "Hello World";
        String str2 = "        Hello World       ";
        String str3 = "hello world";

        System.out.println(str1.isEmpty()); //false
        System.out.println(str2.trim()); //Hello World
        System.out.println(str1.equals(str2)); //false
        System.out.println(str1.equalsIgnoreCase(str3)); //true
        String[] str1Arr = str1.split(" ");
        for (String str : str1Arr) {
            System.out.println(str);
        }
        System.out.println(str1.concat(str2)); //plus 2 str
        System.out.println(str2.contains(str1)); //true
        System.out.println(str1.toLowerCase()); //str1 = hello world
        System.out.println(str3.toUpperCase()); //str3 = HELLO WORLD
        System.out.println(str3.replace("llo","kka"));
        System.out.println(str3);
        System.out.println(str1.length());

    }
//    public static boolean isEmpty(String str) {
//        return str.isEmpty();
//    }
}
