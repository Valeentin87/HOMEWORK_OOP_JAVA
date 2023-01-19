package personal.views;

import personal.controllers.UserController;
import personal.model.FileOperation;
import personal.model.FileOperationImpl;
import personal.model.User;

import java.io.PrintWriter;
import java.util.Scanner;

public class ViewUser {

    private UserController userController;

    public ViewUser(UserController userController) {
        this.userController = userController;
    }

    public void run(){
        Commands com = Commands.NONE;

        while (true) {
            String command = prompt("Введите команду: ");
            com = Commands.valueOf(command);
            if (com == Commands.EXIT) return;
            switch (com) {
                case CREATE:
                    String firstName = prompt("Имя: ");
                    String lastName = prompt("Фамилия: ");
                    String phone = prompt("Номер телефона: ");
                    userController.saveUser(new User(firstName, lastName, phone));
                    break;
                case READ:
                    String id = prompt("Идентификатор пользователя: ");
                    try {
                        User user = userController.readUser(id);
                        System.out.println(user);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case SEARCH:
                    String name = prompt("Введите имя пользователя, которого ищите: ");
                    String surname = prompt("Введите фамилию пользователя, которого ищите: ");
                    try {
                        String[] arr = new String[2];
                        arr = userController.searchUser(name,surname);
                        System.out.println("Пользователь " +name+" "+surname+" найден в справочнике под номером "+arr[0]+ " и имеет номер телефона "+arr[1]);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case NEWINTERFACE:
                    String newInterface = prompt("Введите название файла, в который хотите сохранить справочник в новом интерфейсе:  ");
                    try {
                        System.out.println(userController.newInterface());
                        PrintWriter out = new PrintWriter(newInterface+".txt");
                        out.println(userController.newInterface());


                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;



            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
