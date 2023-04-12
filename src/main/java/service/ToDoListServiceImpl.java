package service;

import entity.ToDoList;
import repository.ToDoListRepository;

public class ToDoListServiceImpl implements ToDoListService {

    private ToDoListRepository toDoListRepository;

    public ToDoListServiceImpl(ToDoListRepository toDoListRepository) {
        this.toDoListRepository = toDoListRepository;
    }

    @Override
    public void showToDoList() {
        ToDoList[] model = toDoListRepository.getAll();
        System.out.println("TO DO LIST");

        for (int i = 0; i < model.length; i++) {
            ToDoList toDoList = model[i];
            int no = i + 1;
            if (toDoList != null) {
                System.out.println(no + "." + toDoList.getToDo());
            }
        }
    }

    @Override
    public void addToDoList(String toDo) {
        ToDoList toDoList = new ToDoList(toDo);
        toDoListRepository.add(toDoList);
        System.out.println("SUKSES MENAMBAH KEGIATAN : " + toDo);
    }

    @Override
    public void removeToDoList(Integer number) {
        boolean success = toDoListRepository.remove(number);
        if (success) {
            System.out.println("SUKSES MENGHAPUS KEGIATAN : " + number);
        } else {
            System.out.println("GAGAL MENGHAPUS KEGIATAN : " + number);
        }
    }
}
