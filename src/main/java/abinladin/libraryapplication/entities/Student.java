package abinladin.libraryapplication.entities;

public class Student {
    private String id;
    private String name;

    public Student(){}

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
