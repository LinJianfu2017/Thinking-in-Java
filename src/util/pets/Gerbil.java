package util.pets;

public class Gerbil extends Rodent {
    public Gerbil() {
        super();
    }

    public Gerbil(String name) {
        super(name);
    }

    public static class Factory implements
            util.factory.Factory<Gerbil> {
        @Override
        public Gerbil create() {
            return new Gerbil();
        }
    }
}
