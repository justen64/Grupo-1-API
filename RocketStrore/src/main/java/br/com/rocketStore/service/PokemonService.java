package br.com.rocketStore.service;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.google.gson.Gson;

import br.com.rocketStore.DTO.PokemonDTO;
import br.com.rocketStore.DTO.PokemonResponseDTO;
import br.com.rocketStore.DTO.TypesDTO;
import br.com.rocketStore.entity.Pokemon;
import br.com.rocketStore.entity.Sprites;
import br.com.rocketStore.entity.Types;
import br.com.rocketStore.exception.ResourceNotFoundException;
import br.com.rocketStore.repository.PokemonRepository;

@Service
public class PokemonService {

	@Autowired
	private PokemonRepository repository;

	public List<PokemonResponseDTO> inserir() throws Exception {
		List<Pokemon> pokemons = new ArrayList<>();
		
		for (int i = 1; i <= 1025; i++) {
			Random random = new Random();
	        Double numero = random.nextDouble(5000)+1;
	        NumberFormat formatter = new DecimalFormat("#0.00");
	        
	        
			URL url = new URL("https://pokeapi.co/api/v2/pokemon-form/" + i + "/");
			URLConnection connection = url.openConnection();
			InputStream is = connection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

			Pokemon pokemon1 = new Pokemon();
			String pokemon = "";
			StringBuilder jsonPokemon = new StringBuilder();

			while ((pokemon = br.readLine()) != null) {
				jsonPokemon.append(pokemon);
			}

			PokemonDTO pokemonAux = new Gson().fromJson(jsonPokemon.toString(), PokemonDTO.class);

			pokemon1.setNome(pokemonAux.getName());
			pokemon1.setOrdem(pokemonAux.getId());
			Sprites sprites = new Sprites(pokemonAux.getSprites().getBack_default(), pokemonAux.getSprites().getBack_female(),
					pokemonAux.getSprites().getBack_shiny(),pokemonAux.getSprites().getBack_shiny_female(),pokemonAux.getSprites().getFront_default(),
					pokemonAux.getSprites().getFront_female(), pokemonAux.getSprites().getFront_shiny(),
					pokemonAux.getSprites().getFront_shiny_female(), pokemonAux.getSprites().getPokemon());
			
			TypesDTO typesSave1 = new TypesDTO(1, pokemonAux.getTypes().get(0).getType());
			if (pokemonAux.getTypes().size() < 2) {
				Types typeSkill = new Types(typesSave1.getSlot(), 2, typesSave1.getType().getName(), "Nulo");
				Pokemon save = new Pokemon(pokemonAux.getName(), pokemonAux.getId(), typeSkill, sprites);
				String formattedNumber = formatter.format(numero);
				formattedNumber = formattedNumber.replace(",", ".");
				Double num = Double.parseDouble(formattedNumber);
				save.setValorUnitario(num);
				repository.save(save);
				pokemons.add(save);
			} else {
				TypesDTO typesSave2 = new TypesDTO(2, pokemonAux.getTypes().get(1).getType());
				Types typeSkill = new Types(typesSave1.getSlot(), typesSave2.getSlot(), typesSave1.getType().getName(),
						typesSave2.getType().getName());
				Pokemon save = new Pokemon(pokemonAux.getName(), pokemonAux.getId(), typeSkill, sprites);
				String formattedNumber = formatter.format(numero);
				formattedNumber = formattedNumber.replace(",", ".");
				Double num = Double.parseDouble(formattedNumber);
				save.setValorUnitario(num);
				repository.save(save);
				pokemons.add(save);
			}	
			
		}
		return pokemons.stream().map(pok -> new PokemonResponseDTO(pok)).collect(Collectors.toList());
	}

	public List<PokemonResponseDTO> listarPokemon() {
		List<Pokemon> pokemon = repository.findAll();
		return pokemon.stream().map((pok) -> new PokemonResponseDTO(pok)).collect(Collectors.toList());
               
	}	
	
	public Pokemon buscar(Long id) {
		Pokemon pokemon = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pokemon não encontrado!"));
		return pokemon;
	}
	
	public Sprites buscarSprites(Long id) {
		Pokemon pokemon = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Pokemon não encontrado!"));
		return pokemon.getSprites();
	}
	
    public byte[] retrieveImageData(String imageUrl) {
        try {
            URL url = new URL(imageUrl);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try (InputStream is = url.openStream()) {
                byte[] buffer = new byte[1024];
                int n;
                while ((n = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, n);
                }
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String determineImageType(String imageUrl) {
        if (imageUrl.endsWith(".png")) {
            return "image/png";
        } else if (imageUrl.endsWith(".jpg") || imageUrl.endsWith(".jpeg")) {
            return "image/jpeg";
        } else {
            return "application/octet-stream";
        }
    }
}
