// using the default Spring Boot error handling mechanism to serve custom error pages for 404 and other errors.
// this can be used for handling errors if analytics tracking is needed for 404 errors and similar scenarios.



// package com.example.url_shortener.controller;

// import jakarta.servlet.RequestDispatcher;
// import jakarta.servlet.http.HttpServletRequest;
// import org.springframework.http.HttpStatus;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.boot.web.servlet.error.ErrorController;

// @Controller
// public class CustomErrorController implements ErrorController {

//     @Value("${app.frontend-url}")
//     private String frontendUrl;

//     @RequestMapping("/error")
//     public String handleError(HttpServletRequest request) {

//         Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

//         if (status != null) {
//             int statusCode = Integer.parseInt(status.toString());

//             if (statusCode == HttpStatus.NOT_FOUND.value()) {
//                 return "error/404";
//             }
//         }

//         return "error/error";
//     }
// }