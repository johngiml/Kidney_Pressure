//The following code is responsible for creating a plot of pressure data points collected from the hardware inside the patient's body.
//A real-time data collecting Bluetooth connection needs to be established to update to the plot.

package firstloop.john.kidneyuserinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent; //intent library for moving to a new activity
import android.os.Bundle;
import android.view.View;
import android.widget.Button; //button library for basic buttons.

import com.jjoe64.graphview.GraphView; //This is a graph library

import com.jjoe64.graphview.series.DataPoint; //Another graph library

import com.jjoe64.graphview.series.LineGraphSeries; //Another graph library


//Everything design for this graphActivity is contained in the class below.
public class GraphActivity extends AppCompatActivity {


    LineGraphSeries<DataPoint> series; //Initializing a line graph series

    private Button returnbutton; // Initializing a return button


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        returnbutton = (Button) findViewById(R.id.ReturnButton); //casting a button class to returnbutton variable.

        returnbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(GraphActivity.this, Option_Activity.class));
            //Starting a new intent for moving to the main activity when the button is pressed.
            }

        });

        double x, y;  //declaring a pair of example points
        x = 0.0;

        GraphView graph = (GraphView) findViewById(R.id.graph); //initializing a graph


        series = new LineGraphSeries<DataPoint>(); // declaring a series with a set of data points
    // The following loop sets multiple points. These points are added to the plot. For now, we decided to present a random plot (in our case, a tangent graph).
    // The following plot needs to be changed to a plot with a series of real time data points collected by the device in the patient.
        for(int i=0; i<500; i++){
            x = x+0.1;
            y = Math.tan(x);
            series.appendData(new DataPoint(x,y),true,500); //adding more data points to our series
            //maxdatapoints need to match with the limit of index i
        }

        graph.addSeries(series);//adding a series of points to the graph.
    };

    }
