package org.example.strategy;

import org.example.User;

import java.io.IOException;

/**
 * @author sc.su
 */
public class AddFunction extends Function {
    @Override
    public void execute(String command) throws IOException {
        String item = command.substring(8);
        if (!isNullItem(item)) {
            User.addTask(item);
            return;
        }
        System.out.println("item为空，请重新输入");
    }
}
