package test.com.saulmm.simplenotification.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.DelayedConfirmationView;
import android.support.wearable.view.WatchViewStub;
import android.view.View;

import test.com.saulmm.simplenotification.R;

public class DismissActivity extends Activity
    implements WatchViewStub.OnLayoutInflatedListener, DelayedConfirmationView.DelayedConfirmationListener {

    private boolean mCanceled;
    private View mCanceledMessage;

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

        final DelayedConfirmationView delayedConfirmationView = (DelayedConfirmationView) watchViewStub
            .findViewById(R.id.activity_dismiss_delayed);

        mCanceledMessage = watchViewStub.findViewById(
            R.id.activity_dismiss_message);

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

        if (!mCanceled)
            this.finish();
    }

    /**
     * Called when the user taps into the DelayedConfirmation view
     *
     * @param view who fires the event
     */
    @Override
    public void onTimerSelected(View view) {

        ((View) view.getParent()).animate()
            .alpha(0).start();

        mCanceledMessage.animate()
            .setStartDelay(500)
            .alpha(1).start();

        mCanceled = true;
    }
}
