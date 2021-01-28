package cl.primer.diccionariochileno

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cl.primer.diccionariochileno.databinding.FragmentListBinding

class ListFragment: Fragment() {
    private lateinit var binding: FragmentListBinding
    private val viewModel: ViewModelPalabra by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("TAG", "onCreateView: ")
        binding= FragmentListBinding.inflate(layoutInflater)
        binding.rvBooksList.layoutManager=LinearLayoutManager(context)
        val adapter=Adapter()
        binding.rvBooksList.adapter=adapter
        viewModel.palabras.observe(viewLifecycleOwner, {
            Log.d("TAG", "onCreateView: ${it.size} ")
            adapter.update(it)
        })

        return binding.root
    }
}