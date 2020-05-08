package ro.atm.dmc.laborator8.date;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.Random;

public class PieChart extends View {

    Context context;

    public PieChart(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        ToDoDatabase toDoDatabase = ToDoDatabase.getBazaDate(context);
        ToDoDAO toDoDAO = toDoDatabase.toDoDAO();
        int toDoImportante = toDoDAO.countToDo(3);
        int toDoNormale = toDoDAO.countToDo(2);
        int toDoNeImportante = toDoDAO.countToDo(1);

        int total = toDoImportante + toDoNormale + toDoNeImportante;

        int valori[] = new int[]{toDoImportante, toDoNormale, toDoNeImportante};

        Paint paint = new Paint();
        Random random = new Random();
        float unghiStart = 0;
        for(int i = 0; i < 3; i++){
            paint.setColor(Color.rgb(random.nextInt(256),
                    random.nextInt(256), random.nextInt(265)));
            float unghi = valori[i] * 360 / total ;
            canvas.drawArc(50,50,500,500, unghiStart,
                    unghi, true, paint);
            unghiStart += unghi;
        }

    }
}
