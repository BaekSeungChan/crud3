package com.qortmdcks.crud3.service.impl;

import com.qortmdcks.crud3.entity.Parent;
import com.qortmdcks.crud3.payload.ParentDto;
import com.qortmdcks.crud3.repository.ParentRepository;
import com.qortmdcks.crud3.service.ParentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ParentServiceImpl implements ParentService {
    private ParentRepository parentRepository;
    private ModelMapper modelMapper;

    public ParentServiceImpl(ParentRepository parentRepository, ModelMapper modelMapper){
        this.parentRepository = parentRepository;
        this.modelMapper  = modelMapper;
    }

    public ParentDto createParent(ParentDto parentDto){
        Parent parent = modelMapper.map(parentDto, Parent.class);
        Parent savedParent = parentRepository.save(parent);

        return modelMapper.map(savedParent, ParentDto.class);
    }
}
