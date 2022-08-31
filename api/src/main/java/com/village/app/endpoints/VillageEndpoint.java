package com.village.app.endpoints;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.village.app.logic.Village;
import com.village.app.logic.VillageTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
public class VillageEndpoint {
    private String basePath = "C:\\projects\\app\\src\\main\\resources\\";
    private ObjectMapper mapper = new ObjectMapper();
    @GetMapping(path = "/village", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getVillage(@RequestParam String id) throws IOException {
        Path path = Path.of(basePath + id);
        return Files.readString(path);
    }

    @PostMapping(path = "/village", produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Village createVillage(@RequestBody VillageTemplate temp) throws IOException {
        Village village = temp.toVillage();
        village.save(basePath + village.id, mapper);
        return village;
    }

    @DeleteMapping(path = "/village/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String deleteVillage(@PathVariable String id) throws IOException {
        String village = getVillage(id);
        Path path = Path.of(basePath + id);
        Files.deleteIfExists(path);
        return village;
    }

}
