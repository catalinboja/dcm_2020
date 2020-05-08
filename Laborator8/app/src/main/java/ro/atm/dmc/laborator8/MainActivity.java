package ro.atm.dmc.laborator8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import ro.atm.dmc.laborator8.adaptoare.ToDoAdapter;
import ro.atm.dmc.laborator8.date.PieChart;
import ro.atm.dmc.laborator8.date.ToDo;

public class MainActivity extends AppCompatActivity {

    ToDoAdapter toDoAdapter;
    public static final int ADD_TO_DO_ACTIVITY_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toDoAdapter = new ToDoAdapter(getApplicationContext());
        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(toDoAdapter);

        FloatingActionButton actionButton = findViewById(R.id.floatingActionButton);
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddToDoActivity.class);
                startActivityForResult(intent, ADD_TO_DO_ACTIVITY_CODE);
            }
        });

    }



    public void onActivityResult(int requestCode, int codRezultat, Intent date){
        super.onActivityResult(requestCode, codRezultat, date);

        if(requestCode == ADD_TO_DO_ACTIVITY_CODE) {
            if(codRezultat == RESULT_OK) {
                String text = date.getStringExtra(AddToDoActivity.NUME_TEXT);
                int prioritate = date.getIntExtra(AddToDoActivity.NUME_PRIORITATE, 0);
                ToDo toDo = new ToDo(text, prioritate);
                toDoAdapter.add(toDo);
            }
            else
            {
                Toast.makeText(this,"Nu s-a adaugat un eveniment", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = new MenuInflater(this);
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuItemGrafic){
            Intent intent = new Intent(this, GraficActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
