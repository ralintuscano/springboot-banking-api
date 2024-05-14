package org.example.spring_boot_bank_api.models.mappers;

import org.example.spring_boot_bank_api.models.dtos.request.account.AccountRequestDTO;
import org.example.spring_boot_bank_api.models.dtos.response.account.AccountResponseDTO;
import org.example.spring_boot_bank_api.models.entities.Account;
import org.example.spring_boot_bank_api.models.entities.User;
import org.example.spring_boot_bank_api.services.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserService.class})
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    @Mapping(target = "accountId", ignore = true)
    @Mapping(source = "userId", target = "user")
    public Account accountRequestDtoToAccount(AccountRequestDTO accountRequestDTO);

    @Mapping(source = "user", target = "userId")
    public AccountResponseDTO accountToAccountResponseDTO(Account account);

    @Mapping(source = "user", target = "userId")
    public List<AccountResponseDTO> accountToAccountResponseDTO(List<Account> accounts);

    default Long map(User user) {
        return user.getUserId();
    }
}
