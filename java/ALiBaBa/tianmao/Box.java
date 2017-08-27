package ALiBaBa.tianmao;

public class Box {
    private static Box box=null;
    private Integer count;//魔盒剩余数量 
    private Box() {}
    public static Box getBox(){
        if(box==null){
            synchronized(box.getClass()){
                if(box==null){
                    box=new Box();
                }
            }
        }
        return box;
    }
       
 
   /**
    * 返回剩余数量 
    * @return
    */
    public Integer getCount() {
        return count;
    }
    /**
     * 设置剩余数量
     * @param count
     */
    public void setCount(Integer count) {
        this.count = count;
    }
    
    

}
