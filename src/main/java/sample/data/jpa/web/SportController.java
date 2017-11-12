package sample.data.jpa.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.data.jpa.domain.Sport;
import sample.data.jpa.service.SportDao;

@Controller
@RequestMapping("/sport")
public class SportController {

	/**
	 * create --> Create a new sport and save it in the database.
	 */
	@RequestMapping(value = "/create", method = RequestMethod.PUT)
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

	
	@RequestMapping(value = "/delete" , method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(Long id) {
		try {
			Sport sport = sportDao.findOne(id);
			if(sport == null) {
				return "The sport dosen't exists";
			}else {
				sportDao.delete(sport);
			}
			
		} catch (Exception ex) {
			return "Error deleting the sport:" + ex.toString();
		}
		return "Sport succesfully deleted!";
	}

	@RequestMapping(value = "/update" , method = RequestMethod.POST)
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
	
	
	@RequestMapping("/get-all")
	@ResponseBody
	public List<Sport> getAll() {
		List<Sport> sports = null;
		try {
			sports = sportDao.findAll();
			
		} catch (Exception ex) {
			return null;
		}
		return sports;
	}

	// Private fields

	@Autowired
	private SportDao sportDao;

}