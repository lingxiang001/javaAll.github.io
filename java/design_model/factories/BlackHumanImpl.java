package design_model.factories;
/**
 * Human的具体实现类
 * @author lingxiang
 *
 */
public class BlackHumanImpl implements Human {

    @Override
    public void laugh() {
        System.out.println("i am blackhuman and love laughing");
        
    }

    @Override
    public void talk() {
        System.out.println("i am blackhuman and love talking");
        
    }

    @Override
    public void cry() {
        System.out.println("i am blackhuman and hate cry");
        
    }

}
