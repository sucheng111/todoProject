package org.example.strategy;

import org.example.Main;
import org.example.SerializeUtils;
import org.example.Task;

import java.io.IOException;
import java.util.List;

/**
 * @author sc.su
 */
public class AddFunction extends Function {
    @Override
    public void execute(String command, List<Task> tasks) throws IOException {
        String item = command.substring(8);
        if (!isNullItem(item)) {
            Task task = new Task(item, false, tasks.size() + 1);
            tasks.add(task);
            System.out.println(task);
            System.out.println();
            System.out.println("Item " + tasks.size() + " added");
            SerializeUtils.writeFile(tasks, Main.loginUser);
            return;
        }
        System.out.println("item为空，请重新输入");
    }
}
