package co.mobilemakers.todolisto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

/**
 * To-do task adapter to view it as a list item.
 *
 * Created by ariel.cattaneo on 04/02/2015.
 */
public class ToDoTaskAdapter extends ArrayAdapter<ToDoTaskModel> {

    Context mContext;
    List<ToDoTaskModel> mToDoList;

    public ToDoTaskAdapter(Context context, List<ToDoTaskModel> todoList) {
        super(context, R.layout.todo_task_entry, todoList);

        mContext = context;
        mToDoList = todoList;
    }

    private void displayContentInRowView(final int position, View rowView) {
        if (rowView != null) {
            TextView textTaskTitle = (TextView)rowView.findViewById(R.id.text_task_title);
            textTaskTitle.setText(mToDoList.get(position).getTitle());
            CheckBox checkTaskDone = (CheckBox)rowView.findViewById(R.id.checkbox_task);
            checkTaskDone.setChecked(mToDoList.get(position).getDone());

            checkTaskDone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mToDoList.get(position).setDone(isChecked);
                }
            });
        }
    }

    private View reuseOrGenerateRowView(View convertView, ViewGroup parent) {
        View rowView;
        if (convertView != null) {
            rowView = convertView;
        }
        else {
            LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.todo_task_entry, parent, false);
        }
        return rowView;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView;

        rowView = reuseOrGenerateRowView(convertView, parent);

        displayContentInRowView(position, rowView);

        return rowView;
    }

}
