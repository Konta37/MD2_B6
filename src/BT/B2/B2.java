package BT.B2;

public class B2 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append("Hoho");
        System.out.println(sb);
        sb.insert(1,"Hehe"); //insert text into that index
        System.out.println(sb);
        sb.replace(2,5,"ggggggg");
        System.out.println(sb);
        sb.delete(2,5);
        sb.delete(2,6);
        System.out.println(sb);
        System.out.println(sb.length());
        System.out.println(sb.reverse());

    }
}
