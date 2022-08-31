package com.webVillage.app.restControllers;

import model.Civilian;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Random;

@RestController
public class CivilianController {

    private HashMap<Integer, Civilian> civilians = new HashMap<>();
    private Random random = new Random();

    @GetMapping(path = "/civilian/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Civilian getCivilian(@PathVariable(required=false) Integer id) {
        if ((id == null) || (civilians.get(id) == null)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ID is not good to me");
        }
        return civilians.get(id);
    }

    @PostMapping(path = "/civilian", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Civilian createCivilian(@Valid @RequestBody Civilian person) {
        Integer id = random.nextInt(2000000000);
        person.setId(id);
        civilians.put(id, person);
        System.out.println(civilians);
        return person;
    }

    @PutMapping(path = "/civilian", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Civilian updateCivilian(@Valid @RequestBody Civilian person) {
        civilians.put(person.getId(), person);
        return person;
    }

    @DeleteMapping(path = "/civilian/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Civilian deleteCivilian(@PathVariable Integer id) {
        Civilian person = this.getCivilian(id);
        civilians.remove(id);
        return person;
    }

    @GetMapping(path = "/civilian", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HashMap<Integer, Civilian> getAllCivilians() {
        return civilians;
    }
}
