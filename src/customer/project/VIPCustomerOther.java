package customer.project;

public class VIPCustomerOther extends Customer{
        double saleRatio; // 할인율

        public VIPCustomerOther(int customerId, String customerName) {
            super(customerId, customerName);

            super.customerGrade = "VIP";
            super.bonusRatio = 0.03;
            this.saleRatio = 0.2;
        }

        public int calcPrice(int price) {
            bonusPoint += price * bonusRatio;
            return price - (int)(price * saleRatio);
        }

        public String showCustomerInfo() {
            return super.showCustomerInfo();
        }




}
