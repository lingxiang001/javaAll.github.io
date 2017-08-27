package ALiBaBa.tianmao;

public class OrderImpt implements Order {

    @Override
    public boolean creatOrder(User user ,Box box) {
        if(user == null || box ==null){
            return false;
        }
        if(user.getCount()>=99 && box.getCount()>0){
            return true;
        }
        return false;
     
    }

    @Override
    public boolean jianJiFen(User user ) {
       if(user == null){
            return false;
        }
       int pointer=user.getPoint();
       if(pointer>=99 && user.getCount()==0){
           pointer=pointer-99;
           user.setPoint(pointer);
           user.setCount(1);
           return true;
       }
       return false;

    }

    @Override
    public boolean jianMohe(Box box) {
        if(box == null){
            return false ;
        }
        int count=box.getCount();
        if(count>0){
            box.setCount(count-1);
            return true;
        }
        return false;
    }

    @Override
    public boolean isSuccess(User user,Box box) {
      if(creatOrder(user,box))
          if(jianJiFen(user))
              if(jianMohe(box)){
                  return true;
              }
              
        return false;
    }
}
