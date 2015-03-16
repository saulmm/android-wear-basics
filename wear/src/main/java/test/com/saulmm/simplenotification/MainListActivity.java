package test.com.saulmm.simplenotification;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WearableListView;
import android.widget.Toast;

public class MainListActivity extends Activity
    implements WearableListView.ClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list);

        String[] elements = getResources().getStringArray(R.array.ui_items);

        WearableListView listView = (WearableListView) findViewById(
            R.id.activity_main_list_listview);

        listView.setAdapter(new Adapter(this, elements));
        listView.setClickListener(this);
    }

    @Override
    public void onClick(WearableListView.ViewHolder viewHolder) {

        Integer position = (Integer) viewHolder.itemView.getTag();
        Toast.makeText(this, "Clicked: "+position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTopEmptyRegionClick() {

    }
}
