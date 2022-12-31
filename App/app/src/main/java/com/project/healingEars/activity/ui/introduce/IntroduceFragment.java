package com.project.healingEars.activity.ui.introduce;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app.databinding.FragmentIntroduceBinding;
import com.project.healingEars.activity.ui.VmShareViewModel;


public class IntroduceFragment extends Fragment {
    FragmentIntroduceBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        VmShareViewModel vmShareViewModel = new ViewModelProvider(requireActivity()).get(VmShareViewModel.class);

        binding = FragmentIntroduceBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.setLifecycleOwner(this);
        binding.setVmShareViewModel(vmShareViewModel);


        //Navigation.findNavController(root).navigate(R.id.action_nav_my_info_to_nav_introduce2);


        //.findNavController(requireView()).navigate(R.id.action_nav_my_info_to_nav_station);


        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_login, container, false);
        return root;
    }
}