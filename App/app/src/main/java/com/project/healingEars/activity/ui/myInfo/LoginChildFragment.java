package com.project.healingEars.activity.ui.myInfo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.app.R;
import com.example.app.databinding.FragmentLogin2Binding;
import com.example.app.databinding.FragmentLoginBinding;
import com.project.healingEars.activity.ui.introduce.IntroduceFragment;
import com.project.healingEars.activity.ui.VmShareViewModel;

public class LoginChildFragment extends Fragment {
    private FragmentLoginBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        VmShareViewModel vmShareViewModel = new ViewModelProvider(requireActivity()).get(VmShareViewModel.class);
        /*
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.setLifecycleOwner(this);
        binding.setVmShareViewModel(vmShareViewModel);

        binding.btnLogin.setOnClickListener(view -> { vmShareViewModel.Login(binding.edtUserId.getText().toString(), binding.edtUserPassword.getText().toString()); });
        binding.btnSignup.setOnClickListener(view -> { Navigation.findNavController(root).navigate(R.id.action_nav_my_info_to_nav_sign_up); });
        binding.btnSession.setOnClickListener(view -> { vmShareViewModel.SessionInfo();});
         */

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.setLifecycleOwner(this);
        binding.setVmShareViewModel(vmShareViewModel);

        binding.btnLogin.setOnClickListener(view -> {
            vmShareViewModel.Login(binding.edtUserId.getText().toString(), binding.edtUserPassword.getText().toString());
            if ((vmShareViewModel.loginState.getValue()).equals("LOGIN")) Toast.makeText(requireActivity(), "환영합니다.", Toast.LENGTH_SHORT).show();
            else if ((vmShareViewModel.loginState.getValue()).equals("FAIL")) Toast.makeText(requireActivity(), "일치하는 회원이 없습니다.", Toast.LENGTH_SHORT).show();
            else if ((vmShareViewModel.loginState.getValue()).equals("ERROR")) Toast.makeText(requireActivity(), "서버 접속 오류", Toast.LENGTH_SHORT).show();
        });

        // 회원가입 버튼 클릭
        binding.btnSignup.setOnClickListener(view -> { Navigation.findNavController(root).navigate(R.id.action_nav_my_info_to_nav_sign_up); });
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