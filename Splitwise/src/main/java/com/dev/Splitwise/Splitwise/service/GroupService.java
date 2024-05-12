package com.dev.Splitwise.Splitwise.service;

import com.dev.Splitwise.Splitwise.dto.GroupInfoResponseDto;
import com.dev.Splitwise.Splitwise.dto.GroupRequestDto;
import com.dev.Splitwise.Splitwise.dto.GroupResponseDto;

import java.util.List;

public interface GroupService {
    List<GroupResponseDto> getGroups();
    GroupInfoResponseDto getGroupInfoById(int id);
    GroupResponseDto createGroup(GroupRequestDto groupRequestDto);
    GroupResponseDto updateGroup(GroupRequestDto groupRequestDto);
    Boolean deleteGroup(int id);
}
