package test.com.saulmm.simplenotification;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    private NotificationManagerCompat nManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showNotification(View view) {

        Context context = this;
        int notificationID = 1;

        NotificationManagerCompat nManager = NotificationManagerCompat.from(context);

        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(this)
            .setContentText("yum!")
            .setContentTitle("Hungry?")
            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.hamburger))
            .setSmallIcon(R.drawable.ic_android_black_24dp);

        nManager.notify(notificationID, nBuilder.build());
    }
}
