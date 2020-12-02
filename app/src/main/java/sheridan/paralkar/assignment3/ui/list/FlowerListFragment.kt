package sheridan.paralkar.assignment3.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import sheridan.paralkar.assignment3.R
import sheridan.paralkar.assignment3.databinding.FlowerListFragmentBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FlowerListFragment : Fragment() {

    private val viewModel: FlowerListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FlowerListFragmentBinding.inflate(inflater)

        val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.recyclerView.addItemDecoration(divider)
        val adapter = FlowerListAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.getFlowers().observe(viewLifecycleOwner){
            adapter.submitList(it)
        }

        return binding.root
    }


}