package annotation;

import java.util.concurrent.TimeUnit;

public class IWorkImpl implements IWork {

    @Override
    @ShowDuration
    public void login1() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void login2() {
       

    }

}
