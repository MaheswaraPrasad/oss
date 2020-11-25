package com.vidin.inventory.orderLine;

public class OrderLine {
    private String order_line_id;
    private String parent_order_line_id;
    private String action;
    private String customer_agreed_date;
    private String service_address;
    private String product;

    @Override
    public String toString() {
        return "OrderLine: {" +
                "order_line_id:'" + order_line_id + '\'' +
                ", parent_order_line_id:'" + parent_order_line_id + '\'' +
                ", action:'" + action + '\'' +
                ", customer_agreed_date:'" + customer_agreed_date + '\'' +
                ", service_address:'" + service_address + '\'' +
                ", product:'" + product + '\'' +
                '}';
    }

    private OrderLine(String order_line_id, String parent_order_line_id, String action, String customer_agreed_date, String service_address, String product) {
        this.order_line_id = order_line_id;
        this.parent_order_line_id = parent_order_line_id;
        this.action = action;
        this.customer_agreed_date = customer_agreed_date;
        this.service_address = service_address;
        this.product = product;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getOrder_line_id() {
        return order_line_id;
    }

    public String getParent_order_line_id() {
        return parent_order_line_id;
    }

    public String getAction() {
        return action;
    }

    public String getCustomer_agreed_date() {
        return customer_agreed_date;
    }

    public String getService_address() {
        return service_address;
    }

    public String getProduct() {
        return product;
    }

    private OrderLine() {
    }


    public static class Builder {

        private String order_line_id;
        private String parent_order_line_id;
        private String action;
        private String customer_agreed_date;
        private String service_address;
        private String product;


        public Builder setOrder_line_id(String order_line_id) {
            this.order_line_id = order_line_id;
            return this;
        }

        public Builder setParent_order_line_id(String parent_order_line_id) {
            this.parent_order_line_id = parent_order_line_id;
            return this;
        }

        public Builder setAction(String action) {
            this.action = action;
            return this;
        }

        public Builder setCustomer_agreed_date(String customer_agreed_date) {
            this.customer_agreed_date = customer_agreed_date;
            return this;
        }

        public Builder setService_address(String service_address) {
            this.service_address = service_address;
            return this;
        }

        public Builder setProduct(String product) {
            this.product = product;
            return this;
        }

        public OrderLine build() {
            return new OrderLine(this.order_line_id, this.parent_order_line_id, this.action,
                    this.customer_agreed_date, this.service_address, this.product);
        }
    }
}
