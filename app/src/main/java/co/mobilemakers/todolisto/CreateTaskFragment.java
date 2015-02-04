package co.mobilemakers.todolisto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class CreateTaskFragment extends Fragment {

    EditText mEditTaskTitle;
    Button mButtonDone;

    public CreateTaskFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_create_task, container, false);

        mEditTaskTitle = (EditText)rootView.findViewById(R.id.edit_text_task_title);
        mButtonDone = (Button)rootView.findViewById(R.id.button_done);
        mButtonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = getActivity();
                if (mEditTaskTitle.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), R.string.no_title_no_task, Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent();
                    intent.putExtra(Intent.EXTRA_TEXT, mEditTaskTitle.getText().toString());
                    activity.setResult(Activity.RESULT_OK, intent);
                }
                getActivity().finish();
            }
        });

        return rootView;
    }
}
