package com.example.timeatbleschedulerapp.ui.screens.timetable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.timeatbleschedulerapp.databinding.FragmentDayTimetableBinding

class DayTimetableFragment : Fragment() {
    
    private var _binding: FragmentDayTimetableBinding? = null
    private val binding get() = _binding!!
    private var dayOfWeek: Int = 0
    
    companion object {
        private const val ARG_DAY_OF_WEEK = "day_of_week"
        
        fun newInstance(dayOfWeek: Int): DayTimetableFragment {
            val fragment = DayTimetableFragment()
            val args = Bundle()
            args.putInt(ARG_DAY_OF_WEEK, dayOfWeek)
            fragment.arguments = args
            return fragment
        }
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            dayOfWeek = it.getInt(ARG_DAY_OF_WEEK)
        }
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDayTimetableBinding.inflate(inflater, container, false)
        return binding.root
    }
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        setupRecyclerView()
        loadTimetableData()
    }
    
    private fun setupRecyclerView() {
        binding.rvTimeSlots.layoutManager = LinearLayoutManager(requireContext())
        // Set adapter here
    }
    
    private fun loadTimetableData() {
        // Load timetable data for the specific day
    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
