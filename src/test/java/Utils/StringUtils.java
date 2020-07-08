package Utils;

import java.util.UUID;

public class StringUtils {

    public static String getRandomEmailAddress(){
        String email = UUID.randomUUID().toString().substring(0,14)+"mailnasia.com";
        return email;
    }

    public void main(String[] args){
        System.out.println(getRandomEmailAddress());
    }
}
