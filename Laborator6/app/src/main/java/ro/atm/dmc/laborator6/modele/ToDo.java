package ro.atm.dmc.laborator6.modele;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import ro.atm.dmc.laborator6.R;

public class ToDo implements Serializable {
    private String text;
    private Date termenLimita;
    private boolean esteImportanta;
    private int imagine;

    public ToDo(String text, Date termenLimita, boolean esteImportanta) {
        this.text = text;
        this.termenLimita = termenLimita;
        this.esteImportanta = esteImportanta;
        if(this.esteImportanta)
            this.imagine = R.drawable.ic_todo_important;
        else
            this.imagine = R.drawable.ic_todo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTermenLimita() {
        return termenLimita;
    }

    public void setTermenLimita(Date termenLimita) {
        this.termenLimita = termenLimita;
    }

    public boolean isEsteImportanta() {
        return esteImportanta;
    }

    public void setEsteImportanta(boolean esteImportanta) {
        this.esteImportanta = esteImportanta;
    }

    public int getImagine() {
        return imagine;
    }

    public void setImagine(int imagine) {
        this.imagine = imagine;
    }

    @NonNull
    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return this.text + " - " + simpleDateFormat.format(this.termenLimita).toString();
    }

}
