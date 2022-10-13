package org.example.strategy;

import java.io.IOException;

/**
 * @author sc.su
 */
public class Function {
    public static boolean isNullItem(String item) {
        return item.length() == 0;
    }

    public void execute(String command) throws IOException {
        System.out.println("输入格式有误！请重新输入");
    }
}
