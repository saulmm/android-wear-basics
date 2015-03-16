package test.com.saulmm.simplenotification.activities;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.wearable.view.GridViewPager;

import test.com.saulmm.simplenotification.R;
import test.com.saulmm.simplenotification.adapters.GridPickerAdapter;
import test.com.saulmm.simplenotification.model.Direction;

public class PickerActivity extends Activity {

    private GridViewPager mGridViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);

        mGridViewPager = (GridViewPager) findViewById(R.id.activity_picker_pager);

        String [] chocolateCakeDirections   = getResources().getStringArray(
            R.array.recipe1_directions);

        String [] carrotPieDirections       = getResources().getStringArray(
            R.array.recipe2_directions);

        Drawable[] backgrounds = new Drawable[] {
            getResources().getDrawable(R.drawable.chocolate_cake_background),
            getResources().getDrawable(R.drawable.carrot_pie_backgorund)
        };

        int columns = Math.max(chocolateCakeDirections.length, carrotPieDirections.length);
        Direction[][] cakeMatrix = new Direction[2][columns];

        for (int i = 0; i < chocolateCakeDirections.length; i++) {

            Direction direction = new Direction((i + 1), chocolateCakeDirections[i],
                R.drawable.ic_choc_cake);

            cakeMatrix[0][i] = direction;
        }

        for (int i = 0; i < carrotPieDirections.length; i++) {

            Direction direction = new Direction((i + 1), carrotPieDirections[i],
                R.drawable.ic_carrot_cake);

            cakeMatrix[1][i] = direction;
        }

        mGridViewPager.setAdapter(new GridPickerAdapter(
            getFragmentManager(), this, cakeMatrix, backgrounds));
    }
}
