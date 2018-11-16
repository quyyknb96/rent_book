package quytn.eas.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quytn.eas.entity.Manager;
import quytn.eas.repository.ManagerRepository;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing Manager.
 */
@Service
@Transactional
public class ManagerService {

    private final Logger log = LoggerFactory.getLogger(ManagerService.class);

    private final ManagerRepository managerRepository;


    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    /**
     * Save a manager.
     *
     * @param manager the entity to save
     * @return the persisted entity
     */
    public Manager save(Manager manager) {
        log.debug("Request to save Manager : {}", manager);
        Manager result = managerRepository.save(manager);
        return result;
    }

    /**
     * Get all the managers.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<Manager> findAll() {
        log.debug("Request to get all Managers");
        return managerRepository.findAll();
    }


    /**
     * Get one manager by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<Manager> findOne(Long id) {
        log.debug("Request to get Manager : {}", id);
        return managerRepository.findById(id);
    }

    /**
     * Delete the manager by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Manager : {}", id);
        if (managerRepository.findById(id).isPresent()) {
            log.debug("Delete Manager : {}", id);
            managerRepository.deleteById(id);
        } else {
            log.debug("ID not exits to delete Manager : {}", id);
        }
    }

    public Optional<Manager> checkLogin(Manager manager){
        return managerRepository.findByUsernameAndPassword(manager.getUsername(), manager.getPassword());
    }
}
