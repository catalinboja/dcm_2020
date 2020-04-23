package ro.atm.dmc.laborator6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import ro.atm.dmc.laborator6.modele.ToDo;

public class AdaugaToDoActivity extends AppCompatActivity {

    EditText textData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_to_do);

        textData = findViewById(R.id.editTextData);
        //dezactiveaza editarea
        textData.setInputType(InputType.TYPE_NULL);
        //deschidem calendar pe click
        textData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int zi = calendar.get(Calendar.DAY_OF_MONTH);
                int luna = calendar.get(Calendar.MONTH);
                int an = calendar.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        AdaugaToDoActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                //obtinem data selectata de utilizator
                                String dataSelectata =
                                        dayOfMonth + "-" + (month+1) + "-" + year;
                                textData.setText(dataSelectata);
                            }
                        }, an, luna, zi);
                datePickerDialog.show();
            }
        });
    }

    public void butonOkClick(View view) throws ParseException {

        EditText textToDo = findViewById(R.id.editTextToDo);
        String text = textToDo.getText().toString();
        EditText textData =  findViewById(R.id.editTextData);
        String termenLimita = textData.getText().toString();

        Switch switchEsteImportant = findViewById(R.id.switchImportant);
        boolean esteImportant = switchEsteImportant.isChecked();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        ToDo toDo = new ToDo(text,simpleDateFormat.parse(termenLimita),esteImportant);

        MainActivity.toDoAdapter.adaugaElement(toDo);

        this.finish();

    }

    public void butonCancelClick(View view){
        this.finish();
    }
}
