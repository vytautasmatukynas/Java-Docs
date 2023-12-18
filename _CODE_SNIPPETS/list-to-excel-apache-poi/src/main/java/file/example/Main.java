package file.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Order> orders = new ArrayList<>();

        orders.add(new Order("1", "Order1", "Client1", "123456789", "client1@example.com",
                "Term1", "Pending", 100.50, "Comments1", "2023-01-01"));
        orders.add(new Order("2", "Order2", "Client2", "987654321", "client2@example.com",
                "Term2", "Completed", 200.75, "Comments2", "2023-02-01"));

        byte[] excelOrders = getOrdersWorkbook(orders);

        saveToDesktopOrdersExcel(excelOrders);
    }

    /**
     * Converts a list of orders into a byte array representing an Excel file.
     *
     * @param orders The list of orders to include in the Excel file.
     * @return A byte array representing the Excel file content.
     * @throws IOException If an I/O error occurs while creating the Excel file.
     */
    public static byte[] getOrdersWorkbook(List<Order> orders) throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Orders");

            Row headerRow = sheet.createRow(0);

            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerStyle.setFont(headerFont);
            headerStyle.setBorderTop(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);

            // Create header cells
            String[] cellHeaders = {"Order No.", "Order Name", "Client Name", "Phone Number", "Email",
                    "Term", "Status", "Order Price, €", "Comments", "Updated"};

            for (int i = 0; i < cellHeaders.length; i++) {
                Cell headerCell = headerRow.createCell(i);
                headerCell.setCellValue(cellHeaders[i]);
                headerCell.setCellStyle(headerStyle);
            }

            // Track the maximum width for each column
            int[] columnWidths = new int[cellHeaders.length];

            // Fill data rows and calculate maximum column widths
            for (int i = 0; i < orders.size(); i++) {
                Order order = orders.get(i);
                Row row = sheet.createRow(i + 1);

                for (int j = 0; j < cellHeaders.length; j++) {
                    Cell cell = row.createCell(j);
                    String cellValue = "";

                    // Switch statement to handle different columns
                    switch (j) {
                        case 0 -> cellValue = order.getOrderNumber();
                        case 1 -> cellValue = order.getOrderName();
                        case 2 -> cellValue = order.getClientName();
                        case 3 -> cellValue = order.getClientPhoneNumber();
                        case 4 -> cellValue = order.getClientEmail();
                        case 5 -> cellValue = order.getOrderTerm();
                        case 6 -> cellValue = order.getOrderStatus();
                        case 7 -> cellValue = String.format("%.2f", order.getOrderPrice());
                        case 8 -> cellValue = order.getComments();
                        case 9 -> cellValue = order.getOrderUpdateDate();
                    }

                    cell.setCellValue(cellValue);

                    CellStyle dataCellStyle = workbook.createCellStyle();
                    dataCellStyle.setBorderTop(BorderStyle.THIN);
                    dataCellStyle.setBorderBottom(BorderStyle.THIN);
                    dataCellStyle.setBorderLeft(BorderStyle.THIN);
                    dataCellStyle.setBorderRight(BorderStyle.THIN);
                    cell.setCellStyle(dataCellStyle);

                    // Calculate the cell length and update column width if necessary
                    int cellLength = (cellValue.length() + 10) * 256;
                    if (cellLength > columnWidths[j]) {
                        columnWidths[j] = cellLength;
                    }
                }
            }

            // Set column widths based on the maximum widths
            for (int i = 0; i < cellHeaders.length; i++) {
                sheet.setColumnWidth(i, columnWidths[i]);
            }

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            workbook.write(byteArrayOutputStream);

            return byteArrayOutputStream.toByteArray();
        }
    }

    /**
     * Saves the given Excel content representing orders data to the user's desktop.
     *
     * @param excelOrders A byte array representing the content of the Excel file for orders.
     * @throws IOException If an I/O error occurs while saving the Excel file.
     */
    public static void saveToDesktopOrdersExcel(byte[] excelOrders) throws IOException {
        String dateNow = LocalDate.now().toString();
        String timeStamp = String.valueOf(System.currentTimeMillis());

        String desktopPathOrders = System.getProperty("user.home") +
                String.format("\\Desktop\\orders-%s-%s.xlsx",
                        dateNow,
                        timeStamp);

        Path filePathOrders = Paths.get(desktopPathOrders);

        Files.write(filePathOrders,
                excelOrders,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING);
    }

}