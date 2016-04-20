package x7a.droid.retrofit;

/**
 * Created by DroiD on 19/04/2016.
 */
//User model class use for insert, update, delete data from API, the structure class model base on structure of object GSON.
public class User {
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
        return password;
    }
    public void setPassword(){
        this.password = password;
    }
    public String getToken_auth(){
        return token_auth;
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
