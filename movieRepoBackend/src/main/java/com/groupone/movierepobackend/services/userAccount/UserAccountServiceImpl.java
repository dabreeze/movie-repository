package com.groupone.movierepobackend.services.userAccount;

import com.groupone.movierepobackend.data.dtos.UserAccountRequestDto;
import com.groupone.movierepobackend.data.dtos.UserAccountResponseDto;
import com.groupone.movierepobackend.data.models.UserAccount;
import com.groupone.movierepobackend.data.repositories.UserAccountRepository;
import com.groupone.movierepobackend.web.exceptions.UserAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService{

    @Autowired
    UserAccountRepository userAccountRepository;

    @Override
    public UserAccountResponseDto createMovieUser(UserAccountRequestDto requestDto) throws UserAccountException {
        //check that user exists
        Optional<UserAccount> savedUserAccount = userAccountRepository.findByEmail(requestDto.getEmail());
        if (savedUserAccount.isPresent()){
            throw new UserAccountException("This User already exists");
        }

        //create a movie user
        UserAccount newUser = new UserAccount();
        newUser.setFirstName(requestDto.getFirstName());
        newUser.setLastName(requestDto.getLastName());
        newUser.setEmail(requestDto.getEmail());
        newUser.setPassword(requestDto.getPassword());

        //save newly created user
        userAccountRepository.save(newUser);

        //return response
        return buildResponse(newUser);
    }

    private UserAccountResponseDto buildResponse(UserAccount userAccount){
        return UserAccountResponseDto.builder()
                .firstName(userAccount.getFirstName())
                .lastName(userAccount.getLastName())
                .email(userAccount.getEmail())
                .build();
    }
}
