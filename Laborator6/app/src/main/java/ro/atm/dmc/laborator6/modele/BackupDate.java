package ro.atm.dmc.laborator6.modele;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BackupDate {

    public static final String fiserDate = "todos.dat";

    //metoda serializare date in fisier binar
    public static void salvareDate(ArrayList<ToDo> toDoArrayList, Context context){
        try {

            FileOutputStream fileOutputStream =
                    context.openFileOutput(fiserDate, Context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(toDoArrayList);

            /*for(ToDo toDo : toDoArrayList){
                objectOutputStream.writeObject(toDo);
            }*/

            objectOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //metoda deserializare date din fisier binar
    public static ArrayList<ToDo> incarcaDate(Context context){
        ArrayList<ToDo> toDoArrayList = null;

        try {

            FileInputStream fileInputStream = context.openFileInput(fiserDate);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            toDoArrayList = (ArrayList<ToDo>) objectInputStream.readObject();
            objectInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return toDoArrayList;
    }

}
