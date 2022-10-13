package org.example.strategy;

import org.example.User;

import java.io.IOException;

/**
 * @author sc.su
 */
public class DoneFunction extends Function {
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
