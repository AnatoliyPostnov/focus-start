package reflection.AnnotationAndLogging;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args){
        User user = new User("Anatoliy", "Postnov");
        IUser userProxy = (IUser) Proxy.newProxyInstance(
                User.class.getClassLoader(),
                User.class.getInterfaces(),
                new MyInvocationHandler(user)
        );
        System.out.println(userProxy.getName());
        System.out.println(userProxy.getLastName());
        userProxy.setName("Misha");
        userProxy.setLastName("Popov");
    }
}
