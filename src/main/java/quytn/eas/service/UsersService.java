package quytn.eas.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quytn.eas.entity.Users;
import quytn.eas.repository.UsersRepository;

import java.util.List;
import java.util.Optional;


/**
 * Service Implementation for managing Users.
 */
@Service
@Transactional
public class UsersService {

    private final Logger log = LoggerFactory.getLogger(UsersService.class);

    private final UsersRepository usersRepository;


    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    /**
     * Save a users.
     *
     * @param users the entity to save
     * @return the persisted entity
     */
    public Users save(Users users) {
        log.debug("Request to save Users : {}", users);
        Users result = usersRepository.save(users);
        return result;
    }

    /**
     * Get all the users.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<Users> findAll() {
        log.debug("Request to get all Users");
        return usersRepository.findAll();
    }


    /**
     * Get one users by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<Users> findOne(Long id) {
        log.debug("Request to get Users : {}", id);
        return usersRepository.findById(id);
    }

    /**
     * Delete the users by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Users : {}", id);
        if (usersRepository.findById(id).isPresent()) {
            log.debug("Delete Users : {}", id);
            usersRepository.deleteById(id);
        } else {
            log.debug("ID not exits to delete Users : {}", id);
        }
    }
}
