package personal.model;

public class User {  // публичный класс пользователь
    private String id = ""; // закрытое поле класса - идентефикатор
    private String firstName; // закрытое поле класса - Имя пользователя
    private String lastName; // закрытое поле класса - Фамилия пользователя
    private String phone; // закрытое поле класса - номер телефона пользователя

    public User(String firstName, String lastName, String phone) { // конструктор класса без поля идентефикатор
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public User(String id, String firstName, String lastName, String phone) {  // конструктор класса с полем "идентефикатор"
        this(firstName, lastName, phone);
        this.id = id;
    }

    public String getId() {
        return id;
    } // геттер на идентефикатор

    public void setId(String id) {
        this.id = id;
    } //сеттер на идентефикатор

    public String getFirstName() {
        return firstName;
    } // геттер на имя

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    } // сеттер на имя

    public String getLastName() {
        return lastName;
    } // геттер на фамилию

    public void setLastName(String lastName) {
        this.lastName = lastName;
    } // сеттер на фамилию

    public String getPhone() {
        return phone;
    } // геттер на телефон

    public void setPhone(String phone) {
        this.phone = phone;
    } // сеттер на телефон

    @Override // переопределение метода toString для объектов класса User
    public String toString() {
        return String.format("%s---%s---%s---%s\n*************\n", id, firstName, lastName, phone);
    }
}
