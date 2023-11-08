package com.qortmdcks.crud3.controller;

import com.qortmdcks.crud3.payload.ParentDto;
import com.qortmdcks.crud3.service.ParentService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parent")
public class ParentController {
    private ParentService parentService;

    public ParentController(ParentService parentService){
        this.parentService = parentService;
    }

    @PostMapping
    public ResponseEntity<ParentDto> createParent(@Valid @RequestBody ParentDto parentDto){
        return new ResponseEntity<>(parentService.createParent(parentDto), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ParentDto>> getAllParent(){
        return ResponseEntity.ok(parentService.getAllParent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParentDto> getParentById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(parentService.getParentById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteParentById(@PathVariable(name = "id") long id){
        parentService.deleteParentById(id);
        return new ResponseEntity<>("deleted post", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParentDto> updateParent(@PathVariable(name = "id") long id, @Valid @RequestBody ParentDto parentDto){
        ParentDto parentResponse = parentService.updateParent(parentDto, id);
        return new ResponseEntity<>(parentResponse, HttpStatus.OK);
    }


}
