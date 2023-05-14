package api;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import user.create.UserCreateRequest;
import user.login.UserLoginRequest;
import user.login.UserLoginResponse;

public class UserClient extends ServerClient {

  private static final String LOGIN_USER_PATH = "/api/auth/login";
  private static final String DELETE_USER_PATH = "/api/auth/user";
  private static final String CREATE_USER_PATH = "/api/auth/register";

  @Step("Delete user test data")
  public void deleteTestData(String email, String password) {
    ValidatableResponse response = login(new UserLoginRequest(email, password));

    UserLoginResponse userLoginResponse = response.extract().as(UserLoginResponse.class);
    delete(userLoginResponse.getAccessToken());
  }

  @Step("User create")
  public ValidatableResponse create(UserCreateRequest body) {
    return sendPostRequest(body, CREATE_USER_PATH);
  }

  private ValidatableResponse login(UserLoginRequest body) {
    return sendPostRequest(body, LOGIN_USER_PATH);
  }

  private ValidatableResponse delete(String token) {
    return sendDeleteRequest(DELETE_USER_PATH, token);
  }
}
