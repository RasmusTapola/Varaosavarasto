package Varaosavarasto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import Varaosavarasto.domain.Auto;
import Varaosavarasto.domain.OsaRepository;
import Varaosavarasto.domain.Osat;
import Varaosavarasto.domain.AutoRepository;

@Controller
public class OsaController {
	@Autowired
	OsaRepository osaRepository;
	@Autowired
	AutoRepository autoRepository;

	@GetMapping("osat")
	public String showVaraosat(Model model) {
		model.addAttribute("osat", osaRepository.findAll());
		return "osat";
	}

	@GetMapping("addOsa")
	public String addCar(Model model) {
		model.addAttribute("uusiOsa", new Osat());
		model.addAttribute("nimi", autoRepository.findAll());
		return "newOsa";
	}

	@GetMapping("editOsa/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String editOsa(@PathVariable("id") Long id, Model model) {
		model.addAttribute("editOsa", osaRepository.findById(id));
		model.addAttribute("auto", autoRepository.findAll());
		return "editOsa";
	}

	@PostMapping("saveOsa")
	public String saveOsa(Osat osa) {
		osaRepository.save(osa);
		return "redirect:osat";
	}

	@GetMapping("delete/{id}")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteOsa(@PathVariable("id") Long id, Model model) {
		osaRepository.deleteById(id);

		return "redirect:/osat";
	}
}
