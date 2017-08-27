package ALiBaBa.tianmao;

public class test {
    public static void main(String[] ars){
        OrderImpt op=new OrderImpt();
        User user=new User();
        Box box=Box.getBox();
       boolean b=op.isSuccess(user, box);
       System.out.println(b);
       }
 
}
/**
 * 天猫双十一有个积分换墨盒的活动，总共有50万台天猫魔盒（box），每个用户（user）可以用99个天猫积分（point）兑换一台魔盒，且每人限换一台。 请设计一套java接口并实现下单（order）逻辑。 参考（但不局限于）下面的下单逻辑： 
1、创建订单  
2、扣减用户积分 
3、扣减魔盒库存 
4、下单成功 
同时请回答：  
1、数据库表结构如何设计，有哪些表，分别有什么作用？ 
2、下单过程中哪些地方可能成为瓶颈？如何解决或改善？  
3、是否会用到数据库事务，哪些地方会用到？如果不用数据库事务，如何保证数据的一致性？

 */
/**
 *数据库表设计三个表：用户表，字段有用户编号，用户积分，用户魔盒数量；
 *                              魔盒表，字段有魔盒数量，魔盒总数
 *                              订单表：字段有用户编号，订单编号
 * 下单过程中的瓶颈：
 *          所有用户下单时都需要对魔盒信息表进行写入，需要对其进行加锁。改善方法：可以把魔盒分成
 *          n个表，将用户的ip地址的hash%n，将其分配到对应的魔盒表处理，若魔盒表的数量用完，则要标记该表不可用，需重新分配。
 * 事务
 * 需要用到事务，下单过程中会对用户积分和用户魔盒数，及魔盒表的魔盒剩余数进行改变，需要事务来保证数据的一致性。
 * 如果不用事务就需要代码来完善。
 */