package util.pets;

public class Manx extends Cat {
    public Manx() {
        super();
    }

    public Manx(String name) {
        super(name);
    }

    public static class Factory implements
            util.factory.Factory<Manx>{
        @Override
        public Manx create() {
            return new Manx();
        }
    }
}
