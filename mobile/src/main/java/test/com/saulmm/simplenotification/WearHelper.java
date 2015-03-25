package test.com.saulmm.simplenotification;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;


public class WearHelper implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private static WearHelper INSTANCE;
    private GoogleApiClient mGoogleApiClient;
    private Context mContext;

    private WearHelper () {}

    public static WearHelper getInstance () {

        if (INSTANCE == null)
            INSTANCE = new WearHelper();

        return INSTANCE;
    }

    public void init (Context context) {

        mContext = context.getApplicationContext();

        initGoogleApiClient();
    }

    private void initGoogleApiClient() {

        mGoogleApiClient =  new GoogleApiClient.Builder(mContext)
            .addConnectionCallbacks(this)
            .addOnConnectionFailedListener(this)
            .build();

        mGoogleApiClient.connect();
    }


    @Override
    public void onConnected(Bundle bundle) {

        Toast.makeText(mContext, "Connected", Toast.LENGTH_SHORT)
            .show();
    }

    @Override
    public void onConnectionSuspended(int i) {

        Toast.makeText(mContext, "Wear connection suspended", Toast.LENGTH_SHORT)
            .show();
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

        Toast.makeText(mContext, "Wear connection failed", Toast.LENGTH_SHORT)
            .show();
    }
}
