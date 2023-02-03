package sg.nus.edu.iss.day24workshop.model;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private String orderId;

    private Date orderDate;

    private String customerName;

    private String shipAddress;

    private String notes;

    private BigDecimal tax;

    private List<LineItem> lineItems = new LinkedList<LineItem>();

    public void addLineItem(LineItem i) {
        this.lineItems.add(i);
    }

}
