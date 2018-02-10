package com.linjianfu.chapter19;

import net.mindview.util.Generator;
import net.mindview.util.TextFile;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

import static com.linjianfu.chapter19.Input.*;
import static net.mindview.util.Print.print;


public class Nineteen10 {
    private int id = ++count;
    private static int count = 0;
    private State state = State.RESTING;
    private int amount = 0;
    private int banked = 0;
    private Input input = null;
    private Input selection = null;
    private boolean isTransient = false;

    class RestingDo implements Command {
        public void next(Input in) {
            isTransient = false;
            input = in;
            switch (Category.categorize(in)) {
                case MONEY:
                    amount += in.amount();
                    state = State.ADDING_MONEY;
                    break;
                case SHUT_DOWN:
                    state = State.TERMINAL;
                default:
            }
        }

        public void next() {
            isTransient = false;
        }
    }

    class AddingMoneyDo implements Command {
        public void next(Input input) {
            isTransient = false;
            switch (Category.categorize(input)) {
                case MONEY:
                    amount += input.amount();
                    break;
                case ITEM_SELECTION:
                    selection = input;
                    if (amount < selection.amount()) {
                        print("Insufficient money for " + selection);
                    } else {
                        state = State.DISPENSING;
                        isTransient = true;
                    }
                    break;
                case QUIT_TRANSACTION:
                    state = State.GIVING_CHANGE;
                    isTransient = true;
                    break;
                case SHUT_DOWN:
                    state = State.TERMINAL;
                    banked += amount;
                default:
            }
        }

        public void next() {
            isTransient = false;
        }
    }

    class DispensingDo implements Command {
        public void next() {
            isTransient = true;
            print("Here is your " + selection);
            state = State.GIVING_CHANGE;
        }

        public void next(Input input) {
            isTransient = true;
            print("Here is your " + selection);
            state = State.GIVING_CHANGE;
        }
    }

    class GivingChangeDo implements Command {
        public void next(Input input) {
            isTransient = true;
            if (amount > selection.amount()) {
                print("Your change: " +
                        (amount - selection.amount()));
            }
            banked += selection.amount();
            amount = 0; // reset
            state = State.RESTING;
        }

        public void next() {
            isTransient = true;
            if (amount < selection.amount())
                print("Returning your: " + amount);
            if (amount > selection.amount()) {
                print("Your change: " +
                        (amount - selection.amount()));
                banked += selection.amount();
            }
            if (amount == selection.amount())
                banked += selection.amount();
            amount = 0;
            state = State.RESTING;
        }
    }

    class TerminalDo implements Command {
        public void next(Input input) {
            print("state TERMINAL");
            isTransient = false;
        }

        public void next() {
            print("state TERMINAL");
            isTransient = false;
        }
    }

    Map<State, Command> em =
            Collections.synchronizedMap(new EnumMap<State,
                    Command>(State.class));

    private Nineteen10() {
        print("VendingMachine10()#" + id);
        em.put(State.RESTING, new RestingDo());
        em.put(State.ADDING_MONEY, new AddingMoneyDo());
        em.put(State.DISPENSING, new DispensingDo());
        em.put(State.GIVING_CHANGE, new GivingChangeDo());
        em.put(State.TERMINAL, new TerminalDo());
    }

    private void showAmount() {
        print("amount = " + amount);
    }

    private void showBanked() {
        print("banked = " + banked);
    }

    static class RandomInputGenerator implements Generator<Input> {
        @Override
        public Input next() {
            return Input.randomSelection();
        }
    }

    public static void main(String[] args) {
        Generator<Input> gen = new RandomInputGenerator();
        if (args.length == 1)
            gen = new FileInputGenerator10(args[0]);
        Nineteen10 nt = new Nineteen10();
        print();
        int times = 20;
        while (nt.state != State.TERMINAL) {
            Input in = gen.next();
            (nt.em.get(nt.state)).next(in);
            while (nt.isTransient) {
                if (nt.state != null)
                    (nt.em.get(nt.state)).next();
            }
            nt.showAmount();
            if (--times < 0)
                break;
        }
        nt.showBanked();
        print();
    }
}

enum Category {
    MONEY(NICKEL, DIME, QUARTER, DOLLAR),
    ITEM_SELECTION(TOOTHPASTE, CHIPS, SODA, SOAP),
    QUIT_TRANSACTION(ABORT_TRANSACTION),
    SHUT_DOWN(STOP);
    private Input[] values;

    Category(Input... types) {
        values = types;
    }

    private static EnumMap<Input, Category> categories =
            new EnumMap<>(Input.class);

    static {
        for (Category c : Category.class.getEnumConstants())
            for (Input type : c.values)
                categories.put(type, c);
    }

    public static Category categorize(Input input) {
        return categories.get(input);
    }
}

interface Command {
    void next(Input input);

    void next();
}

enum State {
    RESTING,
    ADDING_MONEY,
    DISPENSING,
    GIVING_CHANGE,
    TERMINAL
}

class FileInputGenerator10 implements Generator<Input> {
    private Iterator<String> input;

    protected FileInputGenerator10(String fileName) {

        input = new TextFile(fileName, ";").iterator();
    }

    public Input next() {
        if (input.hasNext()) {
            return Enum.valueOf(Input.class, input.next().trim());
        }
        return null;
    }
}


