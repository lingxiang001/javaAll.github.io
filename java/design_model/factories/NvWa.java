package design_model.factories;

public class NvWa {

    public static void main(String[] args) {
        Human whiteHuman=HumanFactory.creatHuman(WhiteHumanImpl.class);
        whiteHuman.cry();
        Human yellowHuman=HumanFactory.creatHuman(YellowHumanImpl.class);
        yellowHuman.laugh();
        

    }

}
