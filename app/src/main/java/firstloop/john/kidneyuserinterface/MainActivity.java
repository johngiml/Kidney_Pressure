//The following code creates a login screen. We need a database for login information.
//Then, based on the database, we need to create something that can check if a user inputs correct user information.


package firstloop.john.kidneyuserinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.app.VoiceInteractor;

import android.content.Intent; //Intent is needed for moving to another activity

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast; //Toast message required for letting the user know if he or she gave the wrong information.

public class MainActivity extends AppCompatActivity {
    private EditText userID, password; //setting variables for userID and password
    private Button login; //initializing login button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);

        //casting edittext and button classes to all the variables set above.

        userID = (EditText) findViewById(R.id.UserName);
        password = (EditText) findViewById(R.id.Password);
        login = (Button) findViewById(R.id.Login);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //This method call moves the current screen to the option screen.

                if(validate(userID, password)){
                    startActivity(new Intent(MainActivity.this, Option_Activity.class));
                }

            }
        });



    }//end of  oncreate method.





    //The following method is responsible for checking if the user left either userID or password empty.
    //If this method returns a true, it means that both userID and password are filled.
    //If this method returns a false, it means that either userID or password is empty.
    private Boolean validate(EditText a, EditText b) {

        Boolean result1 = false; // This variable is responsible for checking if userID is empty

        Boolean result2 = false; // This variable is responsible for checking if password is empty

        Boolean result = false; // The output of this method


        String ID = a.getText().toString(); //This receives a text from user ID textbox and turns the input into a string.
        String pw = b.getText().toString(); //This receives a text from user password textbox and turns the input into a string.

        //The following if else block checks if userID is empty.
        if(ID.isEmpty()) //This condition checks if userID is empty
        {
            //sending an error message if it is empty
            Toast.makeText(this, "Please enter a valid ID.",Toast.LENGTH_SHORT).show();

        } else{
            result1 = true; //if some user ID is provided, this method returns true.
        }

        //The following if else block checks if userID is empty.
        if(pw.isEmpty())  //This condition checks if password is empty
        {
            //sending an error message if it is empty
            Toast.makeText(this, "Please enter a valid password.",Toast.LENGTH_SHORT).show();
        } else{
            result2 = true; //if some password is provided, this method returns true.
        }


        result = result1 && result2; //We creat the final return value from combining both return values from the if-else blocks above.

        return result;

    }

}












