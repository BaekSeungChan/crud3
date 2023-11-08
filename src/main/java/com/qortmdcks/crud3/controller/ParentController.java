package com.qortmdcks.crud3.controller;

import com.qortmdcks.crud3.payload.ParentDto;
import com.qortmdcks.crud3.service.ParentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parent")
@Tag(name = "Parent API's")
public class ParentController {
    private ParentService parentService;

    public ParentController(ParentService parentService){
        this.parentService = parentService;
    }

    @PostMapping
    @Operation(
            summary = "Create Parent",
            description = "Create Parent API"
    )
    @ApiResponse(responseCode = "201", description = "Created")
    public ResponseEntity<ParentDto> createParent(@Valid @RequestBody ParentDto parentDto){
        return new ResponseEntity<>(parentService.createParent(parentDto), HttpStatus.OK);
    }

    @GetMapping("/all")
    @Operation(
            summary = "Get All Parent",
            description = "Get All Parent API"
    )
    @ApiResponse(responseCode = "200", description = "Get All Parent")
    public ResponseEntity<List<ParentDto>> getAllParent(){
        return ResponseEntity.ok(parentService.getAllParent());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get Parent By Id",
            description = "Get Parent By Id API"
    )
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<ParentDto> getParentById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(parentService.getParentById(id));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete Parent",
            description = "Delete Parent API"
    )
    @ApiResponse(responseCode = "200", description = "Deleted")
    public ResponseEntity<String> deleteParentById(@PathVariable(name = "id") long id){
        parentService.deleteParentById(id);
        return new ResponseEntity<>("deleted post", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update Parent",
            description = "Update Parent API"
    )
    @ApiResponse(responseCode = "200", description = "Update")
    public ResponseEntity<ParentDto> updateParent(@PathVariable(name = "id") long id, @Valid @RequestBody ParentDto parentDto){
        ParentDto parentResponse = parentService.updateParent(parentDto, id);
        return new ResponseEntity<>(parentResponse, HttpStatus.OK);
    }


}
