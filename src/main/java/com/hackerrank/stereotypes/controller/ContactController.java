package com.hackerrank.stereotypes.controller;

import com.hackerrank.stereotypes.model.Person;
import com.hackerrank.stereotypes.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.ws.rs.PathParam;
import org.springframework.beans.factoryy.annotation.Autowired;


@Controller
public class ContactController {
    
    @Autowired
    ContactService contactService;

    @ResponseBody
   @RequestMapping(method = RequestMethod.POST, value="/contact/save")
    public ResponseEntity<Person> save(Person person){
        Person saved = contactService.save(person);
        return new ResponseEntity(saved, HttpStatus.CREATED);
    }
   @ResponseBody
   @RequestMapping(method = RequestMethod.GET, value="/contact/retrieve/{id}")
    public ResponseEntity<Person> retrieve(@PathParam("id")Integer id){
        Person person = contactService.retrieve(id);
        return new ResponseEntity(person, HttpStatus.OK);
    }
}
