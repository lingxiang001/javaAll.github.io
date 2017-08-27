package design_model.factories;

public class HumanFactory {
    public static Human creatHuman(Class c){
        Human human=null;
        try {
            human=(Human)Class.forName(c.getName()).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return human;
    }

}
