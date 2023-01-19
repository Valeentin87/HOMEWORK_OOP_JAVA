package personal.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperationImpl implements FileOperation { // класс, реализующий операции над файлами

    private String fileName;  // закрытое поле класса - имя файла, используемого для реализации логики
    private String filenameBack; //файл, который выводится на экран пользователя

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilenameBack() {
        return filenameBack;
    }

    public void setFilenameBack(String filenameBack) {
        this.filenameBack = filenameBack;
    }

    public FileOperationImpl(String fileName) { //конструктор класса, создающий новый текстовой файл с указанным именем
                                                // и позволяющий дописывать данные к уже имеющимся
        this.fileName = fileName;
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.flush();   //требование, чтобы все записи сохранялись в любое время перед закрытием потока
        } catch (IOException ex) { // исключение
            System.out.println(ex.getMessage());
        }
    }
        // метод, позволяющий прочитать все строки файла, возвращает список строк
    public List<String> readAllLines() {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File(fileName); //создается файл с именем, указанным в конструкторе экземпляра
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            // пока буфер не пустой - то есть содержится строка дописываем её в конец списка строк lines
            if (line != null) {
                lines.add(line);
            }
            while (line != null) {
                // считываем остальные строки в цикле
                line = reader.readLine();
                if (line != null) {
                    lines.add(line);
                }
            }
            // как только строки закончились закрываем поток
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
    // реализация метода сохранения новых данных в файл

    public void saveAllLines(List<String> lines) {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (String line : lines) {
                // запись всей строки
                writer.write(line);
                //writer.write(line+"\n********************");
                // запись по символам
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void saveAllLinesNew(List<String> lines) {
        try (FileWriter writer = new FileWriter(filenameBack, false)) {
            for (String line : lines) {
                // запись всей строки
                //writer.write(line);
                writer.write(line+"\n********************");
                // запись по символам
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
