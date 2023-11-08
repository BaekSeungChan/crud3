package com.qortmdcks.crud3.controller;

import com.qortmdcks.crud3.payload.ChildDto;
import com.qortmdcks.crud3.service.ChildService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/child")
@Tag(name = "Child API's")
public class ChildController {
    private ChildService childService;

    public ChildController(ChildService childService){
        this.childService = childService;
    }


    @PostMapping
    @Operation(
            summary = "Create Child",
            description = "Create Child API"
    )
    @ApiResponse(responseCode = "201", description = "Created")
    public ResponseEntity<ChildDto> createChild(@Valid @RequestBody ChildDto childDto){
        return new ResponseEntity<>(childService.createChild(childDto), HttpStatus.OK);
    }

    @GetMapping("/all")
    @Operation(
            summary = "Get All Child",
            description = "Get All Child API"
    )
    @ApiResponse(responseCode = "200", description = "Get All Child")
    public ResponseEntity<List<ChildDto>> getAllChild(){
        return ResponseEntity.ok(childService.getAllChild());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Get Child By Id",
            description = "Get Child By Id API"
    )
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<ChildDto> getChildById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(childService.getChildById(id));
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete Child",
            description = "Delete Child API"
    )
    @ApiResponse(responseCode = "200", description = "Deleted")
    public ResponseEntity<String> deleteChildById(@PathVariable(name = "id") long id){
        childService.deleteChildById(id);
        return new ResponseEntity<>("deleted post", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Update Child",
            description = "Update Child API"
    )
    @ApiResponse(responseCode = "200", description = "Update")
    public ResponseEntity<ChildDto> updateChild(@PathVariable(name = "id") long id, @Valid @RequestBody ChildDto childDto){
        ChildDto childResponse = childService.updateChild(childDto, id);
        return new ResponseEntity<>(childResponse, HttpStatus.OK);
    }
}
