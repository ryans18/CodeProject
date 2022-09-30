package Middle.Class1;

/**
 * Author : Ryans
 * Date : 2022/9/28
 * Introduction : 小虎买苹果，只有6袋和8袋，返回最小使用的袋子，不能装下，返回-1
 */
public class AppleQuestion {

    private static int getMinBags(int apple) {
        int bag8 = apple / 8;
        int bag6 = -1;
        while ( bag8 >= 0 && (apple - bag8 * 8) < 24) {
            if ((apple - bag8 * 8) % 6 == 0) {
                bag6 = (apple - bag8 * 8) / 6;
                break;
            }
            bag8--;
        }
        return bag6 == -1 ? -1 : bag6 + bag8;
    }

    // 打表法，找出规律
    public static int minBagAwesome(int apple){
        if((apple & 1) != 0){//如果是奇数，返回-1
            return -1;
        }
        if(apple < 18){
            return apple == 0 ? 0 : (apple == 6 || apple == 8 ) ? 1
                    : (apple == 12 || apple == 14 || apple == 16) ? 2 : -1;
        }
        return (apple - 18) / 8 + 3;
    }

    public static void main(String[] args) {
        for (int apple = 0; apple <= 100; apple++) {
            System.out.println(apple + ": " + getMinBags(apple) + " : " + minBagAwesome(apple));
        }
    }
}
