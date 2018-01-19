package util.pets;

public class Pet extends Individual {
    public Pet() {
        super();
    }

    public Pet(String name) {
        super(name);
    }

    public static class Factory implements
            util.factory.Factory<Pet>{
        @Override
        public Pet create() {
            return new Pet();
        }
    }
}
