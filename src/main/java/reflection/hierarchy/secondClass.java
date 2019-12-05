package reflection.hierarchy;

public class secondClass extends firstClass implements ISecond {
    @Override
    public void secondFunction() {
        System.out.println("Hello, I secondFunction");
    }
}
