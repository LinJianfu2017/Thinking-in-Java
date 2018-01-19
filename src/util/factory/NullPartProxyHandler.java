package util.factory;

import com.linjianfu.chapter14.Fourteen24;
import util.Null;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class NullPartProxyHandler implements InvocationHandler {
    private static String nullname;
    private static final Part NULL = new NullPart();

    public NullPartProxyHandler(Class<? extends Part> part) {
        nullname = part.getSimpleName();
    }

    public static class NullPart extends Part implements Null {
        public NullPart() {
            super();
        }

        @Override
        public String toString() {
//            return nullname + " NULL";
            return "NULL";
        }

        public static class Factory implements util.factory.Factory<Part> {
            @Override
            public NullPart create() {
                return (NullPart) NULL;

            }
        }

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(NULL, args);
    }

    /////////////////////////////////////////////////////////////
    public static Part newNullPart(Class<? extends Part> part) {
        return (Part) Proxy.newProxyInstance(
                Fourteen24.class.getClassLoader(),
                new Class[]{Null.class},
                new NullPartProxyHandler(part)
        );
    }

    public static void main(String[] args) {
        Part[] parts = {
                new CabinAirFilter(), newNullPart(GeneratorBelt.class),
                new PowerSteeringBelt(), new FanBelt(),
        };
        for (Part part : parts) {
            //！！！没实现Factory，白忙活。。。
        }
    }

}
