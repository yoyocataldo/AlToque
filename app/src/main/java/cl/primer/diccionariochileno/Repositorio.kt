package cl.primer.diccionariochileno

import android.content.ContentValues.TAG
import android.util.Log
import cl.primer.diccionariochileno.PalabraApplication.Companion.palabrasDatabase

class Repositorio {
    private val diccionarioDataBase = PalabraApplication.palabrasDatabase!!
    val palabras = diccionarioDataBase.palabraDao().getPalabras()
    suspend fun getPalabras (){
        Log.d("TAG", "getPalabras: ")
        val response = RetrofitClient.instance().listapalabras()
        Log.d("TAG", "getPalabras: ")
        if (response.isSuccessful){
            response.body()?.let {
                Log.d("TAG", "getPalabras: ")
             diccionarioDataBase.palabraDao().insertpalabra(it)
            }} else {
                Log.d(TAG, "${response.errorBody()}: ")

}
}
}