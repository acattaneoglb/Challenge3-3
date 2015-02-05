package co.mobilemakers.todolisto;

import android.content.Context;

/**
 * Model of one to-do task.
 *
 * Created by ariel.cattaneo on 04/02/2015.
 */
public class ToDoTaskModel {

    String mTitle;
    Boolean mDone;
    static Context mContext;

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Boolean getDone() {
        return mDone;
    }

    public void setDone(Boolean done) {
        mDone = done;
    }

    public ToDoTaskModel(Context context, String title) {
        mContext = context;
        mTitle = title;
        mDone = false;
    }
}
