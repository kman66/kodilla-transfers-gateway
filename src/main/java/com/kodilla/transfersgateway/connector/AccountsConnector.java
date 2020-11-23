package com.kodilla.transfersgateway.connector;

import com.kodilla.transfersgateway.mapper.GetAccountsResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "accounts")
public interface AccountsConnector {
	@GetMapping("/v1/accounts/")
	GetAccountsResponse getAccounts();
}
