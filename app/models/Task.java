package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

import play.db.ebean.Model;


@Entity
public class Task extends Model {

	@Id
	public Integer id;

	public String name;

	public Date period;

    public static Finder<Integer, Task> find = new Finder<Integer, Task>(
            Integer.class, Task.class
    );
}
