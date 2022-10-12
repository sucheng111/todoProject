package org.example.strategy;

import org.example.Task;

import java.io.IOException;
import java.util.List;

/**
 * @author sc.su
 */
public class Function {
    public void execute(String command,List<Task> tasks) throws IOException {
        System.out.println("输入格式有误！请重新输入");
    }

    public static boolean isNullItem(String item) {
        return item.length() == 0;
    }
}
