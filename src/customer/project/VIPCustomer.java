package customer.project;

public class VIPCustomer extends Customer{

    private int agentID; //상담원 ID
    double saleRatio; // 할인율

    public VIPCustomer(int customerId, String customerName, int agentID) {
        super(customerId, customerName);

        super.customerGrade = "VIP";
        super.bonusRatio = 0.05;
        this.saleRatio = 0.1;
        this.agentID = agentID;
    }

    public int calcPrice(int price) {
        bonusPoint += price * bonusRatio;
        return price - (int)(price * saleRatio);
    }

    public String showCustomerInfo() {
        return super.showCustomerInfo() + ", 담당 상담원 ID: " + agentID;
    }

    public int getAgentID() {
        return agentID;
    }

    public void setAgentID(int agentID) {
        this.agentID = agentID;
    }
}
