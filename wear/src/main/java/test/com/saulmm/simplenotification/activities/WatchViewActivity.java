package test.com.saulmm.simplenotification.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.widget.TextView;

import test.com.saulmm.simplenotification.R;

public class WatchViewActivity extends Activity implements WatchViewStub.OnLayoutInflatedListener{

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // A WatchViewStub allows for the use of different sub-layouts depending
        // on the shape of the device screen
        WatchViewStub stub = (WatchViewStub) findViewById(R.id.watch_view_stub);
        stub.setOnLayoutInflatedListener(this);
    }

    /**
     * Listener for detecting when internal layout inflation has completed.
     * This is where you can reference your views
     *
     * @param watchViewStub the view containing your layout elements
     */
    @Override
    public void onLayoutInflated(WatchViewStub watchViewStub) {

        mTextView = (TextView) watchViewStub.findViewById(R.id.text);
        mTextView.setText("Now we can talk");
    }
}
