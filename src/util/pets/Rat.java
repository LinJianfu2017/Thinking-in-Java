package util.pets;

public class Rat extends Rodent{
    public Rat() {
        super();
    }

    public Rat(String name) {
        super(name);
    }

    public static class Factory implements
            util.factory.Factory<Rat>{
        @Override
        public Rat create() {
            return new Rat();
        }
    }
}
