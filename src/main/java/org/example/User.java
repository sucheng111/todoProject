package org.example;

import lombok.Getter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author 苏成
 * @date 2022/10/13 15:59
 */
@Getter
public class User {

    static final String LIST_TALL = "todo list --all";
    static final String LIST = "todo list";
    public static Optional<String> loginUser = Optional.empty();
    static List<Task> tasks = new ArrayList<>();

    public static void login(String user) throws IOException {
        loginUser = Optional.of(user);
        tasks = SerializeUtils.readFile(user);
    }

    public static void logout() {
        System.out.println(loginUser + "退出登陆成功！");
        tasks = new ArrayList<>();
        loginUser = Optional.empty();
    }

    public static void addTask(String item) {
        Task task = new Task(item, false, tasks.size() + 1);
        tasks.add(task);
        System.out.println(task);
        System.out.println();
        System.out.println("Item " + tasks.size() + " added");
        SerializeUtils.writeFile(tasks, User.loginUser.orElse(null));
    }

    public static void doneTask(String item){
        Optional<Task> taskOptional = tasks.stream().filter((a) -> Objects.equals(a.getItem(), item)).findFirst();
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.doneTask();
            System.out.println("Item" + task.getItem() + " done");
            SerializeUtils.writeFile(tasks, User.loginUser.orElse(null));
        }
    }


    public static void listTask(String command){
        if (tasks.size() == 0) {
            System.out.println("现在为空，请添加之后重试");
            return;
        }
        if (LIST_TALL.equals(command)) {
            tasks.forEach(System.out::println);
            System.out.println("Total " + tasks.size());
            return;
        }
        if (LIST.equals(command)) {
            tasks.stream().filter((a) -> !a.getIsDone()).forEach(System.out::println);
            long count = tasks.stream().filter((a) -> !a.getIsDone()).count();
            System.out.println("Total " + count);
            return;
        }
        System.out.println("输入格式不正确！请重试");
    }
}
