package quytn.eas.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quytn.eas.entity.BookStore;
import quytn.eas.repository.BookStoreRepository;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing BookStore.
 */
@Service
@Transactional
public class BookStoreService {

    private final Logger log = LoggerFactory.getLogger(BookStoreService.class);

    private final BookStoreRepository bookStoreRepository;


    public BookStoreService(BookStoreRepository bookStoreRepository) {
        this.bookStoreRepository = bookStoreRepository;
    }

    /**
     * Save a bookStore.
     *
     * @param bookStore the entity to save
     * @return the persisted entity
     */
    public BookStore save(BookStore bookStore) {
        log.debug("Request to save BookStore : {}", bookStore);
        BookStore result = bookStoreRepository.save(bookStore);
        return result;
    }

    /**
     * Get all the bookStores.
     *
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public List<BookStore> findAll() {
        log.debug("Request to get all BookStores");
        return bookStoreRepository.findAll();
    }


    /**
     * Get one bookStore by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<BookStore> findOne(Long id) {
        log.debug("Request to get BookStore : {}", id);
        return bookStoreRepository.findById(id);
    }

    /**
     * Delete the bookStore by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete BookStore : {}", id);
        if (bookStoreRepository.findById(id).isPresent()) {
            log.debug("Delete BookStore : {}", id);
            bookStoreRepository.deleteById(id);
        } else {
            log.debug("ID not exits to delete BookStore : {}", id);
        }
    }
}
