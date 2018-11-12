package quytn.eas.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quytn.eas.entity.Details;
import quytn.eas.repository.DetailsRepository;

import java.util.List;
import java.util.Optional;


/**
 * Service Implementation for managing Details.
 */
@Service
@Transactional
public class DetailsService {

    private final Logger log = LoggerFactory.getLogger(DetailsService.class);

    private final DetailsRepository detailsRepository;


    public DetailsService(DetailsRepository detailsRepository) {
        this.detailsRepository = detailsRepository;
    }

    /**
     * Save a details.
     *
     * @param details the entity to save
     * @return the persisted entity
     */
    public Details save(Details details) {
        log.debug("Request to save Details : {}", details);
        Details result = detailsRepository.save(details);
        return result;
    }

    /**
     * Get all the details.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<Details> findAll() {
        log.debug("Request to get all Details");
        return detailsRepository.findAll();
    }


    /**
     * Get one details by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<Details> findOne(Long id) {
        log.debug("Request to get Details : {}", id);
        return detailsRepository.findById(id);
    }

    /**
     * Delete the details by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Details : {}", id);
        if (detailsRepository.findById(id).isPresent()) {
            log.debug("Delete Details : {}", id);
            detailsRepository.deleteById(id);
        } else {
            log.debug("ID not exits to delete Details : {}", id);
        }
    }
}
