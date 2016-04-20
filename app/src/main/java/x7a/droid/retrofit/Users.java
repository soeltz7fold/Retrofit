package x7a.droid.retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by DroiD on 19/04/2016.
 */

//Description : Users model class use for get all data from API, this class different
// from User model because this model use for extract data GSON, this structure class created base on structure GSON object.
public class Users {
    @SerializedName("users")
    public List<UserItem> users;
    public List<UserItem> getUsers() {
        return users;
    }

    public void setUsers(List<UserItem> users) {
        this.users = users;
    }
    public Users(List<UserItem>users){
        this.users = users;
    }

    public class UserItem{
        private int id;
        private String email;
        private String password;
        private String token_auth;
        private String created_at;
        private String updated_at;

        public int getId(){
            return id;
        }
        public void setId(int id){
            this.id = id;
        }
        public String getEmail(){
            return email;
        }
        public void setEmail(){
            this.email = email;
        }
        public String getPassword(){
            return  password;
        }
        public void setPassword(){
            this.password = password;
        }
        public String getToken_auth(){
            return password;
        }
        public void setToken_auth(){
            this.token_auth = token_auth;
        }
        public String getCreated_at(){
            return created_at;
        }
        public void setCreated_at(){
            this.created_at = created_at;
        }
        public String getUpdated_at(){
            return updated_at;
        }
        public void setUpdated_at(){
            this.updated_at = updated_at;
        }
    }
}
