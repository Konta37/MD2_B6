package BT.B3;

public class B3 {
    public static void main(String[] args) {
        String str1 = "username@OrganizationName. area symbol";
        String str2 = "rikeiacademy@rikkeisoft.com";
        String str4 = "konta@gmail.com";

        String regex = "\\d{3}-\\d{2}-\\d{4}";
        String regexEmail = "\\w{3,20}@rikkeisoft.com";
        String str3 = "000-00-0000";
        System.out.println(str3.matches(regex));
        System.out.println(str2.matches(regexEmail));
        System.out.println(str4.matches(regexEmail));
    }
}
