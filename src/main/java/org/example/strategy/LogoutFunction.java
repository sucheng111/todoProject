package org.example.strategy;

import org.example.Main;
import org.example.Task;
import org.example.User;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sc.su
 */
public class LogoutFunction extends Function {
    @Override
    public void execute(String command) {
        User.logout();
    }
}
