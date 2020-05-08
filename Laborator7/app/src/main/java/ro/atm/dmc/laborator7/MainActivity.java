package ro.atm.dmc.laborator7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //salvare API Key
        String api = InterfataPreferinte.citestePrefString(this,"APIKey");
        if(api.isEmpty()){
            //TODO: trebuie initializata cu o valoare predefinita
            InterfataPreferinte.scriePrefString(this,
                    "APIKey", "aaaaaaaaaaaaaa");
        }
    }

    public void deschideSettings(View view){
        Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
        startActivity(intent);
    }

    public void incarcaDateVreme(View view) {

        final TextView textViewInfo = findViewById(R.id.textViewData);

        TaskIncarcaDateVreme taskIncarcaDateVreme =
                new TaskIncarcaDateVreme() {
                    @Override
                    protected void onPostExecute(DateVreme dateVreme) {
                        //preiau rezultatul
                        String text;
                        text = dateVreme.getForecast();
                        textViewInfo.setText(text);
                        super.onPostExecute(dateVreme);
                    }
                };
        //Your API Key
        //TODO: trebuie initializata cu o valoare predefinita
        String apiKey = "aaaaaaaaaaaaaa";
        //sau se preia din preferinte
        apiKey = InterfataPreferinte.citestePrefString(getApplicationContext(),"APIKey");

        taskIncarcaDateVreme.execute("http://dataservice.accuweather.com/forecasts/v1/daily/1day/287430?apikey="+apiKey+"&metric=true");
    }
}
