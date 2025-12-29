package com.soft.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

@Controller
public class PaymentController {

    @Value("${razorpay.key_id}")
    private String keyId;

    @Value("${razorpay.key_secret}")
    private String keySecret;

    @Value("${razorpay.success.url}")
    private String successUrl;

    // Home page
    @GetMapping("/")
    public String home() {
        return "index";
    }

    // Create Payment Link
    @GetMapping("/payment/create")
    public RedirectView createPaymentLink() {
        try {
            RazorpayClient client = new RazorpayClient(keyId, keySecret);
            JSONObject request = new JSONObject();
            request.put("amount",  100); 
            request.put("currency", "INR");
            request.put("callback_url", successUrl);
            request.put("callback_method", "get");

            PaymentLink link = client.paymentLink.create(request);
            return new RedirectView(link.get("short_url"));

        } catch (Exception e) {
            e.printStackTrace();
            return new RedirectView("/payment/cancel");
        }
    }

    // Payment Success
    @GetMapping("/payment/success")
    public String paymentSuccess(HttpServletRequest request) {
        String status = request.getParameter("razorpay_payment_link_status");
        if ("paid".equalsIgnoreCase(status)) {
            return "success";
        }
        return "cancel";
    }

    // Payment Cancel/Error
    @GetMapping("/payment/cancel")
    public String paymentCancel() {
        return "cancel";
    }
}
