import org.junit.Test;

public class Customer {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String name;
    private char gender;
    private int age;
    private String phone;
    private String email;



    public Customer(){

    }

    public Customer(String name, char gender, int age, String phone, String email){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return   name + "\t" + gender +
                "\t" + age +
                "\t" + phone +
                "\t" + email;
    }
    @Test
    public static void main(String[] args) {
        Customer c1 = new Customer("Tom",'男',13,"1309808928","2213425509@qq.com");
        System.out.println(c1);
    }
}
