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
import java.util.Random;

public class Application extends Controller {

    public static Result index() {

        return ok(index.render("Your new application is ready."));
    }


    public static Result tasks(){



        Random rnd = new Random();
        Task task   = new Task();
        task.name   = "ピザ" + rnd.nextInt(10) + "枚食べる";
        task.period = new Date();
        task.save();

        List<Task> taskList = Task.find.all();
        return ok(tasks.render(taskList,task));

    }

    public static Result help(){

    	return ok(help.render());
    }


}
