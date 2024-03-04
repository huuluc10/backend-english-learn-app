package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.FriendRequestException;
import com.huuluc.englearn.model.request.FriendRequiredRequest;
import com.huuluc.englearn.service.FriendRequestService;
import com.huuluc.englearn.service.impl.FriendRequestServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/friend-request")
public class FriendRequestController {
    private final FriendRequestService friendRequestService;

    @GetMapping("/{sender}")
    public void findByUserSender(@PathVariable String sender) throws FriendRequestException {
        friendRequestService.findByUserSender(sender);
    }

    @PostMapping("/")
    public void insertFriendRequest(@RequestBody FriendRequiredRequest request) throws FriendRequestException {
        friendRequestService.insertFriendRequest(request);
    }

    @PostMapping("/accept")
    public void acceptFriendRequest(@RequestBody FriendRequiredRequest request) throws FriendRequestException {
        friendRequestService.acceptFriendRequest(request);
    }

    @PostMapping("/delete")
    public void deleteFriendRequest(@RequestBody FriendRequiredRequest request) throws FriendRequestException {
        friendRequestService.deleteFriendRequest(request);
    }

}
