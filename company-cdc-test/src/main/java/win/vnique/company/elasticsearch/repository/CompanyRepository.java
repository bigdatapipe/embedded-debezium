package win.vnique.company.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import win.vnique.company.elasticsearch.entity.Company;

/**
 * This interface provides handles to database, to perform CRUD operations on the index `STUDENT`.
 * The index is represented by the JPA entity {@link Company}.
 *
 * @author Sohan
 * @see ElasticsearchRepository
 */
@Repository
public interface CompanyRepository extends ElasticsearchRepository<Company, Integer> {
}
