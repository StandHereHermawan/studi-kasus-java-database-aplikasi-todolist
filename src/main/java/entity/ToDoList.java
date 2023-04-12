package entity;

public class ToDoList {

    private int id;

    private String toDo;

    public ToDoList() {
    }

    public ToDoList(String toDo) {
        this.toDo = toDo;
    }

    public String getToDo() {
        return toDo;
    }

    public void setToDo(String toDo) {
        this.toDo = toDo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
