package com.kodilla.transfersgateway.controller;

import com.kodilla.commons.Transfer;
import com.kodilla.transfersgateway.controller.request.TransferRequest;
import com.kodilla.transfersgateway.controller.validator.TransferValidator;
import com.kodilla.transfersgateway.dto.AccountDTO;
import com.kodilla.transfersgateway.provider.AccountsProvider;
import com.kodilla.transfersgateway.service.TransferPoducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/v1/transfers")
@RequiredArgsConstructor
public class TransferController {

	private final TransferPoducer transferPoducer;
	private final AccountsProvider accountsProvider;
	private final TransferValidator transferValidator;

	@PostMapping
	public void saveTransfer(@RequestBody TransferRequest request) {
		log.info("Received transfer request: {}", request);
		Transfer transfer = new Transfer();
		transfer.setAmount(request.getAmount());
		transfer.setRecipientAccount(request.getRecipientAccount());
		transfer.setSenderAccount(request.getSenderAccount());
		transfer.setTitle(request.getTitle());

		Map<String, AccountDTO> allAccounts = accountsProvider.getAllAccounts();
		transferValidator.validateTransfer(transfer, allAccounts);

		transferPoducer.sendTransfer(transfer);
	}
}
