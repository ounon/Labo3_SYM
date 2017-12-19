package ch.heigvd.sym.labo3;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class CompassActivity extends AppCompatActivity implements SensorEventListener {

    //opengl
    private OpenGLRenderer  opglr           = null;
    private GLSurfaceView   m3DView         = null;


    //Sensors
    //

    private SensorManager mSensorManager;
    private Sensor mGeomagnetic;
    private Sensor mGravity;

    private float[] gravity;
    private float[] magnetic;
    private float rotationM[] = new float[16]; // will store matrix data
    private float tmpRot[] = new float[16];

    public CompassActivity() {


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // we need fullscreen
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // we initiate the view
        setContentView(R.layout.activity_compass);

        // link to GUI
        this.m3DView = findViewById(R.id.compass_opengl);

        //we create the 3D renderer
        this.opglr = new OpenGLRenderer(getApplicationContext());

        //init opengl surface view
        this.m3DView.setRenderer(this.opglr);

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mGravity = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mGeomagnetic= mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mGravity, SensorManager.SENSOR_DELAY_GAME);
        mSensorManager.registerListener(this, mGeomagnetic, SensorManager.SENSOR_DELAY_GAME);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this, mGravity);
        mSensorManager.unregisterListener(this, mGeomagnetic);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            if (event.values != null)
                gravity = event.values.clone(); // clone for continuity
        }
        if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            if (event.values != null)
                magnetic = event.values.clone(); // clone for continuity
        }
        if (gravity != null && magnetic != null) { // we got data!

            // following line uses knowledge of direction of gravity and
            // magnetic field to get the orientation data
            if (SensorManager.getRotationMatrix(rotationM, null, gravity, magnetic)) {

                if(rotationM.equals(tmpRot)){
                    tmpRot = this.opglr.swapRotMatrix(rotationM);

                }
                rotationM = tmpRot;
            }
        }
    }

    /* TODO */
    // your activity need to register accelerometer and magnetometer sensors' updates
    // then you may want to call
    //  this.opglr.swapRotMatrix()
    // with the 4x4 rotation matrix, everytime a new matrix is computed
    // more information on rotation matrix can be found on-line:
    // https://developer.android.com/reference/android/hardware/SensorManager.html#getRotationMatrix(float[],%20float[],%20float[],%20float[])

}
