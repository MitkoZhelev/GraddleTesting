package com.example.SpringOverview;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/app")
public class MoviesController {


    List<String> movies;

    public MoviesController(){
        this.movies = new ArrayList<String>();
        int count = 10;
        for (int i = 0; i <count ; i++) {
            movies.add("Movie #" + (i+1));
        }
    }

    @RequestMapping(value ="/movies", method = RequestMethod.GET)
    public List<String> getAll ()
    {
        return this.movies;
    }
    @GetMapping("/movies1")
    public String addMovie ( @RequestParam("name") String name)
    {
        this.movies.add(name);
        return name;
    }
}
