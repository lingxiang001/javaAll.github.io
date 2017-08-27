package design_model.factories;
/**
 * Human的具体实现类
 * @author lingxiang
 *
 */
public class YellowHumanImpl implements Human {

    @Override
    public void laugh() {
        System.out.println("i am yellowhuman and love laughing");
        
    }

    @Override
    public void talk() {
        System.out.println("i am yellowhuman and love talking");
        
    }

    @Override
    public void cry() {
        System.out.println("i am yellowhuman and hate cry");
        
    }

}
