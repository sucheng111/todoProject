package org.example.strategy;

import org.example.Main;
import org.example.SerializeUtils;
import org.example.Task;
import org.example.User;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author sc.su
 */
public class DoneFunction extends Function{
    @Override
    public void execute(String command) throws IOException {
        String item = command.substring(9);
        if (isNullItem(item)) {
            System.out.println("item为空，请重新输入！");
            return;
        }
        User.doneTask(item);
    }
}
