package com.kodilla.transfersgateway.provider;

import com.kodilla.transfersgateway.connector.AccountsConnector;
import com.kodilla.transfersgateway.dto.AccountDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountsProvider {

	private final AccountsConnector accountsConnector;
	private Map<String, AccountDTO> accountNrbMap = new LinkedHashMap<>();

	public Map<String, AccountDTO> getAllAccounts() {
		return accountsConnector.getAccounts()
				.getAccounts()
				.stream()
				.collect(Collectors.toMap(account -> account.getNrb(), account -> new AccountDTO(
						account.getId(),
						account.getCustomerId(),
						account.getNrb(),
						account.getCurrency(),
						account.getAvailableFunds()
				)));
	}
}
