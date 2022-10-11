package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Task implements Serializable {
    public String item;
    public boolean isDone;

    int index;

    @Override
    public String toString() {
        String doneStr = "";
        if (isDone) doneStr = "DONE";
        return index + ". " + doneStr + item;
    }
}
