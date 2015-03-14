package test.com.saulmm.simplenotification;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    private final static int SIMPLE_NOTIFICATION_ID = 1;

    private NotificationManagerCompat mNotificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNotificationManager = NotificationManagerCompat.from(this);
    }

    public void showBasicNotification(View view) {

        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(this)
            .setContentText("yum!")
            .setContentTitle("Hungry?")
            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.hamburger))
            .setSmallIcon(R.drawable.ic_android_black_24dp);

        mNotificationManager.notify(SIMPLE_NOTIFICATION_ID, nBuilder.build());
    }

    public void showEnrichedNotification(View view) {

    }
}
