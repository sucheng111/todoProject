package org.example.strategy;

import org.example.Main;
import org.example.SerializeUtils;
import org.example.Task;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author sc.su
 */
public class DoneFunction extends Function{
    @Override
    public void execute(String command, List<Task> tasks) throws IOException {
        String item = command.substring(9);
        if (isNullItem(item)) {
            System.out.println("item为空，请重新输入！");
            return;
        }
        Optional<Task> taskOptional = tasks.stream().filter((a) -> Objects.equals(a.getItem(), item)).findFirst();
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.doneTask();
            System.out.println("Item" + task.getItem() + " done");
            SerializeUtils.writeFile(tasks, Main.loginUser);
        }
    }
}
