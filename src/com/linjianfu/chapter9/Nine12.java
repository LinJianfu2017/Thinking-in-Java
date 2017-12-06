package com.linjianfu.chapter9;

interface CanFight {
    void fight();
}

interface CanSwim {
    void swim();
}

interface CanFly {
    void fly();
}

interface CanClimb {
    void climb();
}

class Sun {
    public void climb() {
        System.out.println("Sun.climb()");
    }
}

class ActionCharacter extends Sun {
    public void fight() {
        System.out.println("ActionCharacter.fight()");
    }
}

class Hero extends ActionCharacter
        implements CanFight, CanSwim, CanFly, CanClimb {
    public void swim() {
        System.out.println("Hero.swim()");
    }

    public void fly() {
        System.out.println("Hero.fly()");
    }
}

public class Nine12 {
    private static void a(CanFight canFight) {
        canFight.fight();
    }

    private static void e(CanSwim canSwim) {
        canSwim.swim();
    }

    private static void i(CanFly canFly) {
        canFly.fly();
    }

    private static void o(CanClimb canClimb) {
        canClimb.climb();
    }

    private static void u(Sun sun) {
        sun.climb();
    }

    private static void jj(ActionCharacter actionCharacter) {
        actionCharacter.fight();
    }

    public static void main(String[] args) {
        Hero hero = new Hero();
        a(hero);
        e(hero);
        i(hero);
        o(hero);
        u(hero);
        jj(hero);
    }

}
