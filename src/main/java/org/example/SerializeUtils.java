package org.example;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SerializeUtils {
    static ObjectInputStream ois;

    static ObjectOutputStream oos;

    public SerializeUtils() throws Exception {
    }

    public static List<Task> readFile() throws IOException {
        List<Task> taskList = getTaskList();
        try {
            ois = new MyObjectInputStream(Files.newInputStream(Paths.get("/Users/sc.su/data.txt")));
            taskList = (List<Task>) ois.readObject();
            taskList.forEach(System.out::println);
            return taskList;
        } catch (Exception e) {
            System.out.println("读取文件出错啦！");
        } finally {
            ois.close();
        }
        return taskList;
    }

    private static ArrayList<Task> getTaskList() {
        return new ArrayList<Task>();
    }

    public static void writeFile(List<Task> taskList) throws IOException {
        try {
            oos = new MyObjectOutputStream(Files.newOutputStream(Paths.get("/Users/sc.su/data.txt")));
            oos.writeObject(taskList);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            oos.close();
        }
    }

}
