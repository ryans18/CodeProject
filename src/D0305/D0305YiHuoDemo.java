package D0305;

public class D0305YiHuoDemo {

    public static void main(String[] args) {
        int [] array = new int[]{1,4,5,6,4,5,1};
        int content = 0;
        for (int item : array) {
            content ^= item;
        }
        System.out.println(content);
    }
}
