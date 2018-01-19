package util.pets;

public class EgyptianMau extends Cat {
    public EgyptianMau() {
        super();
    }

    public EgyptianMau(String name) {
        super(name);
    }

    public static class Factory implements
            util.factory.Factory<EgyptianMau>{
        @Override
        public EgyptianMau create() {
            return new EgyptianMau();
        }
    }
}
