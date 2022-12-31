package com.project.healingEars.activity.ui.station;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.R;
import com.example.app.databinding.FragmentStationBinding;
import com.example.app.databinding.ItemStationBinding;
import com.project.healingEars.activity.ui.VmShareViewModel;
import com.project.healingEars.http.vo.StationListVO;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;


public class StationFragment extends Fragment {

    private FragmentStationBinding binding;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    //RecyclerView recyclerView;
    StationAdapter adapter;
    ItemStationBinding itemStationBinding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //GalleryViewModel galleryViewModel = new ViewModelProvider(this).get(GalleryViewModel.class);
        StationViewModel stationViewModel = new ViewModelProvider(requireActivity()).get(StationViewModel.class);
        VmShareViewModel vmShareViewModel = new ViewModelProvider(requireActivity()).get(VmShareViewModel.class);

        binding = FragmentStationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.setLifecycleOwner(this);
        binding.setVmShareModel(vmShareViewModel);


        // 스테이션 리스트 가져오기
        vmShareViewModel.getStationList();

        //binding.stationRecycler.setAdapter(adapter);
        //recyclerView = getView().findViewById(R.id.station_recycler);
        recyclerView = root.findViewById(R.id.station_recycler);
        linearLayoutManager = new LinearLayoutManager(requireActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

        StationAdapter adapter = new StationAdapter((List)vmShareViewModel.stationListVO.getValue());

        recyclerView.setAdapter(adapter);




        //itemStationBinding = ItemStationBinding.bind(binding.stationRecycler);

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}