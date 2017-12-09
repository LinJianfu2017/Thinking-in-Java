package com.linjianfu.chapter10;

import java.util.ArrayList;
import java.util.List;

public class Ten25 {
    public static void main(String[] args) {
        String[] a = new String[0];
        GreenhouseController25.main(a);
    }
}

class GreenhouseController25 {
    public static void main(String[] args) {
        GreenhouseControls25 gc = new GreenhouseControls25();
        gc.new Bell25(1);
        Event25[] events = {
                gc.new ThermostatNight(2),
                gc.new LightUp(3),
                gc.new WaterJetOn(4),
                gc.new WaterJetOff(5),
                gc.new LightDown(6),
                gc.new WaterUp(7),
                gc.new WaterDown(8),
                gc.new ThermostatDay(9),
        };
        gc.addEvent25(gc.new Restart(10, events));
        if (args.length == 0) {
            gc.addEvent25(new GreenhouseControls25.Terminating25(9));
            gc.run25();
        }
    }

}

abstract class Event25 {
    private long eventTime25;
    protected final long delayTime;

    Event25(long delayTime) {
        this.delayTime = delayTime;
        start25();
    }

    public void start25() {
        eventTime25 = System.nanoTime() + delayTime;
    }

    public boolean ready() {
        return System.nanoTime() >= eventTime25;
    }

    public abstract void action25();
}

class Controller25 {
    private List<Event25> eventList25 = new ArrayList<>();

    public void addEvent25(Event25 event) {
        eventList25.add(event);
    }

    public void run25() {
        while (eventList25.size() > 0)
            for (Event25 event : new ArrayList<>(eventList25)) {
                if (event.ready()) {
                    System.out.println(event);
                    event.action25();
                    eventList25.remove(event);
                }
            }

    }
}

class GreenhouseControls25 extends Controller25 {
    private boolean light = false;

    class LightUp extends Event25 {
        LightUp(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action25() {
            light = true;
        }

        @Override
        public String toString() {
            return "Light Up";
        }
    }

    class LightDown extends Event25 {
        LightDown(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action25() {
            light = false;
        }

        @Override
        public String toString() {
            return "Light down";
        }
    }

    private boolean water = false;

    class WaterUp extends Event25 {
        WaterUp(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action25() {
            water = true;
        }

        @Override
        public String toString() {
            return "Water up";
        }
    }

    class WaterDown extends Event25 {
        WaterDown(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action25() {
            water = false;
        }

        @Override
        public String toString() {
            return "Water down";
        }
    }

    private String Thermostat = "Day";

    class ThermostatNight extends Event25 {
        ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action25() {
            Thermostat = "Night";
        }

        @Override
        public String toString() {
            return "Thermostat on night setting";
        }
    }

    class ThermostatDay extends Event25 {
        ThermostatDay(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action25() {
            Thermostat = "Day";
        }

        @Override
        public String toString() {
            return "Thermostat on day setting";
        }
    }

    class Bell25 extends Event25 {
        Bell25(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action25() {
            addEvent25(new Bell25(delayTime));
        }

        @Override
        public String toString() {
            return "Bing...........";
        }
    }

    class Restart extends Event25 {
        private Event25[] events;

        Restart(long delayTime, Event25[] events) {
            super(delayTime);
            this.events = events;
            for (Event25 event : events)
                addEvent25(event);
        }

        @Override
        public void action25() {
            for (Event25 event : events) {
                event.start25();
                addEvent25(event);
            }
            start25();
            addEvent25(this);

        }

        @Override
        public String toString() {
            return "Restarting system...";
        }
    }

    static class Terminating25 extends Event25 {
        Terminating25(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action25() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Terminating";
        }
    }

    private boolean waterjet = false;

    class WaterJetOn extends Event25 {
        WaterJetOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action25() {
            waterjet = true;
        }

        @Override
        public String toString() {
            return "Water jet generator on";
        }
    }

    class WaterJetOff extends Event25 {
        WaterJetOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action25() {
            waterjet = false;
        }

        @Override
        public String toString() {
            return "Water jet generator off";
        }
    }
}