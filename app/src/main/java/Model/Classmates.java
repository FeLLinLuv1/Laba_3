package Model;

public class Classmates {

    private int id;
    private String FIO;
    private String time;

    //НАЧАЛО конструкторы
    public Classmates() {
    }
    public Classmates(int id, String FIO, String time) {
        this.id = id;
        this.FIO = FIO;
        this.time = time;
    }
    public Classmates(String FIO, String time) {
        this.FIO = FIO;
        this.time = time;
    }
    //КОНЕЦ конструкторы


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

