package com.kecewka.mid_todo;

public class TaskModel {
    private String task_name;

    public TaskModel(String task_name) {
        this.task_name = task_name;
    }

    public TaskModel(){
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }
}
