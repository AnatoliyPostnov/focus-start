package reflection.hierarchy;

public class thirdClass extends secondClass implements IThird {
    public Integer publicParam = 10;
    private Integer privateParam = 10;
    private final Integer finalPrivateParam = 10;

    @Override
    public void thirdFunction() {
        System.out.println("Hello, I thirdFunction");
    }

    public Integer getParam(){
        return privateParam;
    }
}
