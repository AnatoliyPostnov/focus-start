package reflection.AnnotationAndLogging;

public class User implements IUser {
    private String name;
    private String lastName;

    public User(String name, String lastName){
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
