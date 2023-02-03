package sg.nus.edu.iss.day24workshop.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import sg.nus.edu.iss.day24workshop.model.LineItem;
import sg.nus.edu.iss.day24workshop.model.Order;

@Controller
@RequestMapping(path = "/cart")
public class CartController {

    @PostMapping
    public String postCart(@RequestBody MultiValueMap<String, String> form, Model model,
            HttpSession sess) {
        List<LineItem> lineItems = (List<LineItem>) sess.getAttribute("cart");
        if (lineItems == null) {
            lineItems = new LinkedList();
            sess.setAttribute("cart", lineItems);
        }
        String item = form.getFirst("item");
        Integer quantity = Integer.parseInt(form.getFirst("quantity"));
        lineItems.add(new LineItem(item, quantity));
        Order o = new Order();
        o.setCustomerName(form.getFirst("name"));
        o.setLineItems(lineItems);
        sess.setAttribute("checkout", o);
        model.addAttribute("lineItems", lineItems);
        return "cart";
    }

}
