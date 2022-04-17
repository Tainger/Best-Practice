package optionaldemo;

import base.User;

import java.util.Optional;

/**
 * @author jiazhiyuan
 * @date 2022/2/17 1:33 下午
 */
public class OptionalDemo1 {


    public static void main(String[] args) {
        User user = new User();
        user.setUserName("贾志远");
        user.setPassword("贾志远");
        Optional<User> optional = Optional.ofNullable(null);
        User res = optional.orElse(new User("hha", "heihei"));
        System.out.println(res);

    }
}



    
