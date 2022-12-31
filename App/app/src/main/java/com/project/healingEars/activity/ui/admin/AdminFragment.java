package com.project.healingEars.activity.ui.admin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app.R;
import com.example.app.databinding.FragmentAdminBinding;
import com.project.healingEars.activity.ui.VmShareViewModel;
import com.project.healingEars.activity.ui.product.ProductFragment;
import com.project.healingEars.activity.ui.station.StationAdapter;
import com.project.healingEars.activity.ui.station.StationFragment;

import java.util.List;


public class AdminFragment extends Fragment {
    private FragmentAdminBinding binding;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        VmShareViewModel vmShareViewModel = new ViewModelProvider(requireActivity()).get(VmShareViewModel.class);

        binding = FragmentAdminBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.setLifecycleOwner(this);
        binding.setVmShareModel(vmShareViewModel);



        // 스테이션 리스트 가져오기
        vmShareViewModel.getStationList();

        binding.btnAdminStation.setOnClickListener( view -> {
            binding.stationRecycler.setVisibility(View.VISIBLE);
            binding.btnTest.setVisibility(View.INVISIBLE);});

        binding.btnAdminProduct.setOnClickListener( view -> {
            binding.btnTest.setVisibility(View.VISIBLE);
            binding.stationRecycler.setVisibility(View.INVISIBLE);
        });

        /*
        vmShareViewModel.userVO.observe(requireActivity(), userVO -> {
            if((userVO.userType).equals("2")) binding.btnInfoChildAdmin.setVisibility(View.VISIBLE);
        });
         */


        recyclerView = root.findViewById(R.id.station_recycler);
        linearLayoutManager = new LinearLayoutManager(requireActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        StationAdminAdapter adapter = new StationAdminAdapter((List)vmShareViewModel.stationListVO.getValue());

        recyclerView.setAdapter(adapter);



        return root;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //Toast.makeText(requireActivity(), "onDestroyView()", Toast.LENGTH_LONG).show();
        binding = null;
    }
}