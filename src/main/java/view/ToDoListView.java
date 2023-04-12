package view;

import service.ToDoListService;
import util.InputUtil;

public class ToDoListView {

    private ToDoListService toDoListService;

    public ToDoListView(ToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    public void showToDoList() {
        while (true) {
            toDoListService.showToDoList();

            System.out.println("Menu");
            System.out.println("1. Tambah Kegiatan");
            System.out.println("2. Hapus Kegiatan");
            System.out.println("X. Keluar Aplikasi");

            String input = InputUtil.input("Pilih");

            if (input.equals("1")) {
                addToDoList();
            } else if (input.equals("2")) {
                removeToDoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Perintah Tidak Ada, Silahkan pilih yang tersedia");
            }
        }
    }

    public void addToDoList() {
        System.out.println("MENAMBAH TO DO LIST");

        String todo = InputUtil.input("todo (x jika batal menambah kegiatan)");

        if (todo.equals("x")) {
            // batal menambah kegiatan
        } else {
            toDoListService.addToDoList(todo);
        }
    }

    public void removeToDoList() {
        System.out.println("MENGHAPUS TO DO LIST");

        String number = InputUtil.input("Kegiatan Yang Ingin Dihapus (x jika batal menghapus kegiatan)");

        if (number.equals("x")) {
            //batal menghapus kegiatan
        } else {
            toDoListService.removeToDoList(Integer.valueOf(number));
        }
    }
}
