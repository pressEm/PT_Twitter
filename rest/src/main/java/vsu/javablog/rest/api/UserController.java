package vsu.javablog.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vsu.javablog.service.logic.impl.UserService;
import vsu.javablog.service.model.PostDto;
import vsu.javablog.service.model.UserDto;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserDto> getAllUsers(){
        return service.getAllUSers();
    }

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable Integer userId){
        return service.getUserById(userId);
    }

    @PostMapping()
    ResponseEntity<UserDto> add(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(service.createUser(userDto), HttpStatus.OK);
    }

    @GetMapping("/{userId}/subscribers")
    public List<UserDto> getUserSubscribers(@PathVariable Integer userId){
        //Todo: make this also
        return null;
    }

    @GetMapping("/{userId}/likedPosts")
    public List<PostDto> getUserLikedPosts(@PathVariable Integer userId){
        return service.getAllLikedPosts(userId);
    }
}
