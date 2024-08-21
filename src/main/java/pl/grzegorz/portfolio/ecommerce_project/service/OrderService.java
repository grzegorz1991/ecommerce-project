package pl.grzegorz.portfolio.ecommerce_project.service;

import pl.grzegorz.portfolio.ecommerce_project.model.LocalUser;
import pl.grzegorz.portfolio.ecommerce_project.model.WebOrder;
import pl.grzegorz.portfolio.ecommerce_project.model.dao.WebOrderDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private WebOrderDAO webOrderDAO;

    public OrderService(WebOrderDAO webOrderDAO) {
        this.webOrderDAO = webOrderDAO;
    }

    public List<WebOrder> getOrders(LocalUser user){
        return webOrderDAO.findByUser(user);
    }

}
