package util.pets;

public class Mouse extends Rodent {
    public Mouse() {
        super();
    }

    public Mouse(String name) {
        super(name);
    }

    public static class Factory implements
            util.factory.Factory<Mouse>{
        @Override
        public Mouse create() {
            return new Mouse();
        }
    }
}
