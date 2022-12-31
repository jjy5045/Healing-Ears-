package com.project.healingEars.activity.ui.myInfo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyInfoViewModel extends ViewModel {

    public MutableLiveData<String> mText;
    public MutableLiveData<String> userNickName;

    public MyInfoViewModel() {
        mText = new MutableLiveData<>();
        userNickName = new MutableLiveData<>();
        mText.setValue("This is home fragment");
        userNickName.setValue("Android Studio");
    }


    public LiveData<String> getText() {
        return mText;
    }
    public LiveData<String> getUserNickName() { return  userNickName; }
}