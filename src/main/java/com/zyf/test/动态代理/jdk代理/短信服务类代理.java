package com.zyf.test.动态代理.jdk代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * InvocationHandler是代理实例的调用处理器实现的接口。
 * 每个代理实例都有一个关联的调用处理器。
 * 在调用代理实例的方法时，方法调用将被编码并分派给其调用处理程序的 invoke 方法。
 */
public class 短信服务类代理<T> implements InvocationHandler {

    public 短信服务类代理(T proxyObject) {
        this.proxyObject = proxyObject;
    }

    /**
     * 被代理的对象
     */
    private T proxyObject;

    public T getProxy() {
        Class<?> aClass = proxyObject.getClass();
        /**
         * 返回一个受调用处理器 (InvocationHandler) 管理，实现了指定接口的代理类的实例
         *
         * @param   loader 声明这个代理类的 ClassLoader
         * @param   interfaces 代理类实现的接口列表
         * @param   h 处理代理类的调用的调用处理器
         * @return 一个受调用处理器 (InvocationHandler) 管理，实现了指定接口的代理类的实例
         * @throws IllegalArgumentException 违反了 getProxyClass 函数的参数限制条件
         * @throws SecurityException 如果安全管理器存在并且下面的任意条件满足：
         *               (1) 传入的 loader 是 null 且调用者的类加载器非空，
         *               使用 RuntimePermission("getClassLoader")权限
         *               调用 SecurityManager#checkPermission禁止访问
         *
         *               (2) 对于每一个代理接口，调用者的类加载器与接口类加载器不同或不是其父类,
         *               并且调用 SecurityManager#checkPackageAccess 无权访问接口
         *
         *               (3) 所有传入的代理接口都是非公共的，且调用者类与非公共接口不在同一个包下，
         *               使用 ReflectPermission("newProxyInPackage.{package name}") 调用
         *               SecurityManager#checkPermission 无访问权限
         * @throws NullPointerException interfaces 数组参数或其中的元素为 null，以及调用处理器 h 为 null
         */
        return (T) Proxy.newProxyInstance(aClass.getClassLoader(), aClass.getInterfaces(), this);
    }

    /**
     * 在代理实例上处理方法调用并返回结果。当在与其关联的代理实例上调用
     * 方法时，将调用处理期上的此方法。
     * @param proxy 该方法被调用的代理实例
     * @param method Method 对象将是代理接口声明的方法，它可能是代理
     * 类继承方法的代理接口的超级接口。
     * @param args 包含在代理实例的方法调用中传递的参数值的对象数组，
     * 如果interface方法不带参数，则为null。基本类型的参
     * 数被封装在适当的基本封装类的实例中，比如
     * java.lang.Integer 或者 java.lang.Boolean。
     * @return 调用代理实例上的方法获得的返回值。如果接口方法的声明返
     * 回类型是基本类型，则此方法返回的值必须是相应基本包装类
     * 的实例;否则，它必须是转换为声明的返回类型的类型。如果
     * 此方法返回的值为null，并且接口方法的返回类型为原始类型，
     * 则代理实例上的方法调用将引发NullPointerException。如果
     * 此方法返回的值与上面所述的接口方法的声明返回类型不兼容，
     * 则将通过代理实例上的方法调用抛出ClassCastException。
     * @throws Throwable 抛出调用代理实例的方法时抛出的异常。异常的类型必须可以
     * 转化为接口方法的 throws 子句中声明的异常类型，也可以分
     * 配给不强制检查的异常类型 java.lang.RuntimeException 或
     * java.lang.Error。如果这个方法抛出一个强制检查的异常，
     * 这个异常不能转化为接口方法的 throws 子句中声明的异常类
     * 型，那么将会抛出包含这个异常的
     * UndeclaredThrowableException 异常。
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("---------------------------------start");
        Object invoke = method.invoke(proxyObject, args);
        System.out.println("---------------------------------end");
        return invoke;
    }

}
