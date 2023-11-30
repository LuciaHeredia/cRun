package com.example.crun.ui.collection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.crun.databinding.FragmentCalendarBinding

class CollectionFragment : Fragment() {

    private var _binding: FragmentCalendarBinding? = null

    // property only valid between onCreateView and onDestroyView
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // viewModel config
        val collectionViewModel = ViewModelProvider(this)[CollectionViewModel::class.java]

        // binding config
        _binding = FragmentCalendarBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // objects config
        val textView: TextView = binding.textCalendar
        collectionViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}