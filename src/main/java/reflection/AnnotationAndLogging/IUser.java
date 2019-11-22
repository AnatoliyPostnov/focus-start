package reflection.AnnotationAndLogging;

public interface IUser {
    public String getName();
    public String getLastName();

    @MyAnnotation
    public void setName(String name);
    public void setLastName(String LastName);
}
