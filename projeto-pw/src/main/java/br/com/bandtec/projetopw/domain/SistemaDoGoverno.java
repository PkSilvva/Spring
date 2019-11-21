package br.com.bandtec.projetopw.domain;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Service
public class SistemaDoGoverno {

	private final RestTemplate restTemplate;
	private final String url;

	
	public SistemaDoGoverno() {
		this.restTemplate = new RestTemplate();
		url = "http://localhost:8081/estados";
	}
	public List<Municipio> municipiosDoEstado(String municipio){
		String urlBusca = url + "/tema/" + municipio;
		ResponseEntity<List> resposta =
				restTemplate.getForEntity(urlBusca, List.class);
		return resposta.getBody();
	}
	}




