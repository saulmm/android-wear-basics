package test.com.saulmm.simplenotification;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import static android.support.v4.app.NotificationCompat.Action;
import static android.support.v4.app.NotificationCompat.Builder;
import static android.support.v4.app.NotificationCompat.WearableExtender;


public class MainActivity extends ActionBarActivity {

    private final static int SIMPLE_NOTIFICATION_ID = 1;
    private final static int ENRICHED_NOTIFICATION_ID = 1;

    private final static String PLAY_SOUND_ACTION = "play_sound";

    private NotificationManagerCompat mNotificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNotificationManager = NotificationManagerCompat.from(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {

        super.onNewIntent(intent);

        if (intent.getAction().equals(PLAY_SOUND_ACTION)) {

            final ToneGenerator tg = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
            tg.startTone(ToneGenerator.TONE_PROP_BEEP);
        }
    }

    public void showBasicNotification(View view) {

        Builder nBuilder = new Builder(this)
            .setContentText("yum!")
            .setContentTitle("Hungry?")
            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.hamburger_background))
            .setSmallIcon(R.drawable.ic_android_black_24dp);

        mNotificationManager.notify(SIMPLE_NOTIFICATION_ID, nBuilder.build());
    }


    public void showEnrichedNotification(View view) {

        Intent letMeEatEvent = new Intent(Intent.ACTION_VIEW);
        letMeEatEvent.setData(Uri.parse("http://www.cakeshautecouture.com/"));

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, letMeEatEvent, 0);

        Action action = new Action.Builder(R.drawable.ic_cake,
            "Show me cakes", pendingIntent)
            .build();

        Builder nBuilder = new Builder(this)
            .setContentText("Cakes are really nice")
            .setContentTitle("It would be nice to buy a cake")
            .extend(new WearableExtender().addAction(action))
            .setSmallIcon(R.drawable.ic_cake)
            .setLargeIcon(BitmapFactory.decodeResource(getResources(),
                R.drawable.cake_background));

        mNotificationManager.notify(ENRICHED_NOTIFICATION_ID, nBuilder.build());
    }

    public void showEnrichedPargedNotification(View view) {

    }
}
