import java.util.Scanner;

public class AplikasiToDoList {

    public static String[] model = new String[10];

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        viewShowToDoList();
    }

    /*Menampilkan To Do List*/
    public static void showToDoList() {
        System.out.println("TO DO LIST");
        for (int i = 0; i < model.length; i++) {
            String todo = model[i];
            int no = i + 1;
            if (todo != null) {
                System.out.println(no + "." + todo);
            }
        }
    }

    /*Unit Test Method ShowToDoList*/
    public static void testShowToDoList() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi Kasus Java Dasar : Aplikasi To Do List";
        showToDoList();
    }

    /*Menambah To Do List*/
    public static void addToDoList(String todo) {
        //cek apakah model penuh?
        boolean isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                //model masih ada yang kosong
                isFull = false;
                break;
            }
        }

        //Jika penuh, kita resize ukuran Array 2x lipat
        if (isFull) {
            String[] temp = model;
            model = new String[model.length * 2];
            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        //tambahkan ke posisi yang data array nya NULL
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    /*Unit Test method Add To Do List*/
    public static void testAddToDoList() {
        for (int i = 0; i < 25; i++) {
            addToDoList("Contoh To Do ke." + i);
        }

        showToDoList();
    }

    /*Menghapus To Do List*/
    public static boolean removeToDoList(Integer number) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    /*Unit Test method Remove TO DO LIST*/
    public static void testRemoveToDoList() {
        addToDoList("Satu");
        addToDoList("Dua");
        addToDoList("Tiga");
        addToDoList("Empat");
        addToDoList("Lima");
        addToDoList("Enam");
        addToDoList("Tujuh");
        addToDoList("Delapan");

        boolean result = removeToDoList(8);
        System.out.println(result);

        result = removeToDoList(1);
        System.out.println(result);

        result = removeToDoList(4);
        System.out.println(result);
//
//        result = removeToDoList(5);
//        System.out.println(result);

        showToDoList();
    }

    /*Input Data ke Terminal*/
    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    /*Unit Test untuk method input*/
    public static void testInput() {
        String name = input("Nama");
        System.out.println("Hi, " + name + "! Selamat datang ");
        System.out.println("di lingkungan pengembangan terintegrasi ");
        System.out.println("dari Republik Ceko.");

        String activity = input("Kegiatan");
        System.out.println(activity);
    }

    /*Menampilkan view To Do List*/
    public static void viewShowToDoList() {
        while (true) {
            showToDoList();

            System.out.println("Menu");
            System.out.println("1. Tambah Kegiatan");
            System.out.println("2. Hapus Kegiatan");
            System.out.println("X. Keluar Aplikasi");

            String input = input("Pilih");

            if (input.equals("1")) {
                viewAddToDoList();
            } else if (input.equals("2")) {
                viewRemoveToDoList();
            } else if (input.equals("x")) {
                break;
            } else {
                System.out.println("Perintah Tidak Ada, Silahkan pilih yang tersedia");
            }
        }
    }

    /*Unit Test method View Show To Do List*/
    public static void testViewShowToDoList() {
        addToDoList("Satu");
        addToDoList("Dua");
        addToDoList("Tiga");
        addToDoList("Empat");
        addToDoList("Lima");
        viewShowToDoList();
    }

    /*Menampilkan view menambahkan To Do List*/
    public static void viewAddToDoList() {
        System.out.println("MENAMBAH TO DO LIST");

        String todo = input("todo (x jika batal menambah kegiatan)");

        if (todo.equals("x")) {
            // batal menambah kegiatan
        }else {
            addToDoList(todo);
        }
    }

    /*Unit Test method View Add To Do List*/
    public static void testViewAddToDoList(){
        viewAddToDoList();

        showToDoList();
    }

    /*Menampilkan view menghapus To Do List*/
    public static void viewRemoveToDoList() {
        System.out.println("MENGHAPUS TO DO LIST");

        String number = input("Kegiatan Yang Ingin Dihapus (x jika batal menghapus kegiatan)");

        if (number.equals("x")){
            //batal menghapus kegiatan
        }else {
            boolean success = removeToDoList(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus To Do List : " + number);
            }
        }
    }

    /*Unit Test method View Remove To Do List*/
    public static void testViewRemoveToDoList(){
        addToDoList("Satu");
        addToDoList("Dua");
        addToDoList("Tiga");
        addToDoList("Empat");
        addToDoList("Lima");

        viewShowToDoList();
        viewRemoveToDoList();
        viewShowToDoList();
    }
}

