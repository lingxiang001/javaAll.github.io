package annotation;

public interface IWork {
    @ShowDuration
    void login1();
    @ShowDuration(false)
    void login2();
    

}
