package test.com.saulmm.simplenotification.adapters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.wearable.view.CardFragment;
import android.support.wearable.view.FragmentGridPagerAdapter;

import test.com.saulmm.simplenotification.model.Direction;

public class GridPickerAdapter extends FragmentGridPagerAdapter {

    private final Context mContext;
    private final Direction[][] mCakes;
    private final Drawable [] mBackgroundsForRows;

    public GridPickerAdapter(FragmentManager fm, Context context, Direction[][] cakes,
        Drawable [] backgroundsForRows) {

        super(fm);

        mBackgroundsForRows = backgroundsForRows;
        mContext = context;
        mCakes = cakes;
    }

    @Override
    public Fragment getFragment(int row, int column) {

        Direction currentCake = mCakes[row][column];

        CardFragment cardFragment = CardFragment.create(
            "Step #"+currentCake.getDirectionNumber(),
            currentCake.getDirectionDescription(),
            currentCake.getDirectionImage());

        return cardFragment;
    }

    @Override
    public int getRowCount() {

        return mCakes.length;
    }

    @Override
    public int getColumnCount(int row) {

        return mCakes[row].length;
    }

    @Override
    public Drawable getBackgroundForRow(int row) {

        return mBackgroundsForRows[row];
    }
}
