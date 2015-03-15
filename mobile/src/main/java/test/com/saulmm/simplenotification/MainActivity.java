package test.com.saulmm.simplenotification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import static android.support.v4.app.NotificationCompat.Action;
import static android.support.v4.app.NotificationCompat.Builder;
import static android.support.v4.app.NotificationCompat.WearableExtender;


@SuppressWarnings("UnnecessaryLocalVariable")
public class MainActivity extends ActionBarActivity {

    private final static int SIMPLE_NOTIFICATION_ID     = 1;
    private final static int ENRICHED_NOTIFICATION_ID   = 2;
    private final static int PAGED_NOTIFICATION_ID      = 3;

    private NotificationManagerCompat mNotificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNotificationManager = NotificationManagerCompat.from(this);
    }

    /**
     * Fires a notification that it has nothing to do with
     * the android wear sdk
     *
     * @param view who triggered the event
     */
    public void showBasicNotification(View view) {

        Builder nBuilder = new Builder(this)
            .setContentText("yum!")
            .setContentTitle("Hungry?")
            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.hamburger_background))
            .setSmallIcon(R.drawable.ic_android_black_24dp);

        mNotificationManager.notify(SIMPLE_NOTIFICATION_ID, nBuilder.build());
    }

    /**
     * Shows a notification on an android wear device enriched
     * with an action, that action is triggered by a pending intent which
     * fires an intent on the handheld device, tha intent opens a url in a browser
     *
     * @param view who triggered the event
     */
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

    /**
     * Shows a notification on the android wear device enriched
     * with two pages containing two recipes about how to cook a
     * cake
     *
     * @param view who triggered the event
     */
    public void showEnrichedPagedNotification(View view) {

        final String recipe1 = getString(R.string.recipe1);
        final String recipe2 = getString(R.string.recipe2);

        // Create builder for the main notification
        NotificationCompat.Builder notificationBuilder = new Builder(this)
            .setSmallIcon(R.drawable.ic_cake)
            .setContentTitle("Cakes recipes")
            .setContentText("Let's check some awesome recipes about cakes")
            .setLargeIcon(BitmapFactory.decodeResource(getResources(),
                R.drawable.chocolate_cake_background));

        // Extend the notification builder adding two pages
        Notification pagedNotification = notificationBuilder
            .extend(new NotificationCompat.WearableExtender()
                .addPage(createBigNotification("Chocolate cake", recipe1))
                .addPage(createBigNotification("Carrot pie", recipe2)))
            .build();

        // Launch the notification
        mNotificationManager.notify(PAGED_NOTIFICATION_ID,
            pagedNotification);
    }

    /**
     * Creates a notification with a bigstyle
     *
     * @param title of the notification
     * @param content of the notification
     * @return the notification created
     */
    private Notification createBigNotification (String title, String content) {

        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle();
        bigTextStyle.setBigContentTitle(title)
            .bigText(content);

        Notification bigNotification =
            new NotificationCompat.Builder(this)
                .setContentTitle(title)
                .setStyle(bigTextStyle)
                .build();

        return bigNotification;
    }
}
