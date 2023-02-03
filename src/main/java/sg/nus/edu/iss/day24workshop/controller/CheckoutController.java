package sg.nus.edu.iss.day24workshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import sg.nus.edu.iss.day24workshop.model.LineItem;
import sg.nus.edu.iss.day24workshop.model.Order;
import sg.nus.edu.iss.day24workshop.service.PurchaseOrderService;
import sg.nus.edu.iss.exception.OrderException;

@Controller
@RequestMapping(path = "/checkout")
public class CheckoutController {

    @Autowired
    private PurchaseOrderService orderSvc;

    @PostMapping
    public String confirmCheckout(Model model, HttpSession sess) throws OrderException {
        List<LineItem> items = (List<LineItem>) sess.getAttribute("cart");
        Order o = (Order) sess.getAttribute("checkout");
        orderSvc.createPurchaseOrder(o);
        sess.invalidate();
        model.addAttribute("total", items.size());

        return "checkout";

    }
}
