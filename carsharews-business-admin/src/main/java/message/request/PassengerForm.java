package message.request;


public class PassengerForm {

    private String userInfo;
    private String token;
    private String travelCode;

    public PassengerForm() {
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTravelCode() {
        return travelCode;
    }

    public void setTravelCode(String travelCode) {
        this.travelCode = travelCode;
    }
}
