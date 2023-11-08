package com.qortmdcks.crud3.service.impl;

import com.qortmdcks.crud3.entity.Child;
import com.qortmdcks.crud3.payload.ChildDto;
import com.qortmdcks.crud3.repository.ChildRepository;
import com.qortmdcks.crud3.service.ChildService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ChildServiceImpl implements ChildService {

    private ChildRepository childRepository;

    private ModelMapper modelMapper;

    public ChildServiceImpl(ChildRepository childRepository, ModelMapper modelMapper){
        this.childRepository = childRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ChildDto createChild(ChildDto childDto){
        Child child = modelMapper.map(childDto, Child.class);
        Child savedChild = childRepository.save(child);

        return modelMapper.map(savedChild, ChildDto.class);
    }


}
