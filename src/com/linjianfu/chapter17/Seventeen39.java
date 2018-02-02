package com.linjianfu.chapter17;

import net.mindview.util.Countries;
import net.mindview.util.Generator;
import net.mindview.util.MapData;
import net.mindview.util.RandomGenerator;

import static net.mindview.util.Print.print;

public class Seventeen39 {
    public static <T> void capacityTxt(SimpleHashMap shm,
                                       Generator<T> gen, int quantity) {
        shm.putAll(MapData.map(gen, gen, quantity));
        print("after putAll(): quantity = " + quantity);
        print("size() = " + shm.size());
        print("capacity() = " + shm.getCapacity());

    }

    public static void main(String[] args) {
        RandomGenerator.Integer rgi = new RandomGenerator.Integer(10000);
        print("Testing map m of <String,String>: the basics:");
        SimpleHashMap<String, String> m = new SimpleHashMap<>();
        m.putAll(Countries.capitals(10));
        print("m.get(\"CHAD\") " + m.get("CHAD"));
        print("m.size() = " + m.size());
        print("m.capacity() = " + m.getCapacity());
        print("Testing rehash() for a map of <Integer,Integer>:");
        SimpleHashMap<Integer, Integer> m2 = new SimpleHashMap<>();
        print("before:\n" + m2);
        print("size() = " + m2.size());
        print("capacity() = " + m2.getCapacity());
        capacityTxt(m2, rgi, 500);
        capacityTxt(m2, rgi, 2000);
        capacityTxt(m2, rgi, 5000);
    }
}
/**
 * Testing map m of <String,String>: the basics:
 * m.get("CHAD") N'djamena
 * m.size() = 10
 * m.capacity() = 997
 * Testing rehash() for a map of <Integer,Integer>:
 * m2: {}
 * m2.size() = 0
 * m2.capacity() = 997
 * after putAll(): quantity = 500
 * size() = 492
 * capacity() = 997
 * after putAll(): quantity = 2000
 * size() = 2217
 * capacity() = 4001
 * after putAll(): quantity = 5000
 * size() = 5308
 * capacity() = 8009
 * <p>
 * Process finished with exit code 0
 */