package test.com.saulmm.simplenotification;

import android.content.Context;
import android.support.wearable.view.WearableListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressWarnings("UnnecessaryLocalVariable")
public class Adapter extends WearableListView.Adapter {

    private String[] mDataset;
    private final Context mContext;


    public Adapter(Context context, String[] dataset) {

        mContext = context;
        mDataset = dataset;
    }

    public static class ItemViewHolder extends WearableListView.ViewHolder {

        private TextView textView;

        public ItemViewHolder(View itemView) {

            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.name);
        }
    }

    @Override
    public WearableListView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View rootView = LayoutInflater.from(mContext).inflate(R.layout.item_main_list, null);
        ItemViewHolder rowViewHolder = new ItemViewHolder(rootView);

        return rowViewHolder;
    }


    @Override
    public void onBindViewHolder(WearableListView.ViewHolder holder, int position) {

        ItemViewHolder itemHolder = (ItemViewHolder) holder;

        TextView view = itemHolder.textView;
        view.setText(mDataset[position]);

        // This is used to retrieve the position at the main activity
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}