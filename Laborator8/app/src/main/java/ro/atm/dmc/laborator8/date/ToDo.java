package ro.atm.dmc.laborator8.date;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ToDo")
public class ToDo {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "text")
    @NonNull
    private String text;

    @ColumnInfo(name = "prioritate")
    @NonNull
    private int prioritate;

    public ToDo(String text, int prioritate) {
        this.text = text;
        this.prioritate = prioritate;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getPrioritate() {
        return prioritate;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPrioritate(int prioritate) {
        this.prioritate = prioritate;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", prioritate=" + prioritate +
                '}';
    }
}
