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
}
