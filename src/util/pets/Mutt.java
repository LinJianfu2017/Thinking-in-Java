package util.pets;

public class Mutt extends Dog{
    public Mutt() {
        super();
    }

    public Mutt(String name) {
        super(name);
    }

    public static class Factory implements
            util.factory.Factory<Mutt>{
        @Override
        public Mutt create() {
            return new Mutt();
        }
    }
}
