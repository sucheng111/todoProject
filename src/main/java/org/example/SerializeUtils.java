package org.example;

import org.example.filestream.MyObjectInputStream;
import org.example.filestream.MyObjectOutputStream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sc.su
 */
public class SerializeUtils {
    static final String DATA_DIRECTORY = "/Users/sc.su/data/";
    static String dataPath;

    public static List<Task> readFile(String user) throws IOException {
        List<Task> taskList = getTaskList();
        createFileIfNotExist(user);
        try (ObjectInputStream ois = new MyObjectInputStream(createFileInputStream())) {
            taskList = (List<Task>) ois.readObject();
            taskList.forEach(System.out::println);
            return taskList;
        } catch (EOFException e) {
            return taskList;
        } catch (InvalidClassException e) {
            clearFile(user);
        } catch (Exception e) {
            System.out.println("读取文件出错啦！");
            e.printStackTrace();
        }
        return taskList;
    }

    private static ArrayList<Task> getTaskList() {
        return new ArrayList<>();
    }

    public static void writeFile(List<Task> taskList, String user) {
        try (ObjectOutputStream oos = new MyObjectOutputStream(createFileOutputStream())) {
            createFileIfNotExist(user);
            oos.writeObject(taskList);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean createFileIfNotExist(String user) throws IOException {
        dataPath = DATA_DIRECTORY + user + ".txt";
        File file = new File(dataPath);
        if (!file.exists()) {
            return file.createNewFile();
        }
        return true;
    }

    public static OutputStream createFileOutputStream() throws IOException {
        return Files.newOutputStream(Paths.get(dataPath));
    }

    public static InputStream createFileInputStream() throws IOException {
        return Files.newInputStream(Paths.get(dataPath));
    }

    public static void clearFile(String user) throws IOException {
        dataPath = DATA_DIRECTORY + user + ".txt";
        File file = new File(dataPath);
        if (file.delete()) {
            file.createNewFile();
        }
    }


}
