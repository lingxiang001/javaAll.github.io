package bigdata;

import java.util.Random;
/**
 * 随即生成字符串类
 * @author lingxiang
 *
 */
public class RandomUtil {
    public static String randomString(){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random=new Random();
        StringBuffer sb=new StringBuffer(" ");
        for(int i=0;i<5;i++){
            int num=random.nextInt(52);
            sb.append(str.charAt(num));
        }
       
        return sb.toString();
    }
    public static void main(String[] args) {
    }

}
