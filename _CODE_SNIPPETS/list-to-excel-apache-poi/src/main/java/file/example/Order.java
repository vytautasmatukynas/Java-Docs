package file.example;

public class Order {
    private String orderNumber;
    private String orderName;
    private String clientName;
    private String clientPhoneNumber;
    private String clientEmail;
    private String orderTerm;
    private String orderStatus;
    private double orderPrice;
    private String comments;
    private String orderUpdateDate;

    public Order(String orderNumber, String orderName, String clientName,
                    String clientPhoneNumber, String clientEmail, String orderTerm,
                    String orderStatus, double orderPrice, String comments, String orderUpdateDate) {
        this.orderNumber = orderNumber;
        this.orderName = orderName;
        this.clientName = clientName;
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientEmail = clientEmail;
        this.orderTerm = orderTerm;
        this.orderStatus = orderStatus;
        this.orderPrice = orderPrice;
        this.comments = comments;
        this.orderUpdateDate = orderUpdateDate;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getOrderTerm() {
        return orderTerm;
    }

    public void setOrderTerm(String orderTerm) {
        this.orderTerm = orderTerm;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getOrderUpdateDate() {
        return orderUpdateDate;
    }

    public void setOrderUpdateDate(String orderUpdateDate) {
        this.orderUpdateDate = orderUpdateDate;
    }
}
