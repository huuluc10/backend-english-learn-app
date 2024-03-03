package com.huuluc.englearn.controller;

import com.huuluc.englearn.service.FriendRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/friend-request")
public class FriendRequestController {
    private final FriendRequestService friendRequestService;

    @GetMapping("/{sender}")
    public void findByUserSender(@PathVariable String sender) {
        friendRequestService.findByUserSender(sender);
    }

    @PostMapping("/")
    public void insertFriendRequest(@RequestParam String sender, @RequestParam String receiver) {
        friendRequestService.insertFriendRequest(sender, receiver);
    }

    @PostMapping("/accept")
    public void acceptFriendRequest(@RequestParam String sender, @RequestParam String receiver) {
        friendRequestService.acceptFriendRequest(sender, receiver);
    }

    @PostMapping("/delete")
    public void deleteFriendRequest(@RequestParam String sender, @RequestParam String receiver) {
        friendRequestService.deleteFriendRequest(sender, receiver);
    }

}
