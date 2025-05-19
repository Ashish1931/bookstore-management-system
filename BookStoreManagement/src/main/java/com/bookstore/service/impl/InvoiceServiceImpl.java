package com.bookstore.service.impl;

import com.bookstore.entity.Order;
import com.bookstore.entity.OrderItem;
import com.bookstore.repository.OrderRepository;
import com.bookstore.service.InvoiceService;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void generateInvoice(HttpServletResponse response, Long orderId) throws IOException, DocumentException {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Document document = new Document();
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=invoice_" + orderId + ".pdf");

        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18, BaseColor.BLACK);
        Paragraph title = new Paragraph("Invoice for Order #" + orderId, fontTitle);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        document.add(new Paragraph("Customer: " + order.getUser().getUsername()));
        document.add(new Paragraph("Order Date: " + order.getOrderDate()));
        document.add(new Paragraph(" "));

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100f);
        table.setWidths(new float[]{4f, 1f, 2f});

        table.addCell(getCell("Book Title", true));
        table.addCell(getCell("Qty", true));
        table.addCell(getCell("Price", true));

        for (OrderItem item : order.getOrderItems()) {
            table.addCell(getCell(item.getBook().getTitle(), false));
            table.addCell(getCell(String.valueOf(item.getQuantity()), false));
            table.addCell(getCell(String.valueOf(item.getBook().getPrice()), false));
        }

        document.add(table);
        document.add(new Paragraph(" "));
        document.add(new Paragraph("Total Amount: $" + order.getTotalAmount()));
        document.add(new Paragraph("Thank you for your purchase!"));

        document.close();
    }

    private PdfPCell getCell(String text, boolean isHeader) {
        Font font = isHeader ? FontFactory.getFont(FontFactory.HELVETICA_BOLD) :
                               FontFactory.getFont(FontFactory.HELVETICA);
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setPadding(5);
        return cell;
    }
}
