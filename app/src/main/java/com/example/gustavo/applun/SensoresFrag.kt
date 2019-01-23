package com.example.gustavo.applun


import android.os.Bundle
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_sensores.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SensoresFrag : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        //val vista = inflater.inflate(R.layout.fragment_sensores,container,false)
        return inflater.inflate(R.layout.fragment_sensores,container,false)
/*        val acelbtn = vista.findViewById<Button>(R.id.ac_btn)

        acelbtn.setOnClickListener(){
           // Toast.makeText(activity?.applicationContext, "hola mundo",Toast.LENGTH_SHORT).show()
            activity.reemplazarFragment(
                fragment = AcelFrag(),
                allowStateLoss = true,
                contenedor = R.id.contenedor_maestro
            )

        }
*/
       // return vista
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ac_btn.setOnClickListener(){
            activity.reemplazarFragment(
                fragment = AcelFrag(),
                allowStateLoss = true,
                contenedor = R.id.contenedor_maestro
            )
        }
    }

}

fun FragmentActivity?.reemplazarFragment(fragment : Fragment, allowStateLoss: Boolean = false, @IdRes contenedor: Int){

    val ft = this!!.supportFragmentManager.beginTransaction().replace(contenedor,fragment)

    if(!supportFragmentManager.isStateSaved){
        ft.addToBackStack(null)
        ft.commit()
    }else{
        ft.commitAllowingStateLoss()
    }


}