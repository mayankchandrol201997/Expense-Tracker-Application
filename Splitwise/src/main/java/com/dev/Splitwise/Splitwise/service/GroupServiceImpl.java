package com.dev.Splitwise.Splitwise.service;

import com.dev.Splitwise.Splitwise.dto.GroupInfoResponseDto;
import com.dev.Splitwise.Splitwise.dto.GroupRequestDto;
import com.dev.Splitwise.Splitwise.dto.GroupResponseDto;
import com.dev.Splitwise.Splitwise.entity.SplitwiseGroup;
import com.dev.Splitwise.Splitwise.entity.User;
import com.dev.Splitwise.Splitwise.mapper.EntityToDtoMapper;
import com.dev.Splitwise.Splitwise.repository.SplitwiseGroupRepository;
import com.dev.Splitwise.Splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GroupServiceImpl implements GroupService{

    @Autowired
    private SplitwiseGroupRepository splitwiseGroupRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<GroupResponseDto> getGroups() {
        return List.of();
    }

    @Override
    public GroupInfoResponseDto getGroupInfoById(int id) {
        SplitwiseGroup splitwiseGroup = splitwiseGroupRepository.findById(id).get();
        return EntityToDtoMapper.convertToSpliwiseGroupInfoResponseDto(splitwiseGroup);
    }

    @Override
    public GroupResponseDto createGroup(GroupRequestDto groupRequestDto) {
        SplitwiseGroup splitwiseGroup = new SplitwiseGroup();
        splitwiseGroup.setName(groupRequestDto.getName());
        User user = userRepository.findById(groupRequestDto.getCreatedByUserId()).get();
        splitwiseGroup.setCreatedBy(user);
        splitwiseGroup.setMembers(List.of(user));

        splitwiseGroup = splitwiseGroupRepository.save(splitwiseGroup);

        List<SplitwiseGroup> groups = user.getGroups();
        groups.add(splitwiseGroup);
        user.setGroups(groups);
        userRepository.save(user);

        return EntityToDtoMapper.convertSpliwiseGroupResponseDto(splitwiseGroup);
    }

    @Override
    public GroupResponseDto updateGroup(GroupRequestDto groupRequestDto) {
        return null;
    }

    @Override
    public Boolean deleteGroup(int id) {
        return null;
    }
}
