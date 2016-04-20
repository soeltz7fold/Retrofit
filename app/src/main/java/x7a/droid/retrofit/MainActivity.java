package x7a.droid.retrofit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView tv_respond,tv_result_api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tv_respond = (TextView)findViewById(R.id.tv_respond);
        tv_result_api = (TextView)findViewById(R.id.tv_result_api);

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'H:mm:ssZ")
                .create();
        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://10.0.2.2:3000")
                .baseUrl("http://private-2efe7-soeltz7fold.apiary-mock.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        UserApi user_api = retrofit.create(UserApi.class);

        //implements Interface for get all user
        Call<Users> call = user_api.getUsers();
        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {
                int status = response.code();
                tv_respond.setText(String.valueOf(status));
                //this extract data from retrofit  with for() loop
                for(Users.UserItem user : response.body().getUsers())
                {
                    tv_result_api.append(
                            "Id = " +String.valueOf(user.getId())+
                                    System.getProperty("line.separator")+
                                    "Email = " +user.getEmail()+
                                    System.getProperty("line.separator")+
                                    "Password = " +user.getPassword()+
                                    System.getProperty("line.separator")+
                                    "Token Auth = " +user.getToken_auth()+
                                    System.getProperty("line.separator")+
                                    "Created at = " +user.getCreated_at()+
                                    System.getProperty("line.separator")+
                                    "Updated at = " +user.getUpdated_at()+
                                    System.getProperty("line.separator")+
                                    System.getProperty("line.separator")
                    );
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                tv_respond.setText(String.valueOf(t));

            }
        });




//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
