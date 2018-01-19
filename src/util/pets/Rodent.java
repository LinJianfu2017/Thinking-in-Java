package util.pets;

public class Rodent extends Pet {
    public Rodent() {
        super();
    }

    public Rodent(String name) {
        super(name);
    }

    public static class Factory implements
            util.factory.Factory<Rodent> {
        @Override
        public Rodent create() {
            return new Rodent();
        }
    }
}
