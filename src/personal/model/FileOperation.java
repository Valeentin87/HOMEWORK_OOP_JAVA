package personal.model;

import java.util.List;

public interface FileOperation {  // интерфейс "операции над файлами"
    List<String> readAllLines();  // метод, позволяющий прочитать всё содержимое файла по линиям, возвращает список строк

    void saveAllLines(List<String> lines); // метод, позволяющий сохранить всё в файл
    void saveAllLinesNew(List<String> lines);
}
