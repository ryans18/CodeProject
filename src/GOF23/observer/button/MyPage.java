package GOF23.observer.button;

/**
 * Author : Ryans
 * Date : 2023/6/8
 * Introduction :
 */
public class MyPage {

    private MyButton button;

    public MyPage() {
        button = new MyButton(1, "test");
        button.addClickListener(() -> {
            System.out.println("button click");
        });
    }
}
