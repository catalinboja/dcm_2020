package ro.atm.dmc.laborator5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SetariActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] listaServere = {"Server Test", "Server Productie 1", "Server Productie 2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setari);

        //incarc date in Spinner
        Spinner spinnerServer = this.findViewById(R.id.spinnerSelectieServer);
        //definire adaptor date
        ArrayAdapter adaptorDate = new ArrayAdapter(
                this,R.layout.support_simple_spinner_dropdown_item, listaServere);
        spinnerServer.setAdapter(adaptorDate);
        //ne abonam la evenimentul de tip click pe element spinner
        spinnerServer.setOnItemSelectedListener(this);

        Log.i("LABORATOR5","Start activitate Setari");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Log.i("LABORATOR5","Eveniment selectie element spinner");

        String optiuneSelectata = parent.getItemAtPosition(position).toString();

        Toast.makeText(this,"Ai selectat " + optiuneSelectata, Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
