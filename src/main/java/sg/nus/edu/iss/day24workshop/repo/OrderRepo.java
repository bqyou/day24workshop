package sg.nus.edu.iss.day24workshop.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.nus.edu.iss.day24workshop.model.Order;

import static sg.nus.edu.iss.day24workshop.repo.Queries.*;

@Repository
public class OrderRepo {

    @Autowired
    JdbcTemplate template;

    public boolean insertOrder(Order o) {
        return template.update(INSERT_ORDER,
                o.getOrderId(),
                o.getCustomerName(),
                o.getShipAddress(),
                o.getNotes(),
                o.getTax()) > 0;
    }

}
