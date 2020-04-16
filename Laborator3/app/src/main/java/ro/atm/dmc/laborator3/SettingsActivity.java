package ro.atm.dmc.laborator3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //obtinem valorile primite prin Intent
        Bundle datePrimite = this.getIntent().getExtras();
        String ip = datePrimite.getString("IP");
        int port = datePrimite.getInt("Port");

        EditText txtServer = findViewById(R.id.editTextServer);
        txtServer.setText(ip);
        EditText txtPort = findViewById(R.id.editTextPort);
        txtPort.setText(port+"");
    }

    public void actionClickSave(View view){
        EditText txtServer = findViewById(R.id.editTextServer);
        EditText txtPort = findViewById(R.id.editTextPort);

        Intent intentRaspuns = new Intent();

        intentRaspuns.putExtra("NewIP", txtServer.getText().toString());
        intentRaspuns.putExtra("newPort", txtPort.getText().toString());



        this.setResult(RESULT_OK, intentRaspuns);
        this.finish();
    }
}
