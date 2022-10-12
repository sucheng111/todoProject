package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * @author sc.su
 */
@AllArgsConstructor
@Getter
public class Task implements Serializable {
    private String item;
    private boolean isDone;
    private int index;

    @Override
    public String toString() {
        String doneStr = "";
        if (isDone) {
            doneStr = "DONE";
        }
        return index + ". " + doneStr + item;
    }

    public void doneTask() {
        this.isDone = true;
    }

    public boolean getIsDone(){
        return isDone;
    }
}
