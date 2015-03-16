package test.com.saulmm.simplenotification.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.DelayedConfirmationView;
import android.support.wearable.view.WatchViewStub;
import android.view.View;

import test.com.saulmm.simplenotification.R;

public class DismissActivity extends Activity
    implements WatchViewStub.OnLayoutInflatedListener, DelayedConfirmationView.DelayedConfirmationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dismiss);

        final WatchViewStub stub = (WatchViewStub) findViewById(
            R.id.activity_dismiss_watchviewstub);

        stub.setOnLayoutInflatedListener(this);
    }

    @Override
    public void onLayoutInflated(WatchViewStub watchViewStub) {

        DelayedConfirmationView delayedConfirmationView = (DelayedConfirmationView) watchViewStub
            .findViewById(R.id.round_activity_dismiss_delayed);

        delayedConfirmationView.setTotalTimeMs(5000);
        delayedConfirmationView.setListener(this);
        delayedConfirmationView.start();

    }

    /**
     * Called when the timer is finished.
     *
     * @param view who fires the event
     */
    @Override
    public void onTimerFinished(View view) {

        this.finish();
    }

    @Override
    public void onTimerSelected(View view) {

    }
}
