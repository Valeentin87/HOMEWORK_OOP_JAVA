package personal.controllers;

import personal.Main;
import personal.model.FileOperation;
import personal.model.FileOperationImpl;
import personal.model.Repository;
import personal.model.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    private final Repository repository;

    public UserController(Repository repository) {
        this.repository = repository;
    }

    public void saveUser(User user) {
        repository.CreateUser(user);
    }

    public User readUser(String userId) throws Exception {
        List<User> users = repository.getAllUsers();
        for (User user : users) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }

        throw new Exception("User not found");
    }
    public String[] searchUser(String userName, String userSurname){
        String[] array = new String[2];
        List<User> users = repository.getAllUsers();
        for (User user : users) {
            if (user.getFirstName().equals(userName)&user.getLastName().equals(userSurname)){
                array[0] = user.getId();
                array[1] = user.getPhone();
            }
        }
        return array;
    }
 /*
    public String newInterface(){
        StringBuffer stringBuffer = new StringBuffer();
        List<User> users = repository.getAllUsers();
        for (User user : users) {
            stringBuffer.append(user.toString());
        }
        return stringBuffer.toString();
    }
*/
 public String newInterface(){
     StringBuffer stringBuffer = new StringBuffer();
     List<User> users = repository.getAllUsers();
     for (User user : users) {
         stringBuffer.append(user.toString());
     }
     return stringBuffer.toString();
 }



    public void createNewInterfaceFile(String fileName){

        List<User> users = repository.getAllUsers();
        List<String> usersInString = new ArrayList<>();
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (User user  : users) {
                // запись всей строки
                //writer.write(line);
                writer.write(user.toString()+"\n********************");
                // запись по символам
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
