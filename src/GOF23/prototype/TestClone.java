package GOF23.prototype;

import java.util.Date;

/**
 * Author : Ryans
 * Date : 2023/2/14
 * Introduction :  原型模式-即通过克隆创建对象
 */
public class TestClone {

    public static void main(String[] args) throws Exception{
        Date date = new Date();
        Video video = new Video("今日说法", date);
        System.out.println("===============浅clone=================");
        System.out.println("video1: " + video);
        Video video2 = (Video)video.clone();
        System.out.println("video2: " + video2);
        System.out.println("修改后");
        video.getDate().setTime(0);
        System.out.println("video1: " + video);
        System.out.println("video2: " + video2);
        System.out.println("===============深clone=================");
        Video2 video21 = new Video2("新闻联播", new Date());
        System.out.println("===============浅clone=================");
        System.out.println("video21: " + video);
        Video2 video22 = (Video2)video21.clone();
        System.out.println("video22: " + video2);
        System.out.println("修改后");
        video21.getDate().setTime(0);
        System.out.println("video21: " + video21);
        System.out.println("video22: " + video22);
    }
}
