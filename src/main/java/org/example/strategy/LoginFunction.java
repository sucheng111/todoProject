package org.example.strategy;

import org.example.Main;
import org.example.SerializeUtils;
import org.example.Task;

import java.io.IOException;
import java.util.List;

/**
 * @author sc.su
 */
public class LoginFunction extends Function {
    @Override
    public void execute(String command, List<Task> tasks) throws IOException {
        String user = command.substring(14);
        Main.loginUser = user;
        tasks = SerializeUtils.readFile(user);
        System.out.println("登陆成功！可以开始使用了");
    }
}
