package ro.atm.dmc.laborator6.modele;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

import ro.atm.dmc.laborator6.R;

public class ToDoAdapter extends BaseAdapter {

    List<ToDo> toDoList;
    Context context;

    public ToDoAdapter(List<ToDo> toDoList, Context context) {
        this.toDoList = toDoList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return toDoList.size();
    }

    @Override
    public Object getItem(int position) {
        return toDoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        //de returnat un id unic pentru fiecare element ToDo
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View viewToDo = layoutInflater.inflate(R.layout.todo_item_layout, parent, false);

        ImageView iv = viewToDo.findViewById(R.id.imageView);
        TextView textViewData = viewToDo.findViewById(R.id.text1);
        TextView textViewText = viewToDo.findViewById(R.id.text2);

        ToDo toDo = toDoList.get(position);
        iv.setImageResource(toDo.getImagine());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        textViewData.setText(simpleDateFormat.format(toDo.getTermenLimita()));
        textViewText.setText(toDo.getText());

        //activare meniu contextual pe long click
        viewToDo.setLongClickable(true);

        return viewToDo;
    }

    public void stergeElement(int pozitie){
        toDoList.remove(pozitie);
        //notificare view cu privire la modificarea datelor
        notifyDataSetChanged();
    }

    public void adaugaElement(ToDo toDo){
        toDoList.add(toDo);
        notifyDataSetChanged();
    }


}
