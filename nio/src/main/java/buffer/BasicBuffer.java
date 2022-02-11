package buffer;

import java.nio.IntBuffer;

/**
 * @author jiazhiyuan
 * @date 2021/12/10 1:06 下午
 */
public class BasicBuffer {

    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(5);

        for(int i = 0; i < intBuffer.capacity(); i ++) {
            intBuffer.put(i * 2);
        }


        intBuffer.flip();


        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }



    }
}



    
