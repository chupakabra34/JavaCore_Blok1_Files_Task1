import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * \* Created with IntelliJ IDEA.
 * \* Author: Prekrasnov Sergei
 * \* Date: 02.03.2022
 * \*  ----- group JAVA-27 -----
 * \* Description: Потоки ввода-вывода. Работа с файлами
 * \                 Задача 1: Установка
 * \
 */
public class Main {
    static StringBuilder sb = new StringBuilder();
    static String coolDir = "Успешно создана папка: - ";
    static String coolFile = "Успешно создан файл: - ";
    static String notCoolDir = "Ошибка создания папки: - ";
    static String notCoolFile = "Ошибка создания файла: - ";

    public static void main(String[] args) throws IOException {
        File dirGames = new File("C:" + File.separator + "Games");
        File[] dirFile = new File[]{dirGames, new File(dirGames + File.separator + "src"),
                new File(dirGames + File.separator + "res"),
                new File(dirGames + File.separator + "savegames"),
                new File(dirGames + File.separator + "temp"),
                new File(dirGames + File.separator + "src" + File.separator + "main"),
                new File(dirGames + File.separator + "src" + File.separator + "test"),
                new File(dirGames + File.separator + "res" + File.separator + "drawables"),
                new File(dirGames + File.separator + "res" + File.separator + "vectors"),
                new File(dirGames + File.separator + "res" + File.separator + "icons")};
        File[] fileDir = new File[]{
                new File(dirGames + File.separator + "src" + File.separator + "main" + File.separator + "Main.java"),
                new File(dirGames + File.separator + "src" + File.separator + "main" + File.separator + "Utils.java"),
                new File(dirGames + File.separator + "temp" + File.separator + "temp.txt")};

        for (File x : dirFile) createNewDirs(x);
        for (File x : fileDir) createFile(x);
    }

    static public void createNewDirs(File dirNames) {
        getInfo(dirNames.mkdirs() ? coolDir + dirNames : notCoolDir + dirNames);
    }

    static public void createFile(File fileNames) {
        try {
            getInfo(fileNames.createNewFile() ? coolFile + fileNames : notCoolFile + fileNames);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if ("temp.txt".equals(fileNames.getAbsoluteFile().getName())) {
            try (FileWriter writer = new FileWriter(fileNames)) {
                writer.write(String.valueOf(sb));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(sb);
        }
    }

    static public void getInfo(String cool) {
        sb.append(cool + '\n');
    }
}