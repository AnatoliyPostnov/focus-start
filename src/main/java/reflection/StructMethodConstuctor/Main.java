package reflection.StructMethodConstuctor;

import collections.impl.ArrayList;

public class Main {
    public static void main(String[] args){
        PrintStructMethodConstructor<String> printStructMethodConstructor =
                new PrintStructMethodConstructor<>(new ArrayList<String>());
//        PrintStructMethodConstructor<String> printStructMethodConstructor =
//                new PrintStructMethodConstructor<>(new LinkedList<>("value"));
        printStructMethodConstructor.printFields();
        printStructMethodConstructor.printMethods();
        printStructMethodConstructor.printConstructors();
    }
}
