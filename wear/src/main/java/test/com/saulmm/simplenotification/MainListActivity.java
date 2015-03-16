package test.com.saulmm.simplenotification;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WearableListView;

public class MainListActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);

        String[] elements = getResources().getStringArray(R.array.ui_items);

        WearableListView listView = (WearableListView) findViewById(
            R.id.activity_main_list_listview);

        listView.setAdapter(new Adapter(this, elements));
    }
}
