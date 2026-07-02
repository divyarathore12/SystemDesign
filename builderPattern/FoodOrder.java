package builderPattern;

class Order {

    public String orderId;
    private String customerName;
    private Boolean extraCheese;
    private Boolean extraSpicy;
    private Boolean addColdDrink;
    private Boolean addDessert;
    private String couponCode;
    private String deliveryInstructions;
    private Boolean giftWrap;
    private Boolean priorityDelivery;

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Boolean getExtraCheese() {
        return extraCheese;
    }

    public Boolean getExtraSpicy() {
        return extraSpicy;
    }

    public Boolean getAddColdDrink() {
        return addColdDrink;
    }

    public Boolean getAddDessert() {
        return addDessert;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public String getDeliveryInstructions() {
        return deliveryInstructions;
    }

    public Boolean getGiftWrap() {
        return giftWrap;
    }

    public Boolean getPriorityDelivery() {
        return priorityDelivery;
    }

    private Order(OrderBuilder builder) {
        orderId = builder.orderId;
        customerName = builder.customerName;
        extraCheese = builder.extraCheese;
        extraSpicy = builder.extraSpicy;
        addColdDrink = builder.addColdDrink;
        addDessert = builder.addDessert;
        couponCode = builder.couponCode;
        deliveryInstructions = builder.deliveryInstructions;
        giftWrap = builder.giftWrap;
        priorityDelivery = builder.priorityDelivery;
    }
// When you pass object directly:

// System.out.println(order);

// Java internally does:

// System.out.println(order.toString());
// ❌ Without toString()

// Output becomes something like:

// Order@5acf9800

// Because default toString() from Object class runs.

// Default implementation roughly returns:

// ClassName@HashCode
// ✅ With Overridden toString()

// You control what gets printed.

// So output becomes:

// Order{orderId='12345', customerName='Divya', extraCheese=true}
     @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", extraCheese=" + extraCheese +
                ", extraSpicy=" + extraSpicy +
                ", addColdDrink=" + addColdDrink +
                ", addDessert=" + addDessert +
                ", couponCode='" + couponCode + '\'' +
                ", deliveryInstructions='" + deliveryInstructions + '\'' +
                ", giftWrap=" + giftWrap +
                ", priorityDelivery=" + priorityDelivery +
                '}';
    }

    public static class OrderBuilder {

        public String orderId;
        private String customerName;
        private Boolean extraCheese;
        private Boolean extraSpicy;
        private Boolean addColdDrink;
        private Boolean addDessert;
        private String couponCode;
        private String deliveryInstructions;
        private Boolean giftWrap;
        private Boolean priorityDelivery;

        public OrderBuilder setOrderId(String id) {
            this.orderId = id;
            return this;
        }

        public OrderBuilder setCustomerName(String name) {
            this.customerName = name;
            return this;
        }

        public OrderBuilder setExtraCheese(Boolean extraCheese) {
            this.extraCheese = extraCheese;
            return this;
        }

        public OrderBuilder setExtraSpicy(Boolean extraSpicy) {
            this.extraSpicy = extraSpicy;
            return this;
        }

        public OrderBuilder setAddColdDrink(Boolean addColdDrink) {
            this.addColdDrink = addColdDrink;
            return this;
        }

        public OrderBuilder setAddDessert(Boolean addDessert) {
            this.addDessert = addDessert;
            return this;
        }

        public OrderBuilder setCouponCode(String couponCode) {
            this.couponCode = couponCode;
            return this;
        }

        public OrderBuilder setDeliveryInstructions(String deliveryInstructions) {
            this.deliveryInstructions = deliveryInstructions;
            return this;
        }

        public OrderBuilder setGiftWrap(Boolean giftWrap) {
            this.giftWrap = giftWrap;
            return this;
        }

        public OrderBuilder setPriorityDelivery(Boolean priorityDelivery) {
            this.priorityDelivery = priorityDelivery;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}

public class FoodOrder {

    public static void main(String[] args) {

        Order.OrderBuilder orderBuilder = new Order.OrderBuilder();

        Order order = orderBuilder
                .setOrderId("12345")
                .setCustomerName("Divya")
                .setExtraCheese(true)
                .build();

        System.out.println(order);
    }
}