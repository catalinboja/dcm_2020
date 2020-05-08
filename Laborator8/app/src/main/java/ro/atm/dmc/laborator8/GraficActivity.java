package ro.atm.dmc.laborator8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import ro.atm.dmc.laborator8.date.PieChart;

public class GraficActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new PieChart(getApplicationContext()));
    }
}
