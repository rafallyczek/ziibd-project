package ziibd.project.country;

import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer> {

    public Country findById(String id);

    public void deleteById(String id);

}
