package com.projects.securecap.repository.implementation;

import com.projects.securecap.domain.Role;
import com.projects.securecap.domain.User;
import com.projects.securecap.exception.ApiException;
import com.projects.securecap.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

import static com.projects.securecap.enumeration.RoleType.ROLE_USER;
import static com.projects.securecap.query.UserQuery.*;
import static java.util.Objects.requireNonNull;
import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryImpl implements UserRepository<User> {

    private final NamedParameterJdbcTemplate jdbc;
    private final RoleRepository<Role> roleRepository;

    //to encode password. we cant store the raw password in db;
    private final BCryptPasswordEncoder encoder;

    @Override
    public User create(User user) {
        //check the email is unique
        if(getEmailCount(user.getEmail().trim().toLowerCase()) > 0) throw new ApiException("Email already in use. Please use a different email  and try again");
        //save new user
        try{
            KeyHolder holder = new GeneratedKeyHolder();
            SqlParameterSource parameters = getSqlParameterSource(user);
            jdbc.update(INSERT_USER_QUERY, parameters, holder);
            user.setId(requireNonNull(holder.getKey()).longValue());
            //Add role to user
            roleRepository.addRoleToUser(user.getId(), ROLE_USER.name());

            // send verification url
            String verficationUrl = getVerificationUrl(UUID.randomUUID().toString(), ACCOUNT.getType());

            //send url in verification table
            //send email to user with verification url
            //return the newly created user
            //if any errors, throw exception with proper message
        }
        catch (EmptyResultDataAccessException exception)
        {

        } catch (Exception exception){

        }

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
    private SqlParameterSource getSqlParameterSource(User user) {

        return new MapSqlParameterSource()
                .addValue("firstName", user.getFirstName())
                .addValue("lastName", user.getLastName())
                .addValue("email", user.getEmail())
                .addValue("password", encoder.encode(user.getPassword()));
    }

    private getVerificationUrl(String key, ACCOUNT.getType());

}
