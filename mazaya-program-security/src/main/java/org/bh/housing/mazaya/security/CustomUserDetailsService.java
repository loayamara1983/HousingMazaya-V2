package org.bh.housing.mazaya.security;

import org.bh.housing.mazaya.security.model.profiles.Profile;
import org.bh.housing.mazaya.security.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by tim.schwalbe
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

        @Autowired
        ProfileService profileService;

        /**
         * Returns a populated {@link UserDetails} object.
         * The username is first retrieved from the database and then mapped to
         * a {@link UserDetails} object.
         */
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                Profile domainUser = profileService.findByUsername(username);

                final boolean accountNonExpired = true;
                final boolean credentialsNonExpired = true;
                final boolean accountNonLocked = true;

                if (domainUser == null) {
                        throw new UsernameNotFoundException("User with name '" + username + "' not found in database");
                }

                return domainUser;
        }
}
