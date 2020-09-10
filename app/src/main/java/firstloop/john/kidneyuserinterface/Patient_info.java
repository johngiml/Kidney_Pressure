//The following code is responsible for showing patient's information (gender, threshold pressure value, and name).
//This activity starts when the user presses patient's information button from the options activity.
//A database is required for this class because we need to import a patient's information from it and display it.

package firstloop.john.kidneyuserinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Patient_info extends AppCompatActivity {

    private Button returnbutton2; //Initializing a return button. It returns to the options screen.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_info);

    returnbutton2 = (Button) findViewById(R.id.OptionReturnButton2); //casting button class to this return button.

    returnbutton2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(new Intent(Patient_info.this, Option_Activity.class));
            //The current activity (or screen) moves to the options activity when the button is pressed.
        }
    });


    }
}