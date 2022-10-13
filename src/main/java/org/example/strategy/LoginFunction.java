package org.example.strategy;

import org.example.User;

import java.io.IOException;

/**
 * @author sc.su
 */
public class LoginFunction extends Function {
    @Override
    public void execute(String command) throws IOException {
        String user = command.substring(14);
        User.login(user);
        System.out.println("登陆成功！可以开始使用了");
    }
}
