package util.pets;

public class Cat extends Pet {
    public Cat() {
        super();
    }

    public Cat(String name) {
        super(name);
    }
    public static class Factory implements
            util.factory.Factory<Cat>{
        @Override
        public Cat create() {
            return new Cat() ;
        }
    }
}
