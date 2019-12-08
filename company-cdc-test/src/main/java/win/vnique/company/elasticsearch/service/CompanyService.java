package win.vnique.company.elasticsearch.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import win.vnique.company.elasticsearch.entity.Company;
import win.vnique.company.elasticsearch.repository.CompanyRepository;
import win.vnique.company.utils.Operation;

import java.util.Map;

/**
 * Service interface that masks the caller from the implementation that fetches / acts on Company
 * related data.
 *
 * @author Sohan
 */
@Service
public class CompanyService {

    /**
     * Handle to ElasticSearch
     */
    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    /**
     * Updates/Inserts/Delete company data.
     *
     * @param companyData
     * @param operation
     */
    public void maintainReadModel(Map<String, Object> companyData, Operation operation) {
        final ObjectMapper mapper = new ObjectMapper();
        final Company company = mapper.convertValue(companyData, Company.class);

        if (Operation.DELETE.equals(operation.code())) {
            companyRepository.deleteById(company.getId());
        } else {
            companyRepository.save(company);
        }
    }
}
