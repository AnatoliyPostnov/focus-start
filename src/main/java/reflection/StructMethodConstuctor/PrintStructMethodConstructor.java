package reflection.StructMethodConstuctor;

import collections.List;
import collections.impl.ArrayList;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PrintStructMethodConstructor<T> {
    private Class class_;
    private Field[] fields;
    private Method[] methods;
    private Constructor[] constructors;

    public PrintStructMethodConstructor(List<T> inputList){
        class_ = inputList.getClass();
        fields = class_.getDeclaredFields();
        methods = class_.getDeclaredMethods();
        constructors = class_.getDeclaredConstructors();
    }

    public void printFields(){
        System.out.println("Fields " + class_.toString() + ":");
        for (Field field:fields){
            System.out.println(field);
        }
        System.out.println();
    }

    public void printMethods(){
        System.out.println("Methods " + class_.toString() + ":");
        for (Method method:methods){
            System.out.println(method);
        }
        System.out.println();
    }

    public void printConstructors(){
        System.out.println("Constructors " + class_.toString() + ":");
        for (Constructor constructor:constructors){
            System.out.println(constructor);
        }
        System.out.println();
    }
}
