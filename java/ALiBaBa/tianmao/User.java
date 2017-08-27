package ALiBaBa.tianmao;

public class User {
    private String id;//编号
    private Integer point;//积分
    private Integer count;//魔盒数量
    
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public User(String id, Integer point, Integer count) {
        super();
        this.id = id;
        this.point = point;
        this.count = count;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    /**
     * 返回剩余积分
     * @return
     */
    public Integer getPoint() {
        return point;
    }
    /**
     * 设置剩余积分
     * @param point
     */
    public void setPoint(Integer point) {
        this.point = point;
    }
    /**
     * 返回魔盒数
     * @return
     */
    public Integer getCount() {
        return count;
    }
    /**
     * 设置魔盒数
     * @param count
     */
    public void setCount(Integer count) {
        this.count = count;
    }
   

    
}
