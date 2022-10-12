package org.example.strategy;


import org.example.Task;

import java.util.List;

/**
 * @author sc.su
 */
public class ListFunction extends Function{
    @Override
    public void execute(String command, List<Task> tasks) {
        if (tasks.size() == 0) {
            System.out.println("现在为空，请添加之后重试");
            return;
        }
        if (command.equals("todo list --all")) {
            tasks.forEach(System.out::println);
            System.out.println("Total " + tasks.size());
            return;
        }
        if(command.equals("todo list")){
            tasks.stream().filter((a) -> !a.getIsDone()).forEach(System.out::println);
            long count = tasks.stream().filter((a) -> !a.getIsDone()).count();
            System.out.println("Total " + count);
            return;
        }
        System.out.println("输入格式不正确！请重试");
    }
}
