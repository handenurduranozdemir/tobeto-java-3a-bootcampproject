package com.tobeto.bootcampProject.business.concretes;

import com.tobeto.bootcampProject.business.abstracts.UserService;
import com.tobeto.bootcampProject.business.responses.get.GetAllUserResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByEmailUserResponse;
import com.tobeto.bootcampProject.business.responses.get.GetByIdUserResponse;
import com.tobeto.bootcampProject.core.results.DataResult;
import com.tobeto.bootcampProject.core.results.Result;
import com.tobeto.bootcampProject.core.results.SuccessDataResult;
import com.tobeto.bootcampProject.core.results.SuccessResult;
import com.tobeto.bootcampProject.core.results.mapping.ModelMapperService;
import com.tobeto.bootcampProject.dataacces.UserRepository;
import com.tobeto.bootcampProject.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private UserRepository userRepository;
    private ModelMapperService modelMapperService;

    @Override
    public DataResult<List<GetAllUserResponse>> getAll() {
        List<User> users = userRepository.findAll();
        List<GetAllUserResponse> response = users.stream()
                .map(user -> modelMapperService.forResponse()
                        .map(user, GetAllUserResponse.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<GetAllUserResponse>>(response,"All users are listed");
    }

    @Override
    public DataResult<GetByEmailUserResponse> getByEmail(String email) {
        User user = userRepository.findByEmail(email);
        GetByEmailUserResponse response = modelMapperService.forResponse()
                .map(user, GetByEmailUserResponse.class);
        return new SuccessDataResult<GetByEmailUserResponse>(response, "User is listed by email ");
    }

    @Override
    public DataResult<GetByIdUserResponse> getById(int id) {
        User user = userRepository.findById(id);
        GetByIdUserResponse response = modelMapperService.forResponse().map(user, GetByIdUserResponse.class);
        return new SuccessDataResult<GetByIdUserResponse>(response, "User is listed by id");
    }

    @Override
    public Result delete(int id) {
        userRepository.deleteById(id);
        return new SuccessResult("User is deleted");
    }
}
