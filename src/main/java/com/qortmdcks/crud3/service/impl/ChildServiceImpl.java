package com.qortmdcks.crud3.service.impl;

import com.qortmdcks.crud3.entity.Child;
import com.qortmdcks.crud3.payload.ChildDto;
import com.qortmdcks.crud3.repository.ChildRepository;
import com.qortmdcks.crud3.service.ChildService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<ChildDto> getAllChild(){
        List<Child> childs = childRepository.findAll();

        return childs.stream().map((child) -> modelMapper.map(child, ChildDto.class)).collect(Collectors.toList());
    }

    @Override
    public ChildDto getChildById(long id){
        Child child = childRepository.findById(id).orElseThrow(() -> new RuntimeException("No id"));

        return modelMapper.map(child, ChildDto.class);
    }


}
