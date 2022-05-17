package vsu.javablog.service.logic.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vsu.javablog.db.entities.SubscriptionEntity;
import vsu.javablog.db.entities.UserEntity;
import vsu.javablog.db.repositories.SubscriptionRepository;
import vsu.javablog.db.repositories.PostRepository;
import vsu.javablog.db.repositories.UserRepository;
import vsu.javablog.service.mapper.IUserMapper;
import vsu.javablog.service.mapper.impl.CommentMapper;
import vsu.javablog.service.mapper.impl.PostMapper;
import vsu.javablog.service.mapper.impl.TagMapper;
import vsu.javablog.service.mapper.impl.UserMapper;
import vsu.javablog.service.model.UserDto;
//import vsu.javablog.service.exceptions.FriendAlreadyExistsException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SubscriptionService {

    private final IUserMapper map;

    private SubscriptionRepository subscriptionRepository;

    private UserRepository userRepository;

    @Autowired
    public SubscriptionService(IUserMapper map, PostRepository pR, SubscriptionRepository subscriptionRepository, UserRepository userRepository) {
        this.userRepository = userRepository;
        CommentMapper m = new CommentMapper(userRepository, pR);
        this.map = new UserMapper(new PostMapper(m, new TagMapper(), userRepository),
            m);
        this.subscriptionRepository = subscriptionRepository;
    }

    public void addFriend(Integer userId, Integer friendId) {
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("User by id " + userId.toString()));
        UserEntity friend = userRepository.findById(friendId).orElseThrow(() -> new NoSuchElementException("Friend by id " + friendId.toString()));
        SubscriptionEntity friendRec = new SubscriptionEntity();
        if (subscriptionRepository.existsByUserAndFriend(user, friend)) {
            throw new NoSuchElementException("User friend: [" + user.getUsername().toString() + ", " + friend.getUsername().toString() + "]");
        } else {
            if (subscriptionRepository.existsByUserAndFriend(friend, user)) {
                updateStatus(friend, user, true);
                friendRec.setAccepted(true);
            } else {
                friendRec.setAccepted(false);
            }
            friendRec.setUser(user);
            friendRec.setFriend(friend);
            subscriptionRepository.save(friendRec);
        }
    }

    public void deleteFriend(Integer userId, Integer friendId) throws NullPointerException {
        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("User by id " + userId.toString()));
        UserEntity friend = userRepository.findById(friendId).orElseThrow(() -> new NoSuchElementException("Friend by id " + friendId.toString()));
        SubscriptionEntity fr1 = subscriptionRepository.findByUserAndFriend(user, friend);
        if (subscriptionRepository.existsByUserAndFriend(friend, user)) {
            updateStatus(friend, user, false);
        }
        Integer idFriendRec = fr1.getId();
        subscriptionRepository.deleteById(idFriendRec);
    }

    public List<UserDto> getFriends(Integer userId) {

        UserEntity user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("User by id " + userId.toString()));
        List<SubscriptionEntity> friendsByFirstUser = subscriptionRepository.findByUserAndAccepted(user, true);
        List<UserDto> friendUsers = new ArrayList<>();
        for (SubscriptionEntity friend : friendsByFirstUser) {
            friendUsers.add(map.fromEntity(userRepository.getById(friend.getFriend().getId())));
        }
        return friendUsers;
    }

    public List<SubscriptionEntity> getAllFriends() {
        List<SubscriptionEntity> friendUsers = subscriptionRepository.findAll();
        return friendUsers;
    }

    public void updateStatus(UserEntity user, UserEntity friend, boolean status){
        SubscriptionEntity friends = subscriptionRepository.findByUserAndFriend(user, friend);
        if (friends != null){
            subscriptionRepository.updateStatus(friends.getId(), status);
        }
    }
}
