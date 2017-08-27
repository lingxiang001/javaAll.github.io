package design_model.factories;
/**
 * Human的具体实现类
 * @author lingxiang
 *
 */
public class WhiteHumanImpl implements Human{

    @Override
    public void laugh() {
        System.out.println("i am whitehuman and love laughing");
    }

    @Override
    public void talk() {
        System.out.println("i am whitehuman and love talking");
    }

    @Override
    public void cry() {
        System.out.println("i am whitehuman and hate cry");
    }

}
