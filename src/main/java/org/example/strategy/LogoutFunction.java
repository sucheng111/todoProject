package org.example.strategy;

import org.example.Main;
import org.example.Task;

import java.util.List;

public class LogoutFunction extends Function {
    @Override
    public void execute(String command, List<Task> tasks) {
        System.out.println(Main.loginUser + "退出登陆成功！");
        Main.loginUser = null;
    }
}
