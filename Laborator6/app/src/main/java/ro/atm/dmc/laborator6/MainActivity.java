package ro.atm.dmc.laborator6;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

import ro.atm.dmc.laborator6.modele.ToDo;
import ro.atm.dmc.laborator6.modele.ToDoAdapter;

public class MainActivity extends AppCompatActivity {

    private static final int MENU_ITEM_DELETE = 1;
    private static final int MENU_ITEM_DETAILS = 2;

    ArrayList<ToDo> toDos = new ArrayList<>();
    public static ToDoAdapter toDoAdapter;

    private void initListaToDo(){
        ToDo activitate1 =
                new ToDo("Laborator DMC", new Date("4/23/2020"), true);
        ToDo activitate2=
                new ToDo("Tema DMC", new Date("4/29/2020"), true);
        ToDo activitate3=
                new ToDo("Documentare", new Date("4/28/2020"), false);

        toDos.add(activitate1);
        toDos.add(activitate2);
        toDos.add(activitate3);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initListaToDo();

        //incarcam date in listView printr-un adaptor standard
        ArrayAdapter<ToDo> toDoArrayAdapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,toDos);

        //incarcam date in ListView prin adaptorul particular
        toDoAdapter = new ToDoAdapter(toDos, this);



        ListView listViewToDo = (ListView) findViewById(R.id.listViewToDo);
        //listViewToDo.setAdapter(toDoArrayAdapter);
        listViewToDo.setAdapter(toDoAdapter);

        //aduga meniul contextual la listView
        registerForContextMenu(listViewToDo);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        //adaugam meniul contextual pe fiecare element din listView/adaptor
        AdapterView.AdapterContextMenuInfo  adapterContextMenuInfo =
                (AdapterView.AdapterContextMenuInfo) menuInfo;
        String titlu = ((ToDo)toDoAdapter.getItem(adapterContextMenuInfo.position)).getText();
        menu.setHeaderTitle(titlu);

        menu.add(Menu.NONE, MENU_ITEM_DELETE, 1,"Sterge");
        menu.add(Menu.NONE, MENU_ITEM_DETAILS, 1,"Detalii");

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case MENU_ITEM_DELETE: {
                AdapterView.AdapterContextMenuInfo adapterContextMenuInfo =
                        (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                int idElementSelectat =
                        adapterContextMenuInfo.position;
                toDoAdapter.stergeElement(idElementSelectat);
                return true;
            }
            default:
                return super.onContextItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.adauga: {

                Intent intent = new Intent(this, AdaugaToDoActivity.class);
                startActivity(intent);
                return true;

            }
            case R.id.salvare: {

                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
