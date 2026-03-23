package com.demo.spring.service;
import com.demo.spring.entity.Emp;
import com.demo.spring.exceptions.EmpExistsException;
import com.demo.spring.exceptions.EmpNotFoundException;
import com.demo.spring.repositories.EmpRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class EmpService {
    private EmpRepository empRepository;
    public EmpService(EmpRepository empRepository){
    this.empRepository=empRepository;
    }
    public List<Emp> getAllEmps(){
        return this.empRepository.findAll();
    }
    //for fetch/delete by id we pass only what is required
    public Emp getOneEmp(Integer id){
        Optional<Emp> empOP=empRepository.findById(id);
        if(empOP.isPresent()){
            return empOP.get();}
        else{
            throw new EmpNotFoundException("Emp with Id "+id+" not found");}}
    //for create/update we pass the full object
    public Emp save(Emp e){
        if(empRepository.existsById(e.getEmpId())){
            throw new EmpExistsException(("emp exists in database"));}
        else{
            return empRepository.save(e);}}
    public String delete(Integer id) {
        if (empRepository.existsById(id)) {
            empRepository.deleteById(id);
            return "deleted";
        } else {
            throw new EmpNotFoundException("Emp with Id " + id + " not found");}}
    public Emp update(Emp e){
        if(!empRepository.existsById(e.getEmpId())){
            throw new EmpExistsException(("does not exist in database"));}
        else{
            return empRepository.save(e);
        }
    }
    //PATCH
    public Emp partialUpdate(Integer id,Emp partialEmp){
        Emp targetEmp=empRepository.findById(id).orElseThrow(()->new EmpNotFoundException("emp not found"));
        if(partialEmp.getName()!=null){
            targetEmp.setName(partialEmp.getName());
        }
        if(partialEmp.getSalary()!=0.0){
            targetEmp.setSalary(partialEmp.getSalary());
        }
        if(partialEmp.getCity()!=null){
            targetEmp.setName(partialEmp.getCity());
        }
        return empRepository.save(targetEmp);
    }
}
