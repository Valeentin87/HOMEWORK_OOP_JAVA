package personal.model;

import java.util.List;
// интерфейс реппозиторий, позволяющий получить всех пользователей и создать пользователя
public interface Repository {
    List<User> getAllUsers();
    String CreateUser(User user);
   // void createNewInterfaceFile(String fileName, Repository repository);


}
