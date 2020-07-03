package com.umberto;

import com.umberto.database.UserData;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.time.Month;
import java.util.List;
import java.util.Map;

@Controller
public class UserDataController {
    //  @Autowired
    //   private ClassService classService;
    @RequestMapping(value = "/post", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Object getPost() {
        return OutputGenerator.outputPost(UserData.getUserDataList());
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    String hello() {
        return "Hello, world!";
    }

    @RequestMapping(value = "/post/author/{author}", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Object getPost(@PathVariable("author") String author, @RequestBody(required = false) String filter) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), author);
    }

    @RequestMapping(value = "/post/author/{author}/text/{message}", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Object gestPost(@PathVariable("author") String author, @PathVariable("message") String message) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), author, message);
    }

    @RequestMapping(value = "/post/all/text/{message}", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Object getPost(@PathVariable("message") String message) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), null, message);
    }

    @RequestMapping(value = "/post/author/{author}/text/{message}/year/{year}", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Object getPost(@PathVariable("author") String author, @PathVariable("message") String message, @PathVariable("year") int year) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), author, message, year);
    }

    @RequestMapping(value = "/post/all/text/{message}/year/{year}", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Object getPost(@PathVariable("message") String message, @PathVariable("year") int year) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), null, message, year);
    }

    @RequestMapping(value = "/post/all/all/year/{year}", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Object getPost(@PathVariable("year") int year) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), null, null, year);
    }

    @RequestMapping(value = "/post/author/{author}/text/{message}/year/{year}/month/{month}", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Object getPost(@PathVariable("author") String author, @PathVariable("message") String message,
                   @PathVariable("year") int year, @PathVariable("month") Month month) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), author, message, year, month);
    }

    @RequestMapping(value = "/post/all/text/{message}/year/{year}/month/{month}", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Object getPost(@PathVariable("message") String message, @PathVariable("year") int year,
                   @PathVariable("month") Month month) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), null, message, year, month);
    }

    @RequestMapping(value = "/post/all/all/year/{year}/month/{month}", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Object getPost(@PathVariable("year") int year, @PathVariable("month") Month month) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), null, null, year, month);
    }

    @RequestMapping(value = "/post/author/{author}/text/{message}/year/{year}/month/{month}/day/{day}", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Object getPost(@PathVariable("author") String author, @PathVariable("message") String message,
                   @PathVariable("year") int year, @PathVariable("month") Month month,
                   @PathVariable("day") int day) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), author, message, year, month, day);
    }

    @RequestMapping(value = "/post/all/text/{message}/year/{year}/month/{month}/day/{day}", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Object getPost(@PathVariable("message") String message, @PathVariable("year") int year,
                   @PathVariable("month") Month month, @PathVariable("day") int day) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), null, message, year, month, day);
    }

    @RequestMapping(value = "/post/all/all/year/{year}/month/{month}/day/{day}", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Object getPost(@PathVariable("year") int year, @PathVariable("month") Month month,
                   @PathVariable("day") int day) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), null, null, year, month, day);
    }

    @RequestMapping(value = "/post/author/{author}/text/{message}/year/{year}/month/{month}/day/{day}/hour/{hour}", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Object getPost(@PathVariable("author") String author, @PathVariable("message") String message,
                   @PathVariable("year") int year, @PathVariable("month") Month month,
                   @PathVariable("day") int day, @PathVariable("hour") CharSequence hour) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), author, message, year, month, day, hour);
    }

    @RequestMapping(value = "/post/all/text/{message}/year/{year}/month/{month}/day/{day}/hour/{hour}", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Object getPost(@PathVariable("message") String message, @PathVariable("year") int year,
                   @PathVariable("month") Month month, @PathVariable("day") int day,
                   @PathVariable("hour") CharSequence hour) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), null, message, year, month, day, hour);
    }

    @RequestMapping(value = "/post/all/all/year/{year}/month/{month}/day/{day}/hour/{hour}", method = RequestMethod.POST, produces = "application/json")
    public @ResponseBody
    Object getPost(@PathVariable("year") int year, @PathVariable("month") Month month,
                   @PathVariable("day") int day, @PathVariable("hour") CharSequence hour) {
        return OutputGenerator.outputPost(UserData.getUserDataList(), null, null, year, month, day, hour);
    }
}





  /*  @GetMapping("/statuses/{entities}/user_mentions/{screen_name}")
    public Course retrieveDetailsForCourse(@PathVariable String entities,
                                           @PathVariable String screen_name) {
        return UserDataService.retrieveCourse(entities, screen_name);
    }*/

