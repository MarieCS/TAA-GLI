package sample.data.jpa.web;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.data.jpa.domain.PreferencePratique;
import sample.data.jpa.service.PreferencePratiqueDao;

@Controller
@RequestMapping("/pref")
public class PreferencePratiqueController {

	@RequestMapping(value = "/create", method = RequestMethod.PUT)
	@ResponseBody
	public String create() {
		String prefId = "";
		try {
			PreferencePratique pref = new PreferencePratique();
			prefDao.save(pref);
			prefId = String.valueOf(pref.getId());
		} catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "Preference succesfully created with id = " + prefId;
	}

	/**
	 * GET /create --> Create a new sport and save it in the database.
	 */
	@RequestMapping("/get")
	@ResponseBody
	public String get(long userId) {
		Collection<PreferencePratique> pref = null;
		try {
			pref = prefDao.getPreferencePratiqueByUserId(userId);
		} catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "Get succesfully preferences of " + userId + ", wich are " + pref.toString();
	}

	// Private fields

	@Autowired
	private PreferencePratiqueDao prefDao;

}