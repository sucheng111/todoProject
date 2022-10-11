package org.example;

import org.example.filestream.MyObjectInputStream;
import org.example.filestream.MyObjectOutputStream;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SerializeUtils {
    static final String dataDirectory = "/Users/sc.su/data/";
    static ObjectInputStream ois;
    static ObjectOutputStream oos;
    static String dataPath;

    public static List<Task> readFile(String user) throws IOException {
        List<Task> taskList = getTaskList();
        try {
            createFileIfNotExist(user);
            ois = new MyObjectInputStream(createFileInputStream());
            taskList = (List<Task>) ois.readObject();
            taskList.forEach(System.out::println);
            return taskList;
        } catch (EOFException e) {
            return taskList;
        } catch (Exception e) {
            System.out.println("读取文件出错啦！");
            e.printStackTrace();
        } finally {
            ois.close();
        }
        return taskList;
    }

    private static ArrayList<Task> getTaskList() {
        return new ArrayList<>();
    }

    public static void writeFile(List<Task> taskList, String user) throws IOException {
        try {
            createFileIfNotExist(user);
            oos = new MyObjectOutputStream(createFileOutputStream());
            oos.writeObject(taskList);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            oos.close();
        }
    }

    public static void createFileIfNotExist(String user) throws IOException {
        dataPath = dataDirectory + user + ".txt";
        File file = new File(dataPath);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    public static OutputStream createFileOutputStream() throws IOException {
        return Files.newOutputStream(Paths.get(dataPath));
    }

    public static InputStream createFileInputStream() throws IOException {
        return Files.newInputStream(Paths.get(dataPath));
    }


}
