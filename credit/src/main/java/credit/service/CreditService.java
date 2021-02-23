package credit.service;

import credit.model.Credit;
import credit.repository.CreditRepository;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class CreditService implements CreditRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public CreditService(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveCredit(Credit credit) {
        jdbcTemplate.update("insert into credit (creditname) values (:creditName)",
                new BeanPropertySqlParameterSource(credit));
    }
}
