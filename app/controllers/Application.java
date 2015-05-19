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
import play.data.validation.Constraints.*;
import play.data.Form;

/* activetor h2-(ブラウザ) run
   を行って、どのように表示されるかテストする */

public class Application extends Controller {


	public static Result index() {

    	System.out.println(flash("foo"));
        return ok(index.render("Your new application is ready."));


    }


	public static Form<Task> taskForm = Form.form(Task.class);

    public static Result tasks(){
    	 List<Task> taskList = Task.find.all();
         return ok(tasks.render(taskList, taskForm));


    }

    public static Result help(){

    	return ok(help.render());
    }


    public static Result createTask() {

    	Form<Task> form = taskForm.bindFromRequest();

        if (form.hasErrors()) {
            List<Task> taskList = Task.find.all();

            // 制約エラーが発生したら、その情報を持っ form を渡してあげる
            return badRequest(tasks.render(taskList, form));
        } else {
            Task newTask = form.get();
            newTask.save();
            return redirect(routes.Application.tasks());
        }

    }






}
