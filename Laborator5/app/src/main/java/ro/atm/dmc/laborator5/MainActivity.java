package ro.atm.dmc.laborator5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;

public class MainActivity extends AppCompatActivity {

    //definire id-uri unice pentru optiunile din meniu
    public final int ID_MENU_DATE_CONEXIUNE = 1;
    public final int ID_MENU_SETARI = 2;
    public final int ID_MENU_ABOUT = 3;
    public final int ID_MENU_EXIT = 4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //pentru supradefinire de evenimente standard Ctrl + O

    //pentru varianta programatica
/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //definire meniu in varianta programatica

        //adaug un sub meniu
        SubMenu subMeniuDate = menu.addSubMenu(R.string.menuDate);

        subMeniuDate.add(Menu.NONE,ID_MENU_DATE_CONEXIUNE,Menu.NONE, R.string.menuDate_Conexiune);
        subMeniuDate.add(R.string.menuDate_PreiaDate);

        //adaugare alte optiuni meniu
        menu.add(Menu.NONE,ID_MENU_SETARI,Menu.NONE, R.string.menuSetari);
        menu.add(Menu.NONE,ID_MENU_ABOUT, Menu.NONE, R.string.menuAbout);
        menu.add(Menu.NONE,ID_MENU_EXIT,Menu.NONE, R.string.menuExit);

        return true;
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        //verificam ce optiune din meniu a fost selectata
        //tratam optiunea Exit
        if(item.getItemId() == ID_MENU_EXIT){
            //inchid aplicatia
            this.finishAndRemoveTask();
            //trec aplicatia in backgtround
            //this.finish();
            return true;
        }
        if(item.getItemId() == ID_MENU_SETARI){
            Intent intentSetari = new Intent(this, SetariActivity.class);
            startActivity(intentSetari);
        }

        return false;
    }

    //actiune specifica optiunii din meniu
    public void onExitMenuItem(MenuItem menuItem){
    //actiuni pentru exit
    this.finishAndRemoveTask();
}
}
