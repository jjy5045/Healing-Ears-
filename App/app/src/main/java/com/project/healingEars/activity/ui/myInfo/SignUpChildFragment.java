package com.project.healingEars.activity.ui.myInfo;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.app.R;
import com.example.app.databinding.FragmentSignUpChildBinding;
import com.project.healingEars.activity.ui.VmShareViewModel;
import com.project.healingEars.http.vo.UserVO;

public class SignUpChildFragment extends Fragment {
    private FragmentSignUpChildBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        VmShareViewModel vmShareViewModel = new ViewModelProvider(requireActivity()).get(VmShareViewModel.class);

        binding = FragmentSignUpChildBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.btnSignup.setOnClickListener(view -> {
            vmShareViewModel.SignUp(
                    binding.editTextName.getText().toString(),
                    binding.editTextSex.getText().toString(),
                    binding.editTextTextEmailAddress.getText().toString(),
                    binding.editTextPhone.getText().toString(),
                    binding.editTextTextPassword.getText().toString(),
                    binding.editTextDate.getText().toString()
            );

            if(vmShareViewModel.signUpState.getValue().equals("회원가입성공")){
                Toast.makeText(requireActivity(), "회원가입 성공", Toast.LENGTH_LONG).show();
                // 뒤로가기
                Navigation.findNavController(root).popBackStack();
            }
        });


        return root;
    }
}