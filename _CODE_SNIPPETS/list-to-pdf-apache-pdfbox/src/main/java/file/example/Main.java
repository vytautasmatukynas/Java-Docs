package file.example;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Order> orders = List.of(
                new Order("1", "Order1", "Client1", "123456789", "client1@example.com",
                        "Term1", "Pending", 100.50, "Comments1", "2023-01-01"),
                new Order("2", "Order2", "Client2", "987654321", "client2@example.com",
                        "Term2", "Completed", 200.75, "Comments2", "2023-02-01"));

        byte[] pdfOrders = getOrdersPdf(orders);

        saveToDesktopOrdersPdf(pdfOrders);
    }

    /**
     * Generates a PDF document based on a list of orders.
     *
     * @param orders The list of orders to include in the PDF.
     * @return The byte array representing the generated PDF.
     * @throws IOException If an I/O error occurs.
     */
    public static byte[] getOrdersPdf(List<Order> orders) throws IOException {
        // Try-with-resources statement ensures that each resource is closed at the end of the statement
        try (PDDocument document = new PDDocument()) {
            // Set an initial page size (A3)
            PDRectangle pageSize = PDRectangle.A3;
            // Create a new page with the specified size and add it to the document
            PDPage page = new PDPage(pageSize);
            document.addPage(page);

            // Create a content stream for adding content to the page
            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            // Set font for the document title
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 8);
            // Begin the text block and set the starting position for the title
            contentStream.beginText();
            contentStream.newLineAtOffset(20, pageSize.getHeight() - 20);
            // Show the text for the document title
            contentStream.showText("Orders Report");
            // End the text block
            contentStream.endText();

            // Draw table headers
            contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD), 8);
            float margin = 50;
            float yStart = pageSize.getHeight() - 50;
            float tableWidth = pageSize.getWidth() - 2 * margin;
            int cols = 10;
            float rowHeight = 20;
            float tableMarginTop = 50f;

            // Set the line width for drawing table borders
            contentStream.setLineWidth(1f);
            // Move to the starting position for the table and draw the top border
            contentStream.moveTo(margin, yStart - tableMarginTop);
            contentStream.lineTo(margin + tableWidth, yStart - tableMarginTop);
            contentStream.stroke();

            // Define fixed column widths
            float[] columnWidths = {40, 80, 60, 70, 100, 60, 70, 50, 80, 80};

            // Draw table content
            float tableYPosition = yStart - tableMarginTop - rowHeight;
            // Iterate through each order in the list
            for (Order order : orders) {
                tableYPosition -= rowHeight; // Move to the next row
                float nextX = margin; // Initial offset for the first cell
                // Iterate through each column in the row
                for (int i = 0; i < cols; i++) {
                    // Begin a new text block and set the position for the cell
                    contentStream.beginText();
                    contentStream.newLineAtOffset(nextX, tableYPosition - rowHeight / 2); // Adjusted y-position for centering text

                    // Show the text for the cell, obtained from the order and column index
                    contentStream.showText(getCellValue(order, i));
                    // End the text block
                    contentStream.endText();
                    nextX += columnWidths[i]; // Move to the next column
                }
            }

            // Close the content stream
            contentStream.close();

            // Save the document to a byte array
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            document.save(byteArrayOutputStream);

            // Return the byte array representing the generated PDF
            return byteArrayOutputStream.toByteArray();
        }
    }

    /**
     * Gets the cell value for a given order and column index.
     *
     * @param order       The order for which to retrieve the cell value.
     * @param columnIndex The index of the column in the table.
     * @return The cell value for the specified order and column.
     */
    private static String getCellValue(Order order, int columnIndex) {
        return switch (columnIndex) {
            case 0 -> order.getOrderNumber();
            case 1 -> order.getOrderName();
            case 2 -> order.getClientName();
            case 3 -> order.getClientPhoneNumber();
            case 4 -> order.getClientEmail();
            case 5 -> order.getOrderTerm();
            case 6 -> order.getOrderStatus();
            case 7 -> String.format("%.2f", order.getOrderPrice());
            case 8 -> order.getComments();
            case 9 -> order.getOrderUpdateDate();
            default -> "";
        };
    }

    /**
     * Saves the PDF byte array to the desktop.
     *
     * @param pdfOrders The byte array representing the PDF document.
     * @throws IOException If an I/O error occurs.
     */
    public static void saveToDesktopOrdersPdf(byte[] pdfOrders) throws IOException {
        // Get the current date in string format
        String dateNow = LocalDate.now().toString();

        // Get the current timestamp in string format
        String timeStamp = String.valueOf(System.currentTimeMillis());

        // Construct the file path on the desktop with a unique filename
        String desktopPathOrders = System.getProperty("user.home") +
                String.format("\\Desktop\\orders-%s-%s.pdf", dateNow, timeStamp);

        // Create a Path object for the file
        Path filePathOrders = Paths.get(desktopPathOrders);

        // Write the PDF byte array to the file on the desktop
        Files.write(filePathOrders, pdfOrders, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }
}