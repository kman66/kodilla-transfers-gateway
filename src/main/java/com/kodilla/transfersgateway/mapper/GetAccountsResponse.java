package com.kodilla.transfersgateway.mapper;

import com.kodilla.transfersgateway.dto.AccountDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAccountsResponse {
	private List<AccountDTO> accounts;
}
