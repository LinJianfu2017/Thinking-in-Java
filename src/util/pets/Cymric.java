package util.pets;

public class Cymric extends Manx {
    public Cymric() {
        super();
    }

    public Cymric(String name) {
        super(name);
    }
    public static class Factory implements
            util.factory.Factory<Cymric>{
        @Override
        public Cymric create() {
            return new Cymric();
        }
    }
}
