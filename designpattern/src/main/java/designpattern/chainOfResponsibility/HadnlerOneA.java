package designpattern.chainOfResponsibility;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * @author jiazhiyuan
 * @date 2021/11/14 11:46 上午
 */
public class HadnlerOneA extends HadnlerOne {

    @Override
    public void handle() {
        boolean handled = false;
        //...
        if(!handled && successor != null) {
            successor.handle();
        }
    }
}



    
