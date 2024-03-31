package com.projects.securecap.repository.implementation;

import com.projects.securecap.domain.User;
import com.projects.securecap.exception.ApiException;
import com.projects.securecap.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryImpl implements UserRepository<User> {
    private static final String COUNT_USER_EMAIL_QUERY = "``" ;
    public final NamedParameterJdbcTemplate jdbc;

    @Override
    public User create(User user) {
        //check the email is unique
        if(getEmailCount(user.getEmail().trim().toLowerCase()) > 0) throw new ApiException("Email already in use. Please use a different email  and try again");
        //save new user
        //Add role to user
        // send verification url
        //send url in verification table
        //send email to user with verification url
        //return the newly created user
        //if any errors, throw exception with proper message
        return null;

    }
    @Override
    public Collection<User> list(int page, int pageSize) {
        return null;
    }
    @Override
    public User get(Long id) {
        return null;
    }
    @Override
    public User update(User update) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }

    private Integer getEmailCount(String email) {
        return jdbc.queryForObject(COUNT_USER_EMAIL_QUERY, Map.of("email", email), Integer.class);


    }
}
