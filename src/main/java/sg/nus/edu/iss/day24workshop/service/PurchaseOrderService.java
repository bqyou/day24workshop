package sg.nus.edu.iss.day24workshop.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.nus.edu.iss.day24workshop.model.Order;
import sg.nus.edu.iss.day24workshop.repo.LineItemRepo;
import sg.nus.edu.iss.day24workshop.repo.OrderRepo;
import sg.nus.edu.iss.exception.OrderException;

@Service
public class PurchaseOrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private LineItemRepo lineItemRepo;

    @Transactional(rollbackFor = OrderException.class)
    public void createPurchaseOrder(Order o) throws OrderException {
        String orderId = UUID.randomUUID().toString().substring(0, 8);
        o.setOrderId(orderId);
        orderRepo.insertOrder(o);

        // to test transactional to rollback if items > 4
        if (o.getLineItems().size() > 4) {
            throw new OrderException("PUNKED");
        }

        lineItemRepo.addItems(o.getLineItems(), orderId);
    }

}
