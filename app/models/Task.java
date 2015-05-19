package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

import play.db.ebean.Model;
import play.data.validation.Constraints.*;

@Entity
public class Task extends Model {

	@Id
	public Integer id;



	public Date period;

    public static Finder<Integer, Task> find = new Finder<Integer, Task>(
            Integer.class, Task.class
    );

    @Required
    public String name;
    @Required
    public String pass;

}
