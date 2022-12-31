package com.project.healingEars.activity.ui.station;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.healingEars.http.dto.ProductDetailDTO;
import com.project.healingEars.http.service.ProductDetailService;
import com.project.healingEars.http.vo.ProductDetailVO;

import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Response;

public class StationViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private MutableLiveData<List<ProductDetailVO>> productDetailL;

    public StationViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");

        productDetailL = new MutableLiveData<>();
    }

    public void getProDetailByStnId(Integer StnId) {
        try {
            Response<ProductDetailDTO> result = new ProductDetailService.getProDetailByStn().execute(StnId).get();

            if((result.body().result).equals("SUCCESS")) {
                productDetailL.setValue(result.body().productDetail);
            }

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public MutableLiveData<List<ProductDetailVO>> getProductDetailL() {
        return productDetailL;
    }

    public LiveData<String> getText() {
        return mText;
    }
}