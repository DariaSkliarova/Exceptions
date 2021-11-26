public class Student {

    private int age;
    private String name;

    public void setAge(int age) {
        if (age < 0 ){
            throw new IllegalArgumentException();
        }
        this.age = age;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
