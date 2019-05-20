package message.response;

import model.Travel;

import javax.validation.constraints.Size;

public class PassagerResponse {

    @Size(min=3, max = 1000)
    private String userInfo;
    private String token;
    private TravelReponse travel;

    public PassagerResponse(@Size(min = 3, max = 1000) String userInfo, String token, TravelReponse travel) {
        this.userInfo = userInfo;
        this.token = token;
        this.travel = travel;
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

    public TravelReponse getTravel() {
        return travel;
    }

    public void setTravel(TravelReponse travel) {
        this.travel = travel;
    }
}
