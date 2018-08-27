package com.team.players;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.players.entity.Players;
import com.team.players.repo.PlayersDao;

@Controller
public class PlayersController {

	@Autowired
	PlayersDao p;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("players", p.findAll());
		System.out.println(p.findAll());
		return "index";
	}

	@RequestMapping("/search")
	public ModelAndView search(@RequestParam("id") String id) {
		Players p1 = p.findById(id);
		System.out.println(p1);

		return new ModelAndView("search", "players", p1);
	}

	@PostMapping("/addplayer")
	public ModelAndView addNewPlayer(@RequestParam("id") String id, @RequestParam("pos") String pos,
			@RequestParam("team") String team, @RequestParam("bench") String bench,
			@RequestParam("points") double points) {
		Players p1 = new Players(id, pos, team, bench, points);
		p.update(p1);
		return new ModelAndView("index", "players", p.findAll());
	}

	@RequestMapping("/add")
	public ModelAndView showAddPlayerForm() {
		return new ModelAndView("/add");
	}

	@RequestMapping("/index")
	public ModelAndView updatePlayerForm() {
		return new ModelAndView("/index");
	}

	@RequestMapping("/players/{id}/update")
	public ModelAndView showEditForm(@PathVariable("id") String id) {
		ModelAndView mv = new ModelAndView("update");
		mv.addObject("title", "Update Players");
		mv.addObject("players", p.findById(id));
		return mv;
	}

	@PostMapping("/players/{id}/update")
	public ModelAndView submitEditForm(Players players, @PathVariable("id") String id) {
		players.setId(id);
		p.update(players);
		return new ModelAndView("redirect:/players");
	}

	@PostMapping("/updateperson")
	public ModelAndView updatePerson(@RequestParam("id") String id, @RequestParam("pos") String pos) {

		Players p1 = new Players(id, pos);
		p.update(p1);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping("/delete")
	public ModelAndView remove(@RequestParam("id") String id) {
		p.deleteById(id);
		return new ModelAndView("redirect:/");
	}
}
