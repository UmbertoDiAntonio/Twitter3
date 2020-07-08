package com.umberto.controller;

import com.umberto.database.UserData;
import com.umberto.other.OutputGenerator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;


import java.time.Month;

@RestController
public class MyController {
    //  @Autowired
    @PostMapping(value = "/post", produces = "application/json")
    public Object getPost() {
        return OutputGenerator.outputPost(UserData.getUserDataList());
    }

    @PostMapping(value = "/post/author/{author}", produces = "application/json")
    public Object getPost(@PathVariable("author") String author, @RequestBody(required = false) String filter) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), author);
    }

    @PostMapping(value = "/post/author/{author}/contains/{message}", produces = "application/json")
    public Object gestPost(@PathVariable("author") String author, @PathVariable("message") String message) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), author, message);
    }

    @PostMapping(value = "/post/author/contains/{message}", produces = "application/json")
    public Object getPost(@PathVariable("message") String message) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), null, message);
    }

    @PostMapping(value = "/post/author/{author}/contains/{message}/year/{year}", produces = "application/json")
    public Object getPost(@PathVariable("author") String author, @PathVariable("message") String message, @PathVariable("year") int year) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), author, message, year);
    }

    @PostMapping(value = "/post/author/contains/{message}/year/{year}", produces = "application/json")
    public Object getPost(@PathVariable("message") String message, @PathVariable("year") int year) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), null, message, year);
    }

    @PostMapping(value = "/post/author/contains/year/{year}", produces = "application/json")
    public Object getPost(@PathVariable("year") int year) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), null, null, year);
    }

    @PostMapping(value = "/post/author/{author}/contains/{message}/year/{year}/month/{month}", produces = "application/json")
    public Object getPost(@PathVariable("author") String author, @PathVariable("message") String message,
                   @PathVariable("year") int year, @PathVariable("month") Month month) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), author, message, year, month);
    }

    @PostMapping(value = "/post/author/contains/{message}/year/{year}/month/{month}", produces = "application/json")
    public Object getPost(@PathVariable("message") String message, @PathVariable("year") int year,
                   @PathVariable("month") Month month) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), null, message, year, month);
    }

    @PostMapping(value = "/post/author/contains/year/{year}/month/{month}", produces = "application/json")
    public Object getPost(@PathVariable("year") int year, @PathVariable("month") Month month) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), null, null, year, month);
    }

    @PostMapping(value = "/post/author/{author}/contains/{message}/year/{year}/month/{month}/day/{day}", produces = "application/json")
    public Object getPost(@PathVariable("author") String author, @PathVariable("message") String message,
                   @PathVariable("year") int year, @PathVariable("month") Month month,
                   @PathVariable("day") int day) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), author, message, year, month, day);
    }

    @PostMapping(value = "/post/author/contains/{message}/year/{year}/month/{month}/day/{day}", produces = "application/json")
    public Object getPost(@PathVariable("message") String message, @PathVariable("year") int year,
                   @PathVariable("month") Month month, @PathVariable("day") int day) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), null, message, year, month, day);
    }

    @PostMapping(value = "/post/author/contains/year/{year}/month/{month}/day/{day}", produces = "application/json")
    public Object getPost(@PathVariable("year") int year, @PathVariable("month") Month month,
                   @PathVariable("day") int day) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), null, null, year, month, day);
    }

    @PostMapping(value = "/post/author/{author}/contains/{message}/year/{year}/month/{month}/day/{day}/hour/{hour}", produces = "application/json")
    public Object getPost(@PathVariable("author") String author, @PathVariable("message") String message,
                   @PathVariable("year") int year, @PathVariable("month") Month month,
                   @PathVariable("day") int day, @PathVariable("hour") int hour) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), author, message, year, month, day, hour);
    }

    @PostMapping(value = "/post/author/contains/{message}/year/{year}/month/{month}/day/{day}/hour/{hour}", produces = "application/json")
    public Object getPost(@PathVariable("message") String message, @PathVariable("year") int year,
                   @PathVariable("month") Month month, @PathVariable("day") int day,
                   @PathVariable("hour") int hour) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), null, message, year, month, day, hour);
    }

    @PostMapping(value = "/post/author/contains/year/{year}/month/{month}/day/{day}/hour/{hour}", produces = "application/json")
    public Object getPost(@PathVariable("year") int year, @PathVariable("month") Month month,
                   @PathVariable("day") int day, @PathVariable("hour") int hour) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), null, null, year, month, day, hour);
    }
    @PostMapping(value = "/post/author/contains/retweet", produces = "application/json")
    public Object getPostReTweet() {
        return OutputGenerator.outputPostRG(UserData.getUserDataList(),"^(RT)");
    }

    @PostMapping(value = "/post/author/contains/tag", produces = "application/json")
    public Object getPostTag() {
        return OutputGenerator.outputPostRG(UserData.getUserDataList(),"^.+(@.)+.");
    }
}





  /*  @GetMapping("/statuses/{entities}/user_mentions/{screen_name}")
    public Course retrieveDetailsForCourse(@PathVariable String entities,
                                           @PathVariable String screen_name) {
        return UserDataService.retrieveCourse(entities, screen_name);
    }*/

