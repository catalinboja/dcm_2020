package ro.atm.dmc.laborator6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

import ro.atm.dmc.laborator6.modele.ToDo;

public class MainActivity extends AppCompatActivity {

    ArrayList<ToDo> toDos = new ArrayList<>();

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
        ListView listViewToDo = (ListView) findViewById(R.id.listViewToDo);
        listViewToDo.setAdapter(toDoArrayAdapter);

    }
}
