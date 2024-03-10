package com.huuluc.englearn.controller;

import com.huuluc.englearn.exception.*;
import com.huuluc.englearn.model.request.FriendRequiredRequest;
import com.huuluc.englearn.model.response.ResponseModel;
import com.huuluc.englearn.service.FriendRequestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/friend-request")
@Tag(name = "Friend Request", description = "Friend Request API")
@Slf4j
public class FriendRequestController {
    private final FriendRequestService friendRequestService;

    @GetMapping("/sender/{sender}")
    @Operation(summary = "Get friend request by sender")
    public ResponseEntity<ResponseModel> findByUserSender(@PathVariable String sender)
            throws FriendRequestException, UserException, MediaException, LevelException, UserMissionException {
        log.info("Get friend request by {}", sender);
        return friendRequestService.findByUserSender(sender);
    }

    @GetMapping("/receiver/{receiver}")
    @Operation(summary = "Get friend request by receiver")
    public ResponseEntity<ResponseModel> findByUserReceiver(@PathVariable String receiver)
            throws FriendRequestException, UserException, MediaException, LevelException, UserMissionException {
        log.info("Get friend request by {}", receiver);
        return friendRequestService.findByUserReceiver(receiver);
    }

    @GetMapping("/list/{username}")
    @Operation(summary = "Get list friend")
    public ResponseEntity<ResponseModel> getListFriend(@PathVariable String username)
            throws FriendRequestException, UserException, MediaException, LevelException, UserMissionException {
        log.info("Get list friend by {}", username);
        return friendRequestService.getListFriend(username);
    }

    @PostMapping("/")
    @Operation(summary = "Insert friend request")
    public ResponseEntity<ResponseModel> insertFriendRequest(@RequestBody FriendRequiredRequest request)
            throws FriendRequestException {
        log.info("Insert friend request by {} to {}", request.getSender(), request.getReceiver());
        return friendRequestService.insertFriendRequest(request);
    }

    @PostMapping("/accept")
    @Operation(summary = "Accept friend request")
    public ResponseEntity<ResponseModel> acceptFriendRequest(@RequestBody FriendRequiredRequest request)
            throws FriendRequestException {
        log.info("Accept friend request by {} to {}", request.getSender(), request.getReceiver());
        return friendRequestService.acceptFriendRequest(request);
    }

    @PostMapping("/delete")
    @Operation(summary = "Delete friend request")
    public ResponseEntity<ResponseModel> deleteFriendRequest(@RequestBody FriendRequiredRequest request)
            throws FriendRequestException {
        log.info("Delete friend request by {} to {}", request.getSender(), request.getReceiver());
        return friendRequestService.deleteFriendRequest(request);
    }

}
