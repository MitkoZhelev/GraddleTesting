package com.example.SpringOverview.controllers;

import movies.models.Movie;
import movies.utils.IdGenerator;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/app")
public class MoviesController {


    List<Movie> movies;
    IdGenerator idGenerator ;

    public MoviesController(){
        this.movies = new ArrayList<Movie>( );
        this.idGenerator = new IdGenerator();
        int count = 10;

        for (int i = 0; i <count ; i++) {
            Movie movie = new Movie();

            movie.setId(this.idGenerator.getNextId());
            movie.setTitle("Movie number" + (i+1));
            movie.setDescription("Description for movie" + (i+1));
            movie.setRating(1 +i%5);
            movie.setVotesCount(5);
            movies.add(movie);
        }
    }

    @RequestMapping(value ="/movies", method = RequestMethod.GET)
    public List<Movie> getAll ()
    {
        return this.movies;
    }
    @PostMapping("/movies1")
    public Movie addMovie ( @RequestBody Movie newMovie)
    {
        newMovie.setId(this.idGenerator.getNextId());
        newMovie.setRating(0);
        newMovie.setVotesCount(0);
        this.movies.add(newMovie);
        return newMovie;
    }
    @RequestMapping (value="/getById/{MovieId}",method = RequestMethod.GET)
        public Movie getById(@PathVariable(value="MovieId") int id)
        {
            for(Movie currentMovie : this.movies){
                if(currentMovie.getId() == id)
                {
                    return currentMovie;
                }

            }
            return null;
        }

}
