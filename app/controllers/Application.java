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
import java.util.Map;

public class Application extends Controller {

    public static Result index() {

        return ok(index.render("Your new application is ready."));
    }


    public static Result tasks(){

        Random rnd = new Random();
        Task task   = new Task();
        task.name   = "ピザを" + rnd.nextInt(10) + "枚食べる";
        task.period = new Date();
        task.save();

        List<Task> taskList = Task.find.all();
        return ok(tasks.render(taskList,task));

    }

    public static Result help(){

    	return ok(help.render());
    }


    public static Result createTask() {
        // java.util.Map をインポートしておく
        Map<String, String[]> params = request().body().asFormUrlEncoded();

        Task newTask = new Task();
        newTask.name = params.get("name")[0]; // <input type="text" name="name" /> に入力された値
        newTask.save();
        return redirect(routes.Application.tasks());
    }


}
