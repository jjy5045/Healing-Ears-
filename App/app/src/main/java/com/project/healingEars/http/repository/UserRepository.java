package com.project.healingEars.http.repository;

import android.content.Context;

import com.project.healingEars.api.retrofitClient;
import com.project.healingEars.http.dto.SessionDTO;
import com.project.healingEars.http.dto.SignUpDTO;
import com.project.healingEars.http.dto.StationDTO;
import com.project.healingEars.http.dto.UserDTO;
import com.project.healingEars.http.service.UserService;
import com.project.healingEars.http.vo.StationListVO;
import com.project.healingEars.http.vo.UserVO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class UserRepository {

    public static UserAPI getRetrofit() {
        return retrofitClient.getInstance().getRetrofit().create(UserAPI.class);
    }

    public interface UserAPI {
        //통신할 URL을 미리 정의하는 interface
        //userInfo : POJO(DTO)를 정의해두는 클래스 (직접 클래스를 만들 것이기 때문에 오류는 신경쓰지 않음)

        @GET("getTemp/{userId}")
        Call<UserVO> getUserInfo(@Path("userId") String userId);

        @POST("getTemp/qqq") //추가예정
        Call<UserVO> postUserInfo(@Body UserVO userVO);

        @GET("productDetail/all")
        Call<List<UserVO>> getFunc(@Body UserVO userVO);

        @GET("productDetail/all")
        Call<String> Info4();

        //@Headers("Content-Type: application/json")
        @POST("users/login")
        Call<UserDTO> loginString(@Body UserVO userVO);

        @GET("users/logout")
        Call<String> logout();

        @GET("users/session")
        Call<SessionDTO> sessionInfo();

        //@Headers("Content-Type: application/json")
        @POST("users")
        Call<SignUpDTO> signUp(@Body UserVO userVO);


        /*
        //1. 회원 정보 조회
        //Get방식, 주소가 고정되지 않는 상황에서는 @Path를 통해 주소를 다이나믹하게 넣을 수 있습니다.
        //Json형식에 맞게 Bean 객체를 만들어 두면 설정한 Parser가 자동으로 컨버팅해 돌려 줍니다.
        @GET("productDetail/12")
        //Call<userVO> myInfo(@Path("userID") String userID);
        Call<ProductDetailVO> ProductDetailInfo();


        @GET("users/5")
        Call<JsonObject> Info3();

        @GET("productDetail/all")
        Call<JsonObject> Info4();

        @GET("productRent/all")
        Call<JsonObject> InfoProRent();

        //
         // 회원가입 메소드
         //
         // @param email
         // @param pwd
         // @param nickname
         // @return
         //
        //@FormUrlEncoded
        //URL encoding하여 보냅니다. --- application/x-www-form-urlencoded
        //POST 방식, 파라메터는 @Field("파라메터명") 으로 보낼 수 있습니다.
        @FormUrlEncoded
        Call<UserVO> up(
                @Field("email") String email,
                @Field("pwd") String pwd,
                @Field("nickname") String nickname
        );


        //회원 가입
        @Headers("Content-Type: application/json")
        @POST("user/join")
        Call<String> join(@Body UserVO userVO);

        //3. 로그인
        //POST 방식, 파라메터는 @Field("파라메터명") 으로 보낼 수 있습니다.
        @Headers("Content-Type: application/json")
        @POST("users/login")
        Call<JsonObject> login(@Body UserVO userVO);
        //Call<JsonObject> login(@Body userVO userVO);
        //Call<String> login(@Field("id") String id, @Field("pwd") String pwd);
        //response는 true/false

        //Call<User> updateUser(@Part("photo") RequestBody photo, @Part("description") RequestBody description);


        @Headers("Content-Type: application/json")
        @POST("users/login")
        Call<UserDTO> login2(@Body UserVO userVO);


        @Headers("Content-Type: application/json")
        @POST("users/login")
        Call<String> loginString(@Body UserVO userVO);


        //회원 정보 수정
        @Headers("Content-Type: application/json")
        @PUT("user/modify")
        Call<String> modify(@Body UserVO userVO);

        //프로필 사진 변경
        @Multipart
        @POST("user/modify/profile_image")
        Call<String> modifyProfileImage(@PartMap() LinkedHashMap<String, RequestBody> partMap, @Part List<MultipartBody.Part> names);


        //회원 정보 삭제
        //id를 파라미터로 받아 API URL을 완성해서 DELETE 방식으로 요청
        @DELETE("user/delete/{id}")
        Call<String> delete(@Path("id") String id);
        //response는 ok/fail


        // Get방식, 파라메터는 @Query("파라메터명")으로 보낼 수 있습니다.
        // Bean객체를 생성하지 않고 JsonObject로 받을 수 있습니다.
        @GET("project")
        Call<JsonObject> Project(@Query("email") String email);

        //Rxandroid 사용
        //Rxandroid : 안드로이드에서 Observer 패턴, Iterator 패턴을 사용 할 수 있게 하는 라이브러리
        @GET("project")
        Observable<JsonObject> Project();
         */

    }
}
