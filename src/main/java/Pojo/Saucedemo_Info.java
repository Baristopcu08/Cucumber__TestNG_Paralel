package Pojo;
import lombok.Data;


@Data()
public class Saucedemo_Info extends BasePojo{
    private String url;
    private LoginInfo login;

    @Data
    public static class LoginInfo {
        private String username;
        private String password;
    }
}
