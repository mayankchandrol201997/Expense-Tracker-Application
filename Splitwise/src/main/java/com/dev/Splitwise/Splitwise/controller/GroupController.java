package com.dev.Splitwise.Splitwise.controller;

import com.dev.Splitwise.Splitwise.dto.GroupInfoResponseDto;
import com.dev.Splitwise.Splitwise.dto.GroupRequestDto;
import com.dev.Splitwise.Splitwise.dto.GroupResponseDto;
import com.dev.Splitwise.Splitwise.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/Group")
@RestController
public class GroupController {
    @Autowired
    private GroupService groupService;

    @PostMapping("/create")
    public ResponseEntity<GroupResponseDto> createGroup(@RequestBody GroupRequestDto groupRequestDto)
    {
        return ResponseEntity.ok(groupService.createGroup(groupRequestDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupInfoResponseDto> getGroupInfoById(@PathVariable("id") int id)
    {
        return ResponseEntity.ok(groupService.getGroupInfoById(id));
    }
}
