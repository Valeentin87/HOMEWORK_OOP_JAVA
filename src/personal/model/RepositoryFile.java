package personal.model;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class RepositoryFile implements Repository { // класс файлы в репозитории
    private UserMapper mapper = new UserMapper(); // поле, по умолчанию равно пустой карте пользователя
    private FileOperation fileOperation; // поле, принимающее в себя интерфейс опреации над файлами
    //конструктор, создающий репозиторий файлов с реализацией интерфейса, указанного в параметрах
    public RepositoryFile(FileOperation fileOperation) {
        this.fileOperation = fileOperation;
    }
    // реализация метода получения всех пользователей
    @Override
    public List<User> getAllUsers() {
        List<String> lines = fileOperation.readAllLines();
        //String newStrFile = lines.toString();
        //String[] parsFile = newStrFile.;
        List<User> users = new ArrayList<>();
        for (String line : lines) {
            users.add(mapper.map(line)); // на основании каждой строки, полученной из считанного файла через мето map
                                        // к листу пользователей добавляем нового, распарсенного через запятые
        }
        return users;
    }
        // метод, позволяющий создать нового пользователя
    @Override
    public String CreateUser(User user) {
        // сначала получаем всех пользователей, которые есть
        List<User> users = getAllUsers();
        int max = 0;
        for (User item : users) {
            int id = Integer.parseInt(item.getId());
            if (max < id){
                max = id;
            }
        }
        int newId = max + 1;
        String id = String.format("%d", newId);
        user.setId(id);
        users.add(user);
        List<String> lines = new ArrayList<>();
        for (User item: users) {
            lines.add(mapper.map(item));
        }
        fileOperation.saveAllLines(lines);

        return id;
    }




}
