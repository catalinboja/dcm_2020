package ro.atm.dmc.laborator8.adaptoare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import ro.atm.dmc.laborator8.R;
import ro.atm.dmc.laborator8.date.ToDo;
import ro.atm.dmc.laborator8.date.ToDoSursaDate;

public class ToDoAdapter extends BaseAdapter {

    private Context context;
    ToDoSursaDate toDoSursaDate;

    public ToDoAdapter(Context context) {
        this.context = context;
        toDoSursaDate = new ToDoSursaDate(context);
    }

    @Override
    public int getCount() {
        return toDoSursaDate.getToDoList().size();
    }

    @Override
    public Object getItem(int position) {
        return toDoSursaDate.getToDoList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return toDoSursaDate.getToDoList().get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.todo_item,parent,false);

        TextView textView = view.findViewById(R.id.textView);
        ToDo toDo = (ToDo) getItem(position);
        textView.setText(toDo.toString());
        return view;
    }

    public void add(ToDo toDo){
        toDoSursaDate.insert(toDo);
        notifyDataSetChanged();
    }
}
