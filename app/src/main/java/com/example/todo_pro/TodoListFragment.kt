package com.example.todo_pro

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.todo_pro.database.MyDataBase
import com.google.android.material.datepicker.MaterialCalendar

import java.util.*

class TodoListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_todo_list, container, false);
    }

    lateinit var recyclerView: RecyclerView
    lateinit var calendarView: CalendarView
    val adapter = TodosRecyclerAdapter(null);
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews();
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()

        getTodosListFromDB();
    }

    var calendar = Calendar.getInstance();


    fun getTodosListFromDB() {

        val todosList = MyDataBase.getInstance(requireContext())
            .todoDao()
            .getTodosByDate(calendar.clearTime().time);// calendar.time (returns time in millisecond)
        adapter.changeData(todosList.toMutableList())
    }

    private fun initViews() {
        recyclerView = requireView().findViewById(R.id.todos_recycler)
        calendarView = requireView().findViewById(R.id.calendarView)
    //   calendarView.selectedDate = CalendarDay.today()
        recyclerView.adapter = adapter


            getTodosListFromDB();
        }


    }
