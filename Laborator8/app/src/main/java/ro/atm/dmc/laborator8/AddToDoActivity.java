package ro.atm.dmc.laborator8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class AddToDoActivity extends AppCompatActivity {

    EditText editText;
    Spinner spinner;

    String[] textPrioritati = new String[] {"Important", "Normal", "Se poate si mai tarziu"};
    int[] valoriPrioritati = new int[] {3,2,1};

    public static final String NUME_TEXT = "TEXT";
    public static final String NUME_PRIORITATE = "PRIORITATE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);

        editText = findViewById(R.id.editText);
        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<>(this,R.layout.support_simple_spinner_dropdown_item,textPrioritati);
        spinner.setAdapter(arrayAdapter);

        Button button = findViewById(R.id.buttonSave);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRaspuns = new Intent();
                if(editText.getText().toString().isEmpty()){
                    setResult(RESULT_CANCELED, intentRaspuns);
                }
                else{
                    String text = editText.getText().toString();
                    int prioritate = valoriPrioritati[spinner.getSelectedItemPosition()];
                    intentRaspuns.putExtra(NUME_TEXT, text);
                    intentRaspuns.putExtra(NUME_PRIORITATE, prioritate);
                    setResult(RESULT_OK, intentRaspuns);
                }
                finish();
            }
        });
    }
}
