package util.pets;

public class Pug extends Dog {
    public Pug() {
        super();
    }

    public Pug(String name) {
        super(name);
    }

    public static class Factory implements
            util.factory.Factory<Pug>{
        @Override
        public Pug create() {
            return new Pug();
        }
    }
}
