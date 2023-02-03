package sg.nus.edu.iss.day24workshop.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.nus.edu.iss.day24workshop.model.LineItem;

import static sg.nus.edu.iss.day24workshop.repo.Queries.*;

@Repository
public class LineItemRepo {

    @Autowired
    JdbcTemplate template;

    // public boolean addItems(LineItem i) {
    // return template.update(INSERT_LINEITEM,
    // i.getProduct(),
    // i.getUnitPrice(),
    // i.getDiscount(),
    // i.getOrderId(),
    // i.getQuantity()) > 0;

    // }

    public void addItems(List<LineItem> lineItems, String orderId) {
        List<Object[]> arrData = lineItems.stream()
                .map(li -> {
                    Object[] l = new Object[5];
                    l[0] = li.getProduct();
                    l[1] = li.getQuantity();
                    l[2] = orderId;
                    l[3] = li.getUnitPrice();
                    l[4] = li.getDiscount();
                    return l;
                }).toList();

        template.batchUpdate(INSERT_LINEITEM, arrData);
    }

}
