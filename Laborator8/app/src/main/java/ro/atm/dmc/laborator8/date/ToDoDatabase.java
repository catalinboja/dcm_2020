package ro.atm.dmc.laborator8.date;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {ToDo.class}, version = 1, exportSchema = false)
public abstract class ToDoDatabase extends RoomDatabase {

    //clasa este un Singleton - nu putem genera mai mult de o instanta
    //comenzile vor fi procesate pe thread-uri diferite

    public abstract ToDoDAO toDoDAO();
    private static volatile ToDoDatabase BAZA_DATE;
    public static final String NUME_BAZA_DATE = "todo_database";

    private static final int NR_THREAD = 4;
    static final ExecutorService databaseService =
            Executors.newFixedThreadPool(NR_THREAD);

    static synchronized ToDoDatabase getBazaDate(final Context context){
        if(BAZA_DATE == null){
            BAZA_DATE = Room.databaseBuilder(
                    context.getApplicationContext(),ToDoDatabase.class,NUME_BAZA_DATE)
                    .allowMainThreadQueries()
                    .addCallback(databaseCallback)
                    .build();
        }
        return BAZA_DATE;
    }

    private static RoomDatabase.Callback databaseCallback =
            new RoomDatabase.Callback() {
                //se va executa o singura data la crearea bazei de date
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    super.onCreate(db);

                    //incarcam 2 inregistrari default
                    databaseService.execute(new Runnable() {
                        @Override
                        public void run() {
                            ToDoDAO toDoDAO = BAZA_DATE.toDoDAO();

                            ToDo toDo = new ToDo("Ceva de facut", 1);
                            toDoDAO.insert(toDo);
                            toDo = new ToDo("Ceva important", 3);
                            toDoDAO.insert(toDo);
                        }
                    });
                }


            };
}
