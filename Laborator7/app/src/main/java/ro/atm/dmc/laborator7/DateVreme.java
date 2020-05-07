package ro.atm.dmc.laborator7;

public class DateVreme {

    String forecast;
    float temperatura;

    public DateVreme(){
        forecast = "";
        temperatura = 0;
    }

    public String getForecast() {
        return forecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }
}
