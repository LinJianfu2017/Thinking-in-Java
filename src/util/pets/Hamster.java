package util.pets;

public class Hamster extends Rodent {
    public Hamster() {
        super();
    }

    public Hamster(String name) {
        super(name);
    }

    public static class Factory implements
            util.factory.Factory<Hamster>{
        @Override
        public Hamster create() {
            return new Hamster();
        }
    }
}
