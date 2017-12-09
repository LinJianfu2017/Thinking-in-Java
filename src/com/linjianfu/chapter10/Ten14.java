package com.linjianfu.chapter10;

interface Monster {
    void menace();
}

interface DangerousMonster extends Monster {
    void destroy();
}

interface Lethal {
    void kill();
}

interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();
}

public class Ten14 {
    DangerousMonster dangerousMonster() {
        return new DangerousMonster() {
            @Override
            public void destroy() {

            }

            @Override
            public void menace() {

            }
        };
    }

    Vampire vampire = new Vampire() {
        @Override
        public void drinkBlood() {

        }

        @Override
        public void destroy() {

        }

        @Override
        public void kill() {

        }

        @Override
        public void menace() {

        }
    };

    //    static void u(Monster monster){
//        monster.menace();
//    }
    static void v(DangerousMonster dangerousMonster) {
        dangerousMonster.menace();
        dangerousMonster.destroy();
    }

    //    static void w(Lethal lethal){
//        lethal.kill();
//    }
    static void x(Vampire vampire) {
        vampire.drinkBlood();
        vampire.kill();
        vampire.destroy();
        vampire.menace();
    }

    public static void main(String[] args) {
        Ten14 ten14 = new Ten14();
        x(ten14.vampire);
        v(ten14.dangerousMonster());

    }
}
