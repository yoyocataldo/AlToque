package cl.primer.diccionariochileno

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ViewModelPalabra: ViewModel() {
    fun dosomething() {

    }

    private val repository = Repositorio()
val palabras=repository.palabras
    init {
        viewModelScope.launch {
            Log.d("TAG", ":ViewModelInit ")
repository.getPalabras()
        }
    }



}