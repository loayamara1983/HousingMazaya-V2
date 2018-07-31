package org.bh.housing.mazaya.security.model.profiles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 
 * @author Loay
 *
 */
public interface ProfileRepository extends JpaRepository<Profile, Long> {

        @Transactional
        List<Profile> findByEmailAndLastName(String email, String lastName);

        @Transactional
        Profile findByUsername(String username);

        @Transactional
        Profile findByEmail(String email);


        @Transactional
        Optional<Profile> findById(Long id);

        @Transactional
        List<Profile> findAll();
}
