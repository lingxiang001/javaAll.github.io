package ALiBaBa.tianmao;

public interface Order {
    
    /**
     * 创建订单
     */
    boolean creatOrder(User user ,Box box);
    /**
     * 扣减用户积分
     */
    boolean jianJiFen(User use);
    /**
     *扣减魔盒库存
     */
    boolean jianMohe(Box bo);
    /**
     * 下单成功
     */
    boolean isSuccess(User user,Box box);
     
     
   

}
