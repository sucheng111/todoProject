package org.example.strategy;


import org.example.User;

/**
 * @author sc.su
 */
public class ListFunction extends Function {

    @Override
    public void execute(String command) {
        User.listTask(command);
    }
}
