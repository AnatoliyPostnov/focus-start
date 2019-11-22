package reflection.AnnotationAndLogging;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
public class MyInvocationHandler implements InvocationHandler {
    IUser user;

    public MyInvocationHandler(IUser user){
        this.user = user;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ((MyAnnotation) method.getAnnotation(MyAnnotation.class) != null){
            System.out.println("This is method with myAnnotation!");
        }

        System.out.print("Method: ");
        System.out.println(method);
        System.out.print("Param: ");

        if (args != null) {
            for (Object arg : args) {
                System.out.println(arg.toString() + " ");
            }
        }else {
            System.out.println("null");
        }

        return method.invoke(user, args);
    }
}
