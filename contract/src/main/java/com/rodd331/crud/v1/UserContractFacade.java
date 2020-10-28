package com.rodd331.crud.v1;

import com.rodd331.crud.impl.facade.UserFacade;
import com.rodd331.crud.v1.model.request.UserRequest;
import com.rodd331.crud.v1.model.response.UserListResponse;
import com.rodd331.crud.v1.model.response.UserResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import static com.rodd331.crud.v1.mapper.UserContractMapper.mapToContract;
import static com.rodd331.crud.v1.mapper.UserContractMapper.mapToImpl;
import static com.rodd331.crud.v1.mapper.UserListMapper.mapUserListToResponse;

@Component
@AllArgsConstructor
public class UserContractFacade {

    private final UserFacade userFacade;

    UserResponse create(UserRequest user) {
        return mapToContract(userFacade.create(mapToImpl(user)));
    }

    UserListResponse allUsers(int page) {
        return mapUserListToResponse(userFacade.allUsers(page));
    }

    UserResponse findById(String id) {
        return mapToContract(userFacade.findById(id));
    }

    UserResponse update(UserRequest user, String id) {
        return mapToContract(userFacade.update(mapToImpl(user), id));
    }

    void delete(String id) {
        userFacade.delete(id);
    }
}