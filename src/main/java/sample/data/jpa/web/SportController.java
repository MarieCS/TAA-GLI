package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.data.jpa.domain.Sport;
import sample.data.jpa.service.SportDao;

@Controller
@RequestMapping("/sport")
public class SportController {

	/**
	 * GET /create --> Create a new sport and save it in the database.
	 */
	@RequestMapping("/create")
	@ResponseBody
	public String create(String name) {
		String sportId = "";
		try {
			Sport sport = new Sport();	
			sport.setName(name);
			sportDao.save(sport);
			sportId = String.valueOf(sport.getId());
		} catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "Sport succesfully created with id = " + sportId;
	}

	/**
	 * GET /delete --> Delete the user having the passed id.
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(long id) {
		try {
			Sport sport = new Sport();
			sport.setId(id);
			sportDao.delete(sport);
		} catch (Exception ex) {
			return "Error deleting the user:" + ex.toString();
		}
		return "User succesfully deleted!";
	}

	/**
	 * GET /update --> Update the email and the name for the user in the database
	 * having the passed id.
	 */
	@RequestMapping("/update")
	@ResponseBody
	public String updateUser(long id, String email, String name) {
		try {
			Sport sport = sportDao.findOne(id);
			sport.setName(name);
			sportDao.save(sport);
		} catch (Exception ex) {
			return "Error updating the user: " + ex.toString();
		}
		return "User succesfully updated!";
	}

	// Private fields

	@Autowired
	private SportDao sportDao;

}