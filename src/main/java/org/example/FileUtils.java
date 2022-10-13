package org.example;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * @author sc.su
 */
public class FileUtils {

    static final String DATA_DIRECTORY = "/Users/sc.su/data/";
    static String dataPath;

    static boolean fileIsNotExist(String user) throws IOException {
        return createFileIfNotExist(user);
    }

    static ArrayList<Task> getTaskList() {
        return new ArrayList<Task>();
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

    public static void clearFile(String user) throws IOException {
        dataPath = DATA_DIRECTORY + user + ".txt";
        File file = new File(dataPath);
        if (file.delete()) {
            file.createNewFile();
        }
    }

    public static InputStream createFileInputStream() throws IOException {
        return Files.newInputStream(Paths.get(dataPath));
    }

}