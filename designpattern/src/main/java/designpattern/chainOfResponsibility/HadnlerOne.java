package designpattern.chainOfResponsibility;

/**
 * @author jiazhiyuan
 * @date 2021/11/14 11:42 上午
 */
public abstract class HadnlerOne {

    protected HadnlerOne successor = null;

    public void setSuccessor(HadnlerOne successor) {
        this.successor = successor;
    }

    public abstract void handle();

}



    
