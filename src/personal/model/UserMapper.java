package personal.model;

public class UserMapper { // класс карта пользователя
    // метод map перегружен
    // метод, принимающий в качестве параметра экземпляр User и возвращающий "карту" со значениями всех полей через запятую
    public String map(User user) {
        return String.format("%s,%s,%s,%s", user.getId(), user.getFirstName(), user.getLastName(), user.getPhone());
    }
    // метод, позволяющий собрать из аргумента-строки нового пользователя
    public User map(String line) {
        String[] lines = line.split(",");
        return new User(lines[0], lines[1], lines[2], lines[3]);
    }
}
