package GOF23.observer.children;

import java.util.ArrayList;
import java.util.List;

/**
 * Author : Ryans
 * Date : 2023/6/8
 * Introduction :
 */
public class Child {

    private List<CryObserver> observerList;

    public Child() {
        observerList = new ArrayList<>();
    }

    public void addObserver(CryObserver cryObserver) {
        observerList.add(cryObserver);
    }

    public void sleep() {
        System.out.println("Child 正在睡觉");
        try {
            Thread.sleep(Math.round(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Child 睡醒了");
        notifyAllObserver();
    }

    private void notifyAllObserver() {
        for (CryObserver cryObserver : observerList) {
            cryObserver.onCry();
        }
    }
}
