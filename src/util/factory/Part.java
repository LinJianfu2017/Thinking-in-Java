package util.factory;

import java.util.*;

public class Part {
    @Override
    public String toString() {
        return getClass().getSimpleName();
    }

    private static List<Factory<? extends Part>> partFactories =
            new ArrayList<>();

    static {
        partFactories.add(new FuelFilter.Factory());
        partFactories.add(new AirFilter.Factory());
        partFactories.add(new CabinAirFilter.Factory());
        partFactories.add(new OilFilter.Factory());
        partFactories.add(new FanBelt.Factory());
        partFactories.add(new PowerSteeringBelt.Factory());
        partFactories.add(new GeneratorBelt.Factory());
    }

    private static Random rand = new Random(47);

    public static Part createRandom() {
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }

    private static List<Class<? extends Part>> partClasses = new ArrayList<>();

    static {
        partClasses.add(FuelFilter.class);
        partClasses.add(AirFilter.class);
        partClasses.add(CabinAirFilter.class);
        partClasses.add(OilFilter.class);
        partClasses.add(FanBelt.class);
        partClasses.add(PowerSteeringBelt.class);
        partClasses.add(GeneratorBelt.class);
    }

    public static Part create() {
        int n = rand.nextInt(partClasses.size());
        try {
            return partClasses.get(n).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Class<? extends Part>> partClasses2 = Arrays.asList(FuelFilter.class,
            AirFilter.class, CabinAirFilter.class, OilFilter.class,
            FanBelt.class, PowerSteeringBelt.class, GeneratorBelt.class);

    public static Part create2() {
        int n = rand.nextInt(partClasses.size());
        try {
            return partClasses2.get(n).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //generic array creation:
//    static Class<? extends Part>[] partClasses3 = {FuelFilter.class,
//            AirFilter.class, CabinAirFilter.class, OilFilter.class,
//            FanBelt.class, PowerSteeringBelt.class, GeneratorBelt.class
//    };


}

class Filter extends Part {
}

class FuelFilter extends Filter {
    public static class Factory implements
            util.factory.Factory<FuelFilter> {
        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}

class AirFilter extends Filter {
    public static class Factory implements
            util.factory.Factory<AirFilter> {
        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}

class CabinAirFilter extends Filter {
    public static class Factory implements
            util.factory.Factory<CabinAirFilter> {
        @Override
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}

class OilFilter extends Filter {
    public static class Factory implements
            util.factory.Factory<OilFilter> {
        @Override
        public OilFilter create() {
            return new OilFilter();
        }
    }
}

class Belt extends Part {
}

class FanBelt extends Belt {
    public static class Factory implements
            util.factory.Factory<FanBelt> {
        @Override
        public FanBelt create() {
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt {
    public static class Factory implements
            util.factory.Factory<GeneratorBelt> {
        @Override
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

class PowerSteeringBelt extends Belt {
    public static class Factory implements
            util.factory.Factory<PowerSteeringBelt> {
        @Override
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}