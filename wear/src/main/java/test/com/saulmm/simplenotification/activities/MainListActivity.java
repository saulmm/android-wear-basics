package test.com.saulmm.simplenotification.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WearableListView;

import test.com.saulmm.simplenotification.R;
import test.com.saulmm.simplenotification.adapters.MainListAdapter;

public class MainListActivity extends Activity
    implements WearableListView.ClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);

        String[] elements = getResources().getStringArray(R.array.ui_items);

        WearableListView listView = (WearableListView) findViewById(
            R.id.activity_main_list_listview);

        listView.setAdapter(new MainListAdapter(this, elements));
        listView.setClickListener(this);
    }

    @Override
    public void onClick(WearableListView.ViewHolder viewHolder) {

        Integer position = (Integer) viewHolder.itemView.getTag();
        Intent i = null;

        if (position == 0)
            i = new Intent (this, PickerActivity.class);

        if (position == 1)
            i = new Intent (this, WatchViewActivity.class);

        if (position == 2)
            i = new Intent (this, DismissActivity.class);

        if (i != null)
            startActivity(i);
    }

    @Override
    public void onTopEmptyRegionClick() {

    }
}
