package util;

import java.util.HashMap;
import java.util.Map;

public class ClassTypeCapture<T> {
    private Class<T> kind;

    private Map<String, Class<?>> map = new HashMap<>();

    public ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }

    public ClassTypeCapture(Class<T> kind, Map<String, Class<?>> map) {
        this.kind = kind;
        this.map = map;
    }

    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }

    public void addType(String typeName, Class<?> kind) {
        map.put(typeName, kind);
    }

    public Object createNew(String typeName) throws IllegalAccessException,
            InstantiationException {
        if (map.containsKey(typeName))
            return map.get(typeName).newInstance();
        System.out.println(typeName + " class not available");
        return null;
    }

    public static void main(String[] args) {
        ClassTypeCapture<House> classTypeCapture =
                new ClassTypeCapture<>(House.class);
        classTypeCapture.addType("House", House.class);
        //如果Class<?> kind-->Class<? extends T>,那下面这句就会编译期类型报错：
        classTypeCapture.addType("Building", Building.class);
        try {
            classTypeCapture.createNew("Building");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Building {
    public Building() {
        System.out.println("Building");
    }
}

class House {
    public House() {
        System.out.println("House");
    }
}
