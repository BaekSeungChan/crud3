package com.qortmdcks.crud3.controller;

import com.qortmdcks.crud3.payload.ChildDto;
import com.qortmdcks.crud3.service.ChildService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/child")
public class ChildController {
    private ChildService childService;

    public ChildController(ChildService childService){
        this.childService = childService;
    }


    @PostMapping
    public ResponseEntity<ChildDto> createChild(@Valid @RequestBody ChildDto childDto){
        return new ResponseEntity<>(childService.createChild(childDto), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ChildDto>> getAllChild(){
        return ResponseEntity.ok(childService.getAllChild());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChildDto> getChildById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(childService.getChildById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChildById(@PathVariable(name = "id") long id){
        childService.deleteChildById(id);
        return new ResponseEntity<>("deleted post", HttpStatus.OK);
    }
}
