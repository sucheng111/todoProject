package org.example;

import org.example.filestream.MyObjectInputStream;
import org.example.filestream.MyObjectOutputStream;

import java.io.*;
import java.util.List;

/**
 * @author sc.su
 */
public class SerializeUtils {

    public static List<Task> readFile(String user) throws IOException {
        List<Task> taskList = FileUtils.getTaskList();
        FileUtils.fileIsNotExist(user);
        try (ObjectInputStream ois = new MyObjectInputStream(FileUtils.createFileInputStream())) {
            taskList = (List<Task>) ois.readObject();
            taskList.forEach(System.out::println);
            return taskList;
        } catch (EOFException e) {
            return taskList;
        } catch (InvalidClassException e) {
            FileUtils.clearFile(user);
        } catch (Exception e) {
            System.out.println("读取文件出错啦！");
            e.printStackTrace();
        }
        return taskList;
    }

    public static void writeFile(List<Task> taskList, String user) {
        try (ObjectOutputStream oos = new MyObjectOutputStream(FileUtils.createFileOutputStream())) {
            FileUtils.fileIsNotExist(user);
            oos.writeObject(taskList);
            oos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
