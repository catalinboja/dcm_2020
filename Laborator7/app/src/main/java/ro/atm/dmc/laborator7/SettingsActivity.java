package ro.atm.dmc.laborator7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        incarcaValoriSettings();
    }

    public void salvarePreferinte(View view){
        EditText editApi = findViewById(R.id.editTextAPIKey);
        String api = editApi.getText().toString();
        EditText editOras = findViewById(R.id.editTextID);
        int id = Integer.parseInt(editOras.getText().toString());

        InterfataPreferinte.scriePrefString(getApplicationContext(), "APIKey", api);
        InterfataPreferinte.scriePrefInt(getApplicationContext(), "IDOras", id);

        this.finish();
    }

    private void incarcaValoriSettings() {

        String api = InterfataPreferinte.citestePrefString(getApplicationContext(),"APIKey");
        int id = InterfataPreferinte.citestePrefInt(getApplicationContext(), "IDOras");

        EditText editApi = findViewById(R.id.editTextAPIKey);
        EditText editOras = findViewById(R.id.editTextID);

        editApi.setText(api);
        editOras.setText(id+"");
    }
}
