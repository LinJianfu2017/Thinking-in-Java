package com.linjianfu.chapter19;

import java.util.EnumMap;
import java.util.Map;

import static net.mindview.util.Print.print;


interface Handler {
    boolean handle(Mail m);
}

public class Nineteen9 {
    enum MailHandler {GENERAL_DELIVERY, MACHINE_SCAN, VISUAL_INSPECTION, RETURN_TO_SENDER}

    public static void handle(Mail m, EnumMap<MailHandler, Handler> em) {
        for (Map.Entry<MailHandler, Handler> e : em.entrySet()) {
            if (e.getValue().handle(m)) return;
        }
        print(m + " is a dead letter");
    }

    public static void main(String[] args) {
        EnumMap<MailHandler, Handler> em = new EnumMap<>(MailHandler.class);
        em.put(MailHandler.GENERAL_DELIVERY, new Handler() {
            public boolean handle(Mail m) {
                switch (m.generalDelivery) {
                    case YES:
                        print("Using general delivery for " + m);
                        return true;
                    default:
                        return false;
                }
            }
        });
        em.put(MailHandler.MACHINE_SCAN, new Handler() {
            public boolean handle(Mail m) {
                switch (m.scannability) {
                    case UNSCANNABLE:
                        return false;
                    default:
                        switch (m.address) {
                            case INCORRECT:
                                return false;
                            default:
                                print("Delivering " + m + " automatically");
                                return true;
                        }
                }
            }
        });
        em.put(MailHandler.VISUAL_INSPECTION, new Handler() {
            public boolean handle(Mail m) {
                switch (m.readability) {
                    case ILLEGIBLE:
                        return false;
                    default:
                        switch (m.address) {
                            case INCORRECT:
                                return false;
                            default:
                                print("Delivering " + m + " normally");
                                return true;
                        }
                }
            }
        });
        em.put(MailHandler.RETURN_TO_SENDER, new Handler() {
            public boolean handle(Mail m) {
                switch (m.returnAddress) {
                    case MISSING:
                        return false;
                    default:
                        print("Return " + m + " to sender");
                        return true;
                }
            }
        });
        for (Mail mail : Mail.generator(10)) {
            print(mail.details());
            handle(mail, em);
            print("*****");
        }
    }
}

