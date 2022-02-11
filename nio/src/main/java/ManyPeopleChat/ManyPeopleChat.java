package ManyPeopleChat;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author jiazhiyuan
 * @date 2021/12/10 11:58 上午
 */
public class ManyPeopleChat {

    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static final int PORT = 6667;


    public ManyPeopleChat() {
        try {
            selector = Selector.open();
            listenChannel = ServerSocketChannel.open();
            listenChannel.socket().bind(new InetSocketAddress(PORT));
            listenChannel.configureBlocking(false);

            //将该listenChannel 注册到selector
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //监听
    public void listen() {

        try {
            //循环处理
            while (true) {
                int count = selector.select(2000);

                if (count > 0) {
                    //遍历得到selectionKey 集合
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();


                        //监听到accept
                        if (key.isAcceptable()) {
                            SocketChannel sc = listenChannel.accept();
                            //将该sc注册到selector
                            sc.register(selector, SelectionKey.OP_READ);
                        }

                        if (key.isReadable()) {
                            //通道发送read事件，即通道是刻度的状态


                            //处理读(专门写方法)


                        }
                    }
                } else {
                    System.out.println("等待。。。。。。。。。。");
                }
            }
        } catch (Exception e) {


        }
    }
}



    
