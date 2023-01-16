package br.com.app.domain.cpf.controller.operations.fetch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.domain.cpf.controller.operations.fetch.response.CpfFetchResponse;
import br.com.app.domain.cpf.controller.operations.fetch.response.CpfStatus;
import br.com.app.domain.cpf.service.CpfService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@CrossOrigin
@RestController
@RequestMapping("/users")
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor(onConstructor_ = @Autowired)
public class CpfFetchController {
	
	CpfService cpfService;
	
	@GetMapping("/{cpf}")
	@ResponseStatus(HttpStatus.OK)
	public CpfFetchResponse isAbleToVoteByCpf(@PathVariable("cpf") String cpf) {
		cpfService.validatesCPF(cpf);
		
		if(cpfService.isAbleToVote(cpf)) {
			return CpfFetchResponse.builder().status(CpfStatus.ABLE_TO_VOTE).build();
		}else {
			return CpfFetchResponse.builder().status(CpfStatus.UNABLE_TO_VOTE).build();
		}
	}

}
