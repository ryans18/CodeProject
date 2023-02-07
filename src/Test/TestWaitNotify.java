package Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Author : Ryans
 * Date : 2023/2/3
 * Introduction : 生产者消费模型
 */
public class TestWaitNotify {

    public  static void main(String[] args) {
        TestWaitNotify test = new TestWaitNotify();
       /* try {
            synchronized (test) {
                test.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        SyncContainer pool = new SyncContainer();
        new Customer(pool).start();
        new Producer(pool).start();
    }
}

// 生产
 class Producer extends Thread {
    SyncContainer container;
    public Producer(SyncContainer container) {
        this.container = container;
    }
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            // 先生产好，再push，否则会出现消费者先消费的日志
            System.out.println("生产了一只鸡: " + i);
            container.push(new Chicken(i));
        }
    }
}

// 消费
class Customer extends Thread {
    SyncContainer container;
    public Customer(SyncContainer container) {
        this.container = container;
    }
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 50; i++) {
            Chicken chicken = container.pop();
            System.out.println("消费者吃了一只鸡: " + chicken.id);
        }
    }
}

// 缓存池
class SyncContainer {

    // 最大容量10个鸡
    CopyOnWriteArrayList<Chicken> list = new CopyOnWriteArrayList<>();
    static final int MAX_SIZE = 10;

    // 生产者生产
    public synchronized void push(Chicken chicken) {
        if (list.size() == MAX_SIZE) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 池子没有慢，通知消费者消费
        list.add(chicken);
        this.notifyAll();
    }

    public synchronized Chicken pop() {
        // 池子里没有，先等待生产者生产
        if (list.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 池子里右，消费一只
        Chicken chicken = list.remove(0);
        this.notifyAll();
        // 通知生产者生产
        return chicken;
    }
}

class Chicken {
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}
