package com.example.gustavo.applun

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
//Esta es una funcion de extencion que sirve para no heredar
fun AppCompatActivity.reemplazarFragmento(fragment : Fragment, allowStateLoss: Boolean = false, @IdRes contenedor : Int){

    val ft = supportFragmentManager.beginTransaction()        // Esta variable me indicara si la transaccion fue correcta
    val remplazar = ft.replace(contenedor, fragment)          // Recibe el kotling y el xml con el que va a remplazar el contenedor

    if(!supportFragmentManager.isStateSaved){
        remplazar.addToBackStack(null)
        remplazar.commit()
    }else{
        remplazar.commitAllowingStateLoss()
    }
}