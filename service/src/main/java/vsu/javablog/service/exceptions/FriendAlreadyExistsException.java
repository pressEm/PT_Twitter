package vsu.javablog.service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FriendAlreadyExistsException{
    protected HttpStatus httpStatus;
    protected String description;
    public FriendAlreadyExistsException(String user, String friend) {
        httpStatus = HttpStatus.BAD_REQUEST;
        description = "Users: " + user + "and " + friend + "are already friends.";
    }

}
