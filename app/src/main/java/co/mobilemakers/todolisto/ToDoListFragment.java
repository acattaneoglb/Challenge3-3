package co.mobilemakers.todolisto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ToDoListFragment extends ListFragment {

    public final static int REQUEST_TASK_TITLE = 1;

    ToDoTaskAdapter mAdapter;

    public ToDoListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_todo_list, container, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_todo_list_fragment, menu);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        prepareListView();
    }

    private void prepareListView() {
        List<ToDoTaskModel> entries = new ArrayList<>();
        mAdapter = new ToDoTaskAdapter(getActivity(), entries);
        setListAdapter(mAdapter);
    }

    protected void callCreateTaskActivity() {
        Intent intent = new Intent(getActivity(), CreateTaskActivity.class);
        startActivityForResult(intent, REQUEST_TASK_TITLE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuId = item.getItemId();
        Boolean handled = false;

        switch (menuId) {
            case R.id.add_todo_task:
                callCreateTaskActivity();
                handled = true;
                break;
        }

        if (!handled) {
            handled = super.onOptionsItemSelected(item);
        }

        return handled;
    }

    private void addToDoTask(String title) {
        ToDoTaskModel todoTask = new ToDoTaskModel(getActivity(), title);
        mAdapter.add(todoTask);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_TASK_TITLE) {
            if (resultCode == Activity.RESULT_OK) {
                addToDoTask(data.getStringExtra(Intent.EXTRA_TEXT));
            }
        }
    }

}
