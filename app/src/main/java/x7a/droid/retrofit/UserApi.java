package x7a.droid.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by DroiD on 19/04/2016.
 */
public interface UserApi {
    @GET("/questions")
    Call<Users> getUsers();

    @GET("/questions{id}")
    Call<User> getUser(@Path("id") String user_id);

    @PUT("/questions/{id}")
    Call<User> updateUser(@Path("id")int user_id, @Body User user);

    @POST("/questions")
    Call<User> saveUser(@Body User user);

    @DELETE("/questions/{id}")
    Call<User> deleteUser(@Path("id")String user_id);
}
