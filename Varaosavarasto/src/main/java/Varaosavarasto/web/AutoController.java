package Varaosavarasto.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import Varaosavarasto.domain.Auto;
import Varaosavarasto.domain.AutoRepository;

@Controller
public class AutoController {

	@Autowired
	AutoRepository autoRepository;

	@GetMapping("autot")
	public String getOwners(Model model) {
		model.addAttribute("autot", autoRepository.findAll());
		return "autot";
	}

	@GetMapping("addAuto")
	public String addAuto(Model model) {
		model.addAttribute("auto", new Auto());
		return "addAuto";
	}

	@PostMapping("saveAuto")
	public String saveAuto(@Valid Auto nimi, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			System.out.println("some error happened");
			return "addAuto";
		}
		autoRepository.save(nimi);
		return "redirect:autot";

	}

}
