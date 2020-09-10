//This activity or block of code provides two options for the user (patient's information and graph).
//Users can access this activity when they successfully log in from the login activity.

package firstloop.john.kidneyuserinterface;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import android.os.Vibrator;
import android.view.View;

import android.widget.Button;



public class Option_Activity<ThresholdValue, PressureValue> extends AppCompatActivity {

    private Button patientbutton; //button 1: patient's info

    private Button pressurebutton; //button 2: pressure history






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        double ThresholdValue = 3; //test threshold value, developers are encouraged to set it to something realistic.
        double PressureValue = 4;


        //testing notifications and vibration for pressure value exceeding threshold pressure value.
        if(PressureValue > ThresholdValue)
        {
            vibration(); //calling a vibrating method. It will make the device vibrate.
            addNotification(); //calling notification method. It will create a notification.
        }


        patientbutton = (Button) findViewById(R.id.PatientInfoButton); //casting button class to patientbutton

        pressurebutton = (Button) findViewById(R.id.PressureHistoryButton); //casting button class to pressurebutton

        pressurebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This method call is responsible for moving to graphactivity from the current activity or screen
                startActivity(new Intent(Option_Activity.this, GraphActivity.class)); //starting a new intent: moving to graph_activity

            }
        });

        patientbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This method call is responsible for moving to patient_info activity from the current activity or screen
                startActivity(new Intent(Option_Activity.this, Patient_info.class));  //starting a new intent: moving to options_activity
            }
        });

    }




//The following method is responsible for vibration for the threshold value.
    private void vibration () {
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(500); //500 ms and 0.5s. Users' devices will vibrate for 0.5s.
    } //end of vibration method




        /*The following method builds a notification. Developers can change the message, title, and icon of
        the notification by changing small icon, content title, and text(message).
        */

    private void addNotification (){

        Intent intent = new Intent(this, Option_Activity.class);
        // We need an intent to start a notification operation.

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        //PendingIntent is a token that you give to a foreign application which allows the foreign application
        // to use our application's permissions to execute our intent. In our case, the foreign application is notificationCompat.builder below.
        // Context is like a handle to the environment our app is running.
        //In our case, context is our current activity. requestcode is designed to help us to identify from which intent we came back.


        // Starting in Android 8.0, all notifications are assigned to a channel.
        String channelId = "Channel_1";

        NotificationCompat.Builder notificationBuilder = //We build a notification builder. Developers can change the title, text, and icon of the notification.
                new NotificationCompat.Builder(this, channelId) //notificationcompat is a helper for accessing features in notification.
                        .setSmallIcon(R.mipmap.ic_launcher_round)
                        .setContentTitle("Kidney Pressure Warning!") //You can change the notification title.
                        .setContentText("J's pressure exceeded his threshold value on Sept 6th at 12:00 PM") //You can change the notification message.
                        .setContentIntent(pendingIntent); //We feed the builder with the pending intent.

        NotificationManager notificationManager = //We need a notifcation manager in order to display our notification.
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Starting in Android 8.0, all notifications are assigned to a channel.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(channelId,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_DEFAULT);
            //importance_default correspond to the level of interruption a notification can cause (i.e sound, no sound)
            notificationManager.createNotificationChannel(channel);
        }

        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build()); // Now we notify the user with our notificationmanager.
    } //end of addNotification method


} //end of the activity


