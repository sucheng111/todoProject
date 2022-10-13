package org.example.strategy;

import org.example.User;

/**
 * @author sc.su
 */
public class LogoutFunction extends Function {
    @Override
    public void execute(String command) {
        User.logout();
    }
}
