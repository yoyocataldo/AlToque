package cl.primer.diccionariochileno

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.primer.diccionariochileno.databinding.PalabraItemListBinding

class Adapter: RecyclerView.Adapter<Adapter.PalabraVH>() {
    private var palabraList = listOf<Palabra>()
    private val selectedItem = MutableLiveData<Palabra>()
    fun selectedItem(): LiveData<Palabra> = selectedItem
    class PalabraVH (val binding: PalabraItemListBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(palabra: Palabra) {
         binding.textView.text=palabra.name
        }

    }
fun update (list:List<Palabra>){
    palabraList=list
    notifyDataSetChanged()
}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PalabraVH {
        val binding = PalabraItemListBinding.inflate(LayoutInflater.from(parent.context))
        return PalabraVH(binding)


    }

    override fun onBindViewHolder(holder: PalabraVH, position: Int) {
        val palabra = palabraList[position]
        holder.bind(palabra)
        holder.itemView.setOnClickListener{
            selectedItem.value = palabra
        }

    }

    override fun getItemCount(): Int {
    return palabraList.size
    }

}