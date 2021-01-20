
public class Student {
    private String name ;
    private String department;
    private String id ;
    public static String CLASSES ="ELektrik Devreleri\n"
            + "Mantık Devereleri\n"
            + "Veri Yapıları\n"
            + "Mühendislik Matematiği\n";

    public Student(String name, String department, String id) {
        this.name = name;
        this.department = department;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClasses() {
        return CLASSES;
    }

    public void setClasses(String classes) {
        this.CLASSES = classes;
    }
    
    
}
