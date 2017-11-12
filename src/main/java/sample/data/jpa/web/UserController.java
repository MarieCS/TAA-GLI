package sample.data.jpa.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.data.jpa.domain.Lieu;
import sample.data.jpa.domain.Personne;
import sample.data.jpa.domain.PreferencePratique;
import sample.data.jpa.domain.Sport;
import sample.data.jpa.domain.User;
import sample.data.jpa.service.PersonneDao;
import sample.data.jpa.service.PreferencePratiqueDao;
import sample.data.jpa.service.SportDao;
import sample.data.jpa.service.UserDao;

@Controller
@RequestMapping("/user")
public class UserController {

	/**
	 * create --> Create a new user and save it in the database.
	 */
	@RequestMapping(value = "/create", method = RequestMethod.PUT)
	@ResponseBody
	
	public String create(String email, String name) {
		String userId = "";
		try {
			Personne personne = new Personne();
			personne.setName(name);
			personne.setMail(email);
			personneDao.save(personne);
			userId = String.valueOf(personne.getId());
		} catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "User succesfully created with id = " + userId;
	}

	@RequestMapping(value ="/addPref" , method = RequestMethod.POST)
	@ResponseBody
	public String addPreferencePratique(long userId, long sportId, long prefId) {
		try {
			Personne personne = personneDao.getOne(userId);
			PreferencePratique pref = prefDao.findOne(prefId);
			Sport sport = sportDao.findOne(sportId);
			personne.getPreferences().put(sport, pref);
			personneDao.save(personne);
		} catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "User succesfully created with id = " + userId;
	}

	/**
	 * delete --> Delete the user having the passed id.
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public String delete(long id) {
		try {
			User user = new User(id);
			userDao.delete(user);
		} catch (Exception ex) {
			return "Error deleting the user:" + ex.toString();
		}
		return "User succesfully deleted!";
	}
	

	@RequestMapping("/get-all")
	@ResponseBody
	public List<User> getAllUsers() {
		List<User> users = null;
		try {
			users = userDao.findAll();
		} catch (Exception ex) {
			return null;
		}
		return users;
	}

	/**
	 * GET /get-by-email --> Return the id for the user having the passed email.
	 */
	@RequestMapping("/get-by-email")
	@ResponseBody
	public String getByEmail(String email) {
		String userId = "";
		try {
			User user = userDao.findByEmail(email);
			userId = String.valueOf(user.getId());
		} catch (Exception ex) {
			return "User not found";
		}
		return "The user id is: " + userId;
	}

	/**
	 * update --> Update the email and the name for the user in the database
	 * having the passed id.
	 */
	@RequestMapping(value ="/update" , method = RequestMethod.POST)
	@ResponseBody
	public String updateUser(long id, String email, String name) {
		try {
			User user = userDao.findOne(id);
			user.setEmail(email);
			user.setName(name);
			userDao.save(user);
		} catch (Exception ex) {
			return "Error updating the user: " + ex.toString();
		}
		return "User succesfully updated!";
	}

	/**
	 * GET the best place to practices sports
	 */
	@RequestMapping(value = "/{userId}")
	@ResponseBody
	public String getPrevision(@PathVariable Long userId) {

		previsions.getPrevision();
		
		try {
			Personne personne = personneDao.getOne(userId);
			// Map<lieu, Object> meteo;
			for (Lieu lieu : personne.getLieux()) {
				
			}
			for (Entry<Sport, PreferencePratique> entry : personne.getPreferences().entrySet()) {

			}
		} catch (Exception ex) {
			// return "Error getting the user: " + ex.toString();
		}
		return "User id = " + userId + "\n";
	}

	// Private fields

	@Autowired
	private UserDao userDao;

	@Autowired
	private PersonneDao personneDao;

	@Autowired
	private PreferencePratiqueDao prefDao;

	@Autowired
	private SportDao sportDao;

	@Autowired
	private Previsions previsions;

}