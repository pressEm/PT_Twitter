package vsu.javablog.rest.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsu.javablog.service.data.SubscriptionRequest;
import vsu.javablog.service.logic.impl.SubscriptionService;
import vsu.javablog.service.logic.impl.UserService;
import vsu.javablog.service.model.UserDto;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/friends")
public class SubscriptionController {

    private SubscriptionService subscriptionService;

    private UserService userService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService, UserService userService) {
        this.subscriptionService = subscriptionService;
        this.userService = userService;
    }

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity addFriend(@RequestBody SubscriptionRequest request) throws NullPointerException {
        subscriptionService.addFriend(request.getUserId(), request.getFriendId());
        return ResponseEntity.ok("Friend added successfully");
    }

    @DeleteMapping(value = "/delete", consumes = "application/json", produces = "application/json")
    public ResponseEntity deleteFriend(@RequestBody SubscriptionRequest request) throws NullPointerException {
        subscriptionService.deleteFriend(request.getUserId(), request.getFriendId());
        return ResponseEntity.ok("Friend deleted successfully");
    }

    @GetMapping("/list/{userId}")
    public ResponseEntity<List<UserDto>> getFriends(@PathVariable Integer userId) {
        List<UserDto> myFriends = subscriptionService.getFriends(userId);

        return new ResponseEntity<>(myFriends, HttpStatus.OK);
    }
}
