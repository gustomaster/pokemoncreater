package work.upar.pokemon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import lombok.RequiredArgsConstructor;
import work.upar.pokemon.model.Pokemon;
import work.upar.pokemon.repository.PokeRepository;
import work.upar.pokemon.service.PokeService;

@RequiredArgsConstructor
@Controller
public class PokeController {

    private final PokeRepository repository;
    
    @GetMapping("/")
    public String showList(Model model) {
        model.addAttribute("pokemons", repository.findAll());
        return "index";
    }

    @GetMapping("/new")
    public String createPokemon(@ModelAttribute Pokemon pokemon) {
        return "form";
    }

    @PostMapping("/update")
    public String process(@Validated @ModelAttribute Pokemon pokemon, BindingResult result) {
        repository.save(pokemon);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String updatePokemon(@PathVariable Long id, Model model) {
        model.addAttribute("pokemon", repository.findById(id));
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String deletePokemon(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }

    @Autowired
    PokeService pokeService;

    @RequestMapping("/search")
    String search(Model model) {
        List<Pokemon> pokemons = pokeService.findAll();
        model.addAttribute("pokemons", pokemons);
        return "search";
    }
    
}
