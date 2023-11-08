package com.qortmdcks.crud3.service;

import com.qortmdcks.crud3.entity.Parent;
import com.qortmdcks.crud3.payload.ParentDto;

import java.util.List;

public interface ParentService {
    ParentDto createParent(ParentDto parentDto);

    List<ParentDto> getAllParent();

    ParentDto getParentById(long id);

    void deleteParentById(long id);

    ParentDto updateParent(ParentDto parentDto, long id);
}
