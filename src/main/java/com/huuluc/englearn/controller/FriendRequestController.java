package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.FriendRequestException;
import com.huuluc.englearn.exception.UserException;
import com.huuluc.englearn.model.request.FriendRequiredRequest;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.FriendRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/friend-request")
public class FriendRequestController {
    private final FriendRequestService friendRequestService;

    @GetMapping("/sender/{sender}")
    public ResponseEntity<ResponseModel> findByUserSender(@PathVariable String sender)
            throws FriendRequestException, UserException {
        return friendRequestService.findByUserSender(sender);
    }

    @GetMapping("/receiver/{receiver}")
    public ResponseEntity<ResponseModel> findByUserReceiver(@PathVariable String receiver)
            throws FriendRequestException, UserException {
        return friendRequestService.findByUserReceiver(receiver);
    }

    @GetMapping("/list/{username}")
    public ResponseEntity<ResponseModel> getListFriend(@PathVariable String username)
            throws FriendRequestException, UserException {
        return friendRequestService.getListFriend(username);
    }

    @PostMapping("/")
    public ResponseEntity<ResponseModel> insertFriendRequest(@RequestBody FriendRequiredRequest request)
            throws FriendRequestException {
        return friendRequestService.insertFriendRequest(request);
    }

    @PostMapping("/accept")
    public ResponseEntity<ResponseModel> acceptFriendRequest(@RequestBody FriendRequiredRequest request)
            throws FriendRequestException {
        return friendRequestService.acceptFriendRequest(request);
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseModel> deleteFriendRequest(@RequestBody FriendRequiredRequest request)
            throws FriendRequestException {
        return friendRequestService.deleteFriendRequest(request);
    }

}
