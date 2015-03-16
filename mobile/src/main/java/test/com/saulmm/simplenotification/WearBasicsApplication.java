package test.com.saulmm.simplenotification;

import android.app.Application;

public class WearBasicsApplication extends Application {

    @Override
    public void onCreate() {

        super.onCreate();
        WearHelper.getInstance().init(this);
    }
}
