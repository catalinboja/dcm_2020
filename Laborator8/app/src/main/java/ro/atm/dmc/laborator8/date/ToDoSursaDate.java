package ro.atm.dmc.laborator8.date;

import android.content.Context;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ToDoSursaDate {

    private ToDoDAO toDoDAO;
    private List<ToDo> toDoList;

    public ToDoSursaDate(Context context) {
        ToDoDatabase toDoDatabase = ToDoDatabase.getBazaDate(context);
        toDoDAO = toDoDatabase.toDoDAO();
        toDoList = toDoDAO.selectAll();
    }

    public List<ToDo> getToDoList() {
        return toDoList;
    }

    public void insert(final ToDo toDo){
        ToDoDatabase.databaseService.execute(new Runnable() {
            @Override
            public void run() {
                toDoDAO.insert(toDo);
            }
        });

        //nu prea e ok - pot ajunge desincronizate
        toDoList.add(toDo);
    }
}
