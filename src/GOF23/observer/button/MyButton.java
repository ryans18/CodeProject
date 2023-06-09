package GOF23.observer.button;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Author : Ryans
 * Date : 2023/6/8
 * Introduction :
 */
public class MyButton {

    private int id;
    private String name;
    private List<OnClickListener> listenerList;

    public MyButton(int id, String name) {
        this.id = id;
        this.name = name;
        listenerList = new ArrayList<>();
    }

    public void addClickListener(OnClickListener listener) {
        listenerList.add(listener);
    }

    public interface OnClickListener {
        void onClick();
    }

    private void onStateChange(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEY_LOCATION_RIGHT) {

        }
    }

    private void notifyAllClickListener() {
        for (OnClickListener listener : listenerList) {
            listener.onClick();
        }
    }


}
