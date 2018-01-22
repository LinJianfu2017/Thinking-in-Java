package com.linjianfu.chapter15;

import net.mindview.util.TwoTuple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import static net.mindview.util.Tuple.*;

public class MixinProxy39 implements InvocationHandler {
    Map<String, Object> delegatesByMethod;

    public MixinProxy39(TwoTuple<Object, Class<?>>... pairs) {
        delegatesByMethod = new HashMap<>();
        for (TwoTuple<Object, Class<?>> pair : pairs)
            for (Method method : pair.second.getClass().getMethods()) {
                String methodName = method.getName();
                if (!delegatesByMethod.containsKey(methodName))
                    delegatesByMethod.put(methodName, pair.first);
            }
    }

    @Override
    public Object invoke(Object proxy, Method method,
                         Object[] args) throws Throwable {
        String methodName = method.getName();
        Object delegate = delegatesByMethod.get(methodName);
        return method.invoke(delegate, args);
    }

    public static Object newInstance(TwoTuple... pairs) {
        Class[] interfaces = new Class[pairs.length];
        for (int i = 0; i < pairs.length; i++)
            interfaces[i] = (Class) pairs[i].second;
        ClassLoader classLoader =
                pairs[0].first.getClass().getClassLoader();
        return Proxy.newProxyInstance(classLoader, interfaces,
                new MixinProxy39(pairs));
    }
}

class Fifteen39 {
    public static void main(String[] args) {
        Object mixin = MixinProxy39.newInstance(
                tuple(new AI(), A.class),
                tuple(new CI(), C.class),
                tuple(new DI(), D.class),
                tuple(new Fifteen37(), B.class)

        );
        A a = (A) mixin;
        B b = (B) mixin;
        C c = (C) mixin;
        D d = (D) mixin;
    }
}
