package quytn.eas.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quytn.eas.entity.Rent;
import quytn.eas.repository.RentRepository;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing Rent.
 */
@Service
@Transactional
public class RentService {

    private final Logger log = LoggerFactory.getLogger(RentService.class);

    private final RentRepository rentRepository;

    public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    /**
     * Save a rent.
     *
     * @param rent the entity to save
     * @return the persisted entity
     */
    public Rent save(Rent rent) {
        log.debug("Request to save Rent : {}", rent);
        Rent result = rentRepository.save(rent);
        return result;
    }

    /**
     * Get all the rents.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<Rent> findAll() {
        log.debug("Request to get all Rents");
        return rentRepository.findAll();
    }


    /**
     * Get one rent by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<Rent> findOne(Long id) {
        log.debug("Request to get Rent : {}", id);
        return rentRepository.findById(id);
    }

    /**
     * Delete the rent by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Rent : {}", id);
        if (rentRepository.findById(id).isPresent()) {
            log.debug("Delete Rent : {}", id);
            rentRepository.deleteById(id);
        } else {
            log.debug("ID not exits to delete Rent : {}", id);
        }
    }
}
