(Written by John Kim)
Title: Kidney User Interface


Description 
:
This kidney user interface app is designed to display a patien-
t's information including name, gender, kidney threshold pressure value, an-
d a plot of his or her pressure vs time and to notify a user if any patient's
kidney pressure exceeds his or her threshold pressure value. 


Details about the app and usage
:
-The app has four activities or simply screens. They consist of 
login (main) activity, options activity, patient information activity, and 
graph activity. When the app is activated, a user is guided to a login page. 
When the login button in the login activity is pressed, the user is transfer-
red to options activity. In the options activity, the user may see two 
buttons: a button to patient's information activity, another button to 
graph activity. When either is button is pressed, the user is transferred
accordingly. In the patient's information activity, the user will be provid-
ed with the patient's information mentioned in the description above.
. And in the graph activity, the user has access to a plot of the 
patient's pressure vs time. In both patient's information activity 
and graph activity, users are provided with a return button which allows
them to return to options activity.


-There is a notification feature for a patient's pressure value exceeding his or her 
threshold pressure value. When a patient's current pressure surpasses his
or her threshold pressure value, the user's device will vibrate for 0.5 seco-
nd, and the user will receive a notification on his or her notification
bar of his or her device.


About the source code
:
-The app project file contains four Java files. There is one Java file for
each activity. However, for the login activity, the corresponding Java file
is not named after login activity, but after main activity. Developers may 
need to pay attention to this.

-In order to see the XMLs (design information about this app), it would be 
relatively good to use Android Studio. 

-One noticeable input to the app would be a pressing action 
on any button. If a user presses a button, an onClick method call is activated
in the code. As an output to this physical input, the user would be transferred to 
another activity. 

-It is also recommended for a developer to consider inputs to the g-
raph activity. For now, a tangent plot is given by the original developer
as an example for showing how it works.However, 
developers can manipulate (x,y) points to display in the plot activity. 

-As a little comment on how to run this app in other devices, the original developer 
recommends other developers go to File on the top of Android Studio, click and ope-
n project structure, go to modules and default config, and change
Target SDK version corresponding to the API version of target devices. 

-For the notification feature, the original developer added an intent for a 
notification manager. Developers can change the message, title, and icon of 
notification depending on their purposes in the code. However,the initial developer 
did not have proper values for a patient's pressure value and threshold value 
for the notification feature. Therefore, the developer set some random
values for testing this notification feature. Deverlopers are encouraged to add 
a method that collects real-time pressure data from the kidney pressure reading
hardware device. 


Features to be updated
:
-It would be nice to add strong databases for patients' information and log-
in information. 

-And it is necessary to update the pressure plot with real-ti-
me pressure values. For this suggestion, it would be good to build
a Bluetooth connection between the pressure reader and this app. This way,
it would be possible to collect real-time data from the hardware device and 
update to the plot. Also, based on the real-time data, we can add a valid 
notification. 




 

