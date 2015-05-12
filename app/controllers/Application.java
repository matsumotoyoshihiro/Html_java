package controllers;

import play.mvc.Controller;

import play.mvc.Result;
import views.html.index;
import views.html.tasks;
import views.html.help;

import java.util.List;
import java.util.Arrays;

import models.Task;
import java.util.Date;

public class Application extends Controller {

    public static Result index() {

        return ok(index.render("Your new application is ready."));
    }


    public static Result tasks(){

        Task task   = new Task();
        task.name   = "Pizza を食べる";
        task.period = new Date();
        task.save();

    	List<String> taskList = Arrays.asList("foo", "bar", "baz","pizza");
        return ok(tasks.render(taskList));

    }

    public static Result help(){

    	return ok(help.render());
    }


}
