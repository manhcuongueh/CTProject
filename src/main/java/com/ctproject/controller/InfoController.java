package com.ctproject.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ctproject.model.Account;
import com.ctproject.model.Order;
import com.ctproject.model.OrderDetail;
import com.ctproject.model.Product;
import com.ctproject.service.AccountService;
import com.ctproject.service.InfoService;
import com.ctproject.service.OrderDetailService;
import com.ctproject.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;


@RestController
@RequestMapping("/")
public class InfoController {
 
    @Autowired
    InfoService infoService;
     
    @Autowired
    AccountService accountService;
    
    @Autowired
    OrderService orderService;
    
    @Autowired
    OrderDetailService orderDetailService;
    
    String uniqueID = UUID.randomUUID().toString();
    
    
    //++++++++++++++++++++++++++++Product Area++++++++++++++++++++++++++++++++++++++++++++++++
    @RequestMapping(value = "/info/{code}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getSingleProduct(@PathVariable("code") String code) {
        System.out.println("Fetching Product with id " + code);
        Product product = infoService.findByCode(code);
        return product;
    }
    @RequestMapping(value = "/createorder", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public String createOrder(@RequestBody Order order) throws JsonProcessingException {
    	ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode x = objectMapper.createObjectNode();
        uniqueID=UUID.randomUUID().toString();
        System.out.println("Creating order infomation with id " + uniqueID);
        order.setId(uniqueID);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        order.setOrderDate(dateFormat.format(date));
        orderService.saveOrder(order);
         x.put("code",1000);
         x.put("message", "OK");
         
        return objectMapper.writeValueAsString(x);
    }
    @RequestMapping(value = "/createorderdetail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createOrderDetail(@RequestBody OrderDetail orderde) {
        System.out.println("Creating order detail infomation with id " + uniqueID);
        orderde.setId(uniqueID);
        
        orderDetailService.saveOrder(orderde);
    }
    @ResponseBody
	@RequestMapping(value = "/orders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> listOrder() {
        List<Order> order = orderService.getAllOrder();
        return order;
    }
    @ResponseBody
   	@RequestMapping(value = "/orderdetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
       public List<OrderDetail> OrderDetail(String id) {
           List<OrderDetail> orderDetail = orderDetailService.getOrderDetail(id);
           return orderDetail;
       }
    
    
        
	
	@ResponseBody
	@RequestMapping(value = "/info", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Product> listInfo() {
        List<Product> info = infoService.listInfo();
        return info;
    }
	
	@RequestMapping(value = "/deleteproduct", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteProduct(@RequestBody Product product) {
		infoService.delete(product);
    }
	
	@ResponseBody
	@RequestMapping(value = "/search/{str}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	    public List<Product> searchInfo(@PathVariable("str") String str) {
	        List<Product> search = infoService.searchInfo(str);
	        return search;
	    }
	
    //++++++++++++++++++++++++++++Account Area++++++++++++++++++++++++++++++++++++++++++
    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String Register(@RequestBody Account acc  ) throws JsonProcessingException {
    	System.out.println("Creating User " + acc.getEmail());
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode x = objectMapper.createObjectNode();
        if (accountService.isAccountExist(acc.getEmail())!=0) {
            System.out.println("A User with name " + acc.getEmail() + " already exist");
            
            x.put("code",-1000);
            x.put("message", "account exists");
            return objectMapper.writeValueAsString(x);
        }
 
        accountService.saveAccount(acc);
        
        int id=accountService.isAccountExist(acc.getEmail());
 
        x.put("code",1000);
        x.put("message", id);
        return objectMapper.writeValueAsString(x);
       }
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String Login(@RequestBody Account acc  ) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode x = objectMapper.createObjectNode();
        int id=accountService.login(acc.getEmail(), acc.getPassword());
        if (id!=0) {
            System.out.println("login success");
            
            x.put("code",1000);
            x.put("message", id  );
            return objectMapper.writeValueAsString(x);
        }
 
        else{
        	System.out.println("login fail");
        	x.put("code",-1000);
        	x.put("message","Account's not found");
        	return objectMapper.writeValueAsString(x);
        }
       }
    
    @RequestMapping(value = "/admin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String Admin(@RequestBody Account acc  ) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode x = objectMapper.createObjectNode();
        if (accountService.adminLogin(acc.getEmail(), acc.getPassword())) {
            System.out.println("login success");
            
            x.put("code",1000);
            x.put("message", "Login success");
            return objectMapper.writeValueAsString(x);
        }
 
        else{
        	System.out.println("login fail");
        	x.put("code",-1000);
        	x.put("message","Account's not found");
        	return objectMapper.writeValueAsString(x);
        }
       }
    @ResponseBody
	@RequestMapping(value = "/account", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Account> listAllAccount() {
        List<Account> accs = accountService.getAllAccount();
        return accs;
    }
    @RequestMapping(value = "/account/{accId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Account getSingleAccount(@PathVariable("accId") int accId) {
        System.out.println("Fetching Account with id " + accId);
        Account acc = accountService.findById(accId);
        return acc;
    }
    
    @RequestMapping(value = "/updateaccount", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String Update(@RequestBody Account acc  ) throws JsonProcessingException {
    	System.out.println("Updating Account " + acc.getEmail());
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode x = objectMapper.createObjectNode();
        int id=accountService.isAccountExist(acc.getEmail());
        System.out.println("Updating Account " + id);
        acc.setAccId(id);
        accountService.updateAccount(acc);;
        x.put("code",1000);
        x.put("message","SC_OK");
        return objectMapper.writeValueAsString(x);
    }
    @RequestMapping(value = "/deleteaccount/{accId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void  DeleteAccount(@PathVariable("accId") int accId) {
        accountService.deleteAccount(accId);
    }
 
}
