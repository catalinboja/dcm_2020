package ro.atm.dmc.laborator8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import ro.atm.dmc.laborator8.adaptoare.ToDoAdapter;

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
}
