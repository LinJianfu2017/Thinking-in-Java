package util.pets;

public class Dog extends Pet {
    public Dog() {
        super();
    }

    public Dog(String name) {
        super(name);
    }

    public static class Factory implements
            util.factory.Factory<Dog> {
        @Override
        public Dog create() {
            return new Dog();
        }
    }
}
