package todolistAppl.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Comparable <Task>, Serializable {
    private String task;
    private LocalDate time;

    public Task( String task, LocalDate time) {
        this.task = task;
        this.time = time;
    }
    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Task " + task + " (" + time + ") ";
    }

    @Override
    public int compareTo(Task o) {
        return this.time.compareTo(o.getTime());
    }
}
