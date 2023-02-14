package GOF23.prototype;

import java.util.Date;

/**
 * Author : Ryans
 * Date : 2023/2/14
 * Introduction :
 */
public class Video2 implements Cloneable{

    private String name;
    private Date date;

    public Video2(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    protected Video2 clone() throws CloneNotSupportedException {
        Video2 video2 = (Video2)super.clone();
        video2.date = (Date) this.date.clone();
        return video2;
    }

    @Override
    public String toString() {
        return "Video2{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
