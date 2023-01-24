package br.com.app.domain.cpf.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import br.com.app.domain.cpf.controller.exception.CpfNotFoundException;
import br.com.app.domain.cpf.utils.CpfUtils;
import br.com.app.infrastructure.exception.Error;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CpfService {
	
	 Random random = new Random();

	/**
	 * Validates if cpf is valid
	 * 
	 * @param cpf - cpf string
	 * @throws CpfNotFoundException if cpf is invalid
	 */
	public void validatesCPF(String cpf) {
		if (!CpfUtils.isCPF(cpf))
			throw new CpfNotFoundException(Error.CPF_IS_INVALID.getMessage(), Error.CPF_IS_INVALID.getCode());
	}

	/**
	 * Simulates some service rule that defines if a user is able to vote by cpf
	 * 
	 * @param cpf - cpf string
	 * @return true when is able to vote
	 */
	public boolean isAbleToVote(String cpf) {
		return random.nextBoolean();
	}

}
