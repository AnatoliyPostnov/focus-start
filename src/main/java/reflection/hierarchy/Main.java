package reflection.hierarchy;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        thirdClass testClass = new thirdClass();
        Class cl = testClass.getClass();
        while (cl != null){
            System.out.println(cl.getName());
            System.out.println(Arrays.toString(cl.getInterfaces()));
            cl = cl.getSuperclass();
        }

        cl = testClass.getClass();
        cl.getField("publicParam").set(testClass, 5);
        System.out.print("publicParam: ");
        System.out.println(testClass.publicParam);

        Field privateField = cl.getDeclaredField("privateParam");
        privateField.setAccessible(true);
        privateField.set(testClass, 5);
        System.out.print("privateParam: ");
        System.out.println(testClass.getParam());
    }
}
