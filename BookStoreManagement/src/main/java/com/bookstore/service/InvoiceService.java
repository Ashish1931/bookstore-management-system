package com.bookstore.service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.itextpdf.text.DocumentException;

public interface InvoiceService {
    void generateInvoice(HttpServletResponse response, Long orderId) throws IOException, DocumentException;
}
