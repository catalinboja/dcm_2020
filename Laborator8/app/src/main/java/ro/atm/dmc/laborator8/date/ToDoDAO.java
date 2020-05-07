package ro.atm.dmc.laborator8.date;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ToDoDAO {

    @Insert()
    public void insert(ToDo toDo);

    @Update()
    public void update(ToDo todo);

    @Delete()
    public void deleteAll();

    @Delete()
    public void delete(ToDo toDo);

    @Query("DELETE FROM ToDo")
    public void deleteAllCustom();

    @Query("SELECT * FROM ToDo")
    public List<ToDo> selectAll();

    @Query("SELECT * FROM ToDo ORDER BY prioritate DESC")
    public List<ToDo> selectAllDupaPrioritate();

    @Query("SELECT * FROM ToDo ORDER BY text ASC")
    public List<ToDo> selectAllDupaText();

}
