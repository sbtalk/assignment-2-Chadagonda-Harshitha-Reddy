package com.demo.spring.controllers;

import com.demo.spring.entity.Emp;
import com.demo.spring.service.EmpService;
import com.demo.spring.util.ResponseMessage;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Emp") //base url
public class EmpRestController {
private EmpService empService;
public EmpRestController(EmpService empService){
    this.empService=empService;
}

@GetMapping(path="/",produces= MediaType.APPLICATION_JSON_VALUE) //produces:what server sends, consumes:what server expects
public ResponseEntity<List<Emp>> findAllEmps(){
    return ResponseEntity.ok(empService.getAllEmps());
}

//ResponseEntity<Emp> is used to specify the type of object that will be returned in the http response body
@GetMapping(path="/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Emp> getOneEmp(@PathVariable Integer id){
    return ResponseEntity.ok(empService.getOneEmp(id));
}

@PostMapping(path="/",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Emp> storeemp(@RequestBody Emp e){
    return ResponseEntity.ok(empService.save(e));}

    @PutMapping(path="/",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Emp> update(@RequestBody Emp e){
        return ResponseEntity.ok(empService.update(e));
}

    @DeleteMapping(path="/{id}")
    public ResponseEntity<ResponseMessage> delete(@PathVariable Integer id){

        return ResponseEntity.ok(new ResponseMessage(empService.delete(id)));
    }
//    @PatchMapping(path="/{id}",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Emp> updateEmpPartially(@PathVariable Integer id,@RequestBody Emp emp){
//    return ResponseEntity.ok(empService.partialUpdate(id,emp));
//    }
@PatchMapping(path="/{id}",consumes=MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<Emp> updateEmp(@PathVariable Integer id,@RequestBody Emp emp){
    return ResponseEntity.ok(empService.partialUpdate(id,emp));
}
}