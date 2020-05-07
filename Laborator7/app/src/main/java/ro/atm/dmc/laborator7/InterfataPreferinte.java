package ro.atm.dmc.laborator7;

import android.content.Context;
import android.content.SharedPreferences;

public class InterfataPreferinte {

    private static final String numePref = "MobileWeather";

    public static void scriePrefString(Context context, String cheie, String valoare){
        SharedPreferences pref = context.getSharedPreferences(numePref, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(cheie,valoare);
        editor.commit();
    }

    public static void scriePrefInt(Context context, String cheie, Integer valoare){
        SharedPreferences pref = context.getSharedPreferences(numePref, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(cheie,valoare);
        editor.commit();
    }

    public static String citestePrefString(Context context, String cheie) {
        SharedPreferences pref = context.getSharedPreferences(numePref, Context.MODE_PRIVATE);
        String valoare = pref.getString(cheie, "");
        return valoare;
    }

    public static int citestePrefInt(Context context, String cheie) {
        SharedPreferences pref = context.getSharedPreferences(numePref, Context.MODE_PRIVATE);
        int valoare = pref.getInt(cheie, 0);
        return valoare;
    }

}
