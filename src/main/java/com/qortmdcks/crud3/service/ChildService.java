package com.qortmdcks.crud3.service;

import com.qortmdcks.crud3.entity.Child;
import com.qortmdcks.crud3.payload.ChildDto;

import java.util.List;

public interface ChildService {
    ChildDto createChild(ChildDto childDto);

    List<ChildDto> getAllChild();

    ChildDto getChildById(long id);

}
