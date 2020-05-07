package ro.atm.dmc.laborator7;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TaskIncarcaDateVreme extends AsyncTask<String, Integer, DateVreme> {
    @Override
    protected DateVreme doInBackground(String... strings) {

        DateVreme rezultat = new DateVreme();

        try {
            URL url = new URL(strings[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder stringBuilder = new StringBuilder();
            String linieText = "";
            while((linieText = bufferedReader.readLine()) != null){
                stringBuilder.append(linieText);
            }

            JSONObject jsonObject = new JSONObject(stringBuilder.toString());
            //parsare si extragere date
            JSONObject headline = jsonObject.getJSONObject("Headline");
            String weather = headline.getString("Text");
            rezultat.setForecast(weather);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return rezultat;
    }
}
