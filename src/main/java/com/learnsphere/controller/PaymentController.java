package com.learnsphere.controller;



import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learnsphere.entity.Course;
import com.learnsphere.repository.CourseRepository;
import com.learnsphere.repository.PaymentRepository;
import com.razorpay.Order;
import com.learnsphere.entity.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Controller
public class PaymentController {
		
	@Autowired
	CourseRepository courseRepo;

		@RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
		public String productDetail(@PathVariable("id") int courseId,Model model) {
			Course course = courseRepo.findById(courseId).get();
			int coursePrice = course.getCoursePrice();
			int course1=course.getCourseId();
			model.addAttribute("course",coursePrice);
			model.addAttribute("courseId",courseId);
		    System.out.println("Course Id: " + course1);

		    return "payment";
		}
	@SuppressWarnings("finally")
	@PostMapping("/createOrder")
	@ResponseBody
	public String createOrder(@RequestParam("amount")int amount) {
		System.out.println(amount);
		Order order=null;
		try {
				RazorpayClient razorpay = new RazorpayClient("rzp_test_edbf4klUScbdgs", "RlmJUtTYQ2YxC1MDkwRJVI6s");
			  JSONObject orderRequest = new JSONObject();
			  orderRequest.put("amount", amount*100); // amount in the smallest currency unit
			  orderRequest.put("currency", "INR");
			  orderRequest.put("receipt", "order_rcptid_11");

			   order = razorpay.orders.create(orderRequest);
			} catch (RazorpayException e) {
			  // Handle Exception
			  System.out.println(e.getMessage());
			}
			finally {
				return order.toString();
			}
	}
	
	
	
	@Autowired
    private PaymentRepository paymentRepository;

    // ...

    @PostMapping("/verify")
    @ResponseBody
    public String verifyPayment(@RequestParam("orderId") String orderId,
                                 @RequestParam("paymentId") String paymentId,
                                 @RequestParam("signature") String signature) {
    	System.out.println(orderId+" "+paymentId+" "+signature);
    	Payment p = new Payment(paymentId, orderId, signature);
    	paymentRepository.save(p);
    	
      return "redirect:/myCourses";
     
 
    }

	



}
