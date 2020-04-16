package ro.atm.dmc.laborator3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int COD_SETTINGS = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //versiunea 2 de click handler
//        Button btnAbout = findViewById(R.id.buttonAbout);
//        btnAbout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast toast = Toast.makeText(getApplicationContext(),
//                        R.string.textInfoApp, Toast.LENGTH_SHORT);
//                toast.show();
//            }
//        });

        //utilizare versiune 3
        Button btnAbout = findViewById(R.id.buttonAbout);
        btnAbout.setOnClickListener(this);
    }

    //versiunea 1 de click handler
    public void actiuneClickButon(View view){
        //afisam textul si in textView
        TextView textViewInfo = (TextView) findViewById(R.id.textViewInfo);
        textViewInfo.setText(R.string.app_name);

        Button btnInfo = (Button) findViewById(R.id.buttonInfo);
        btnInfo.setText("Buton apasat");

        //afisam un Toast
        Toast toastInfo = Toast.makeText(
                getApplicationContext(), "Aplicatie Laborator 3 v0.1",
                Toast.LENGTH_SHORT);
        toastInfo.show();
    }

    //versiunea 3 de click handler
    @Override
    public void onClick(View v) {

        TextView txtView = findViewById(R.id.textViewInfo);

        //verificam id-ul butonului apasat
        if(v.getId() == R.id.buttonAbout){
            txtView.setText("S-a apasat About");
        }
        if(v.getId() == R.id.buttonInfo){
            txtView.setText("S-a apasat Info");
        }
    }

    public void clickActionSettings(View view){
        Intent intent = new Intent(getApplicationContext(),SettingsActivity.class);
        Bundle dateSettings = new Bundle();
        dateSettings.putString("IP","192.168.1.1");
        dateSettings.putInt("Port", 90000);
        intent.putExtras(dateSettings);

        //lansare activitate fara a astepta rezultat
        //startActivity(intent);

        startActivityForResult(intent, COD_SETTINGS );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent intentRaspuns) {
        super.onActivityResult(requestCode, resultCode, intentRaspuns);
        if(requestCode == COD_SETTINGS && resultCode == RESULT_OK){

            String ipPrimit =
                    intentRaspuns.getExtras().getString("NewIP");
            String portPrimit =
                    intentRaspuns.getExtras().getString("newPort");
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Ne contectam la "+ipPrimit+":"+portPrimit,
                    Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
