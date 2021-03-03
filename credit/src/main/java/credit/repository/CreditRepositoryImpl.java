package credit.repository;

import credit.model.Credit;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CreditRepositoryImpl implements CreditRepository {

    private final JdbcTemplate jdbcTemplate;

    public CreditRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int save(Credit credit) {
        String sql = "insert into credit (CreditName) values(?)";
        return jdbcTemplate.update(sql, credit.getCreditName());
    }

    @Override
    public List<Credit> findAll() {
        String sql = "select * from credit";
        return jdbcTemplate.query(sql,
                (rs, rowNum) ->
                        new Credit(
                                rs.getInt("id"),
                                rs.getString("creditName")
                        ));
    }

    @Override
    public int nextID() {
        String sql = "SELECT MAX(ID) FROM credit;";
        if (jdbcTemplate.queryForObject(sql, Integer.class) == null) {
            return 1;
        }
        return jdbcTemplate.queryForObject(sql, Integer.class)+1;
    }
}