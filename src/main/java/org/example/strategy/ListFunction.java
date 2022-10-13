package org.example.strategy;


import org.example.Task;
import org.example.User;

import java.util.List;

/**
 * @author sc.su
 */
public class ListFunction extends Function {

    @Override
    public void execute(String command) {
        User.listTask(command);
    }
}
