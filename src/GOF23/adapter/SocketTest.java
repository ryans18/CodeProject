package GOF23.adapter;

/**
 * Author : Ryans
 * Date : 2023/6/9
 * Introduction : 到欧洲通过适配器给中国手机充电
 */
public class SocketTest {

    public static void main(String[] args) {
        System.out.println("到欧洲旅行了！ 开心");
        ChinaPhone phone = new ChinaPhone();
        Europe2ChinaSocket socket = new Europe2ChinaSocket(new EuropeSocket());
        phone.charge(socket);
    }
}

class Europe2ChinaSocket extends ChinaSocket{

    EuropeSocket europeSocket;

    Europe2ChinaSocket(EuropeSocket europeSocket) {
        this.europeSocket = europeSocket;
    }

    @Override
    void energize() {
        europeSocket.energize();
    }
}

class ChinaPhone {

    // 中国手机充电必须使用中国充电器
    void charge(ChinaSocket socket) {
        socket.energize();
        System.out.println("充电成功！");
    }
}

// 中国插座
class ChinaSocket{
    // 通电
    void energize() {
        System.out.println("接入中国插座通电");
    }
}

// 欧洲插座
class EuropeSocket{
    // 通电
    void energize() {
        System.out.println("接入欧洲插座通电");
    }
}
