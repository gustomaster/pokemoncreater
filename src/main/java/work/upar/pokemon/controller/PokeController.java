package work.upar.pokemon.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import work.upar.pokemon.entity.Pokemon;
import work.upar.pokemon.entity.Type;
import work.upar.pokemon.entity.Type2;
import work.upar.pokemon.form.PokemonForm;
import work.upar.pokemon.form.SearchForm;
import work.upar.pokemon.repository.PokeRepository;
import work.upar.pokemon.service.PokeService;

/**
 * Controller.
 */
@RequiredArgsConstructor
@Controller
public class PokeController {

    private final PokeRepository repository;

    private Type type;
    private Type2 type2;

    @GetMapping("/")
    public String showList(Model model) {
        List<Pokemon> pokemonList = pokeService.findAll();

        List <PokemonForm> pokemonFormList = new ArrayList<>();
        for (Pokemon pokemon : pokemonList) {
            if (!pokemon.isDeleted()) {
                PokemonForm pokemonForm = new PokemonForm();
                pokemonForm.setId(pokemon.getId());
                pokemonForm.setName(pokemon.getName());
                pokemonForm.setH(pokemon.getH());
                pokemonForm.setA(pokemon.getA());
                pokemonForm.setB(pokemon.getB());
                pokemonForm.setC(pokemon.getC());
                pokemonForm.setD(pokemon.getD());
                pokemonForm.setS(pokemon.getS());
                pokemonForm.setType(pokemon.getType().getName());
                pokemonForm.setType2(pokemon.getType2().getName());
                pokemonFormList.add(pokemonForm);
            }
        }

        model.addAttribute("pokemonFormList", pokemonFormList);
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
        Pokemon pokemon = repository.getOne(id);
        pokemon.setDeleted(true);
        repository.save(pokemon);

        return "redirect:/";
    }

    @Autowired
    PokeService pokeService;

    @GetMapping("/search")
    String search(Model model) {
        List<Pokemon> pokemonList = pokeService.findAll();

        List <PokemonForm> pokemonFormList = new ArrayList<>();
        for (Pokemon pokemon : pokemonList) {
            PokemonForm pokemonForm = new PokemonForm();
            pokemonForm.setId(pokemon.getId());
            pokemonForm.setName(pokemon.getName());
            pokemonForm.setH(pokemon.getH());
            pokemonForm.setA(pokemon.getA());
            pokemonForm.setB(pokemon.getB());
            pokemonForm.setC(pokemon.getC());
            pokemonForm.setD(pokemon.getD());
            pokemonForm.setS(pokemon.getS());
            pokemonForm.setType(pokemon.getType().getName());
            pokemonForm.setType2(pokemon.getType2().getName());
            pokemonFormList.add(pokemonForm);
        }

        model.addAttribute("pokemonFormList", pokemonFormList);
        return "search";
    }

    @PostMapping("/search")
    String search2(@ModelAttribute("form") SearchForm form, Model model) {

        List<Pokemon> pokemons = pokeService.search(form);
        model.addAttribute("pokemons", pokemons);
        return "search";
    }
}
