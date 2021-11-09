package com.example.androidusecase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecycleViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecycleViewFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    ArrayList<DataModel> dataHolder;

    public RecycleViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecycleViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecycleViewFragment newInstance(String param1, String param2) {
        RecycleViewFragment fragment = new RecycleViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_recycle_view, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataHolder = new ArrayList<>();

        DataModel ob1 = new DataModel(R.drawable.ic_baseline_photo,"Casual Leave","24 May 2020, 12:00pm","Nico Rosenburg","Team Lead, IT Development",
                                        "2 Days","30 Dec, 2019 - 1 Jan, 2020","Approved",R.drawable.ic_baseline_tick_24);
        dataHolder.add(ob1);

        DataModel ob2 = new DataModel(R.drawable.ic_baseline_photo,"Sick Leave","22 May 2020, 10:00pm","Max Verstappen","Vice President of Sales, IT & MIS",
                "1 Day","12 May","Rejected",R.drawable.ic_baseline_clear_24);
        dataHolder.add(ob2);

//        DataModel ob2 = new DataModel(R.drawable.ic_baseline_photo,"Android","Uses Android Studio");
//        dataHolder.add(ob2);

        recyclerView.setAdapter(new RecycleAdapter(dataHolder));

        return view;
    }
}