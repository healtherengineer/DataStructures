
public class Car {

    private String brand;
    private String model;
    private int age;

    public Car(String mark, String model, int age) {
        this.brand = mark;
        this.model = model;
        this.age = age;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getAge() {
        return age;
    }

    public void setBrand(String mark) {
        this.brand = mark;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCar() {
        return "\nBrand : " + this.getBrand() + "\nModel : " + this.getModel() + "\nAge :" + this.getAge();

    }

}
