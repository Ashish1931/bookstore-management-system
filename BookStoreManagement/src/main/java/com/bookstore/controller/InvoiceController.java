package com.bookstore.controller;

import com.bookstore.service.InvoiceService;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/{orderId}")
    public void downloadInvoice(@PathVariable Long orderId, HttpServletResponse response) throws IOException, DocumentException {
        invoiceService.generateInvoice(response, orderId);
    }
}
