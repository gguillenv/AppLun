package com.example.gustavo.applun


import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_acel.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class AcelFrag : Fragment(), SensorEventListener {
    //Crear una variable manejar el sensor
    val sensorManager : SensorManager by lazy{
        activity?.getSystemService(Context.SENSOR_SERVICE) as SensorManager

    }
    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event!!.sensor.type == Sensor.TYPE_ACCELEROMETER){
            acelerometro(event)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_acel, container, false)


    }

    override fun onResume() {
        super.onResume()

        sensorManager.registerListener(this, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL)

    }

    override fun onPause() {
        super.onPause()

        sensorManager.unregisterListener(this)

    }

    fun acelerometro(event: SensorEvent){               // Podemos quitar el ? de la classe SensorEvnet por que el if y donde se llama
        xval.text = event.values[0].toString()          // ya verifioo si el evento esta vacio o no
        yval.text = event.values[1].toString()
        zval.text = event.values[2].toString()


      /*  if (event.values[0] < 5){
            ac_layout.setBackgroundColor(Color.BLACK)
        }else{
            ac_layout.setBackgroundColor(Color.RED)
        }
        if (event.values[1] < 5){
            ac_layout.setBackgroundColor(Color.BLUE)
        }else{
            ac_layout.setBackgroundColor(Color.GRAY)
        }*/
        if (event.values[2] < 5){
            ac_layout.setBackgroundColor(Color.GREEN)
        }else{
            ac_layout.setBackgroundColor(Color.YELLOW)
        }
    }

}
