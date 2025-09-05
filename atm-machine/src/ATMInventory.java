import java.util.HashMap;
import java.util.Map;

public class ATMInventory {
    Map<CashType, Integer> cashInventory;

    public ATMInventory() {
        this.cashInventory = new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory() {
        cashInventory.put(CashType.BILL_100, 10);
        cashInventory.put(CashType.BILL_50, 10);
        cashInventory.put(CashType.BILL_20, 20);
        cashInventory.put(CashType.BILL_10, 30);
        cashInventory.put(CashType.BILL_5, 20);
        cashInventory.put(CashType.BILL_1, 50);
    }

    int getTotalCash() {
        int total=0;
        for(Map.Entry<CashType, Integer> entry: cashInventory.entrySet()) {
            total+=entry.getKey().value * entry.getValue();
        }
        return total;
    }

    boolean hasSufficientCash(int amount) {
        return getTotalCash() >= amount;
    }

    Map<CashType, Integer> dispenseCash(int amount){
        if (!hasSufficientCash(amount)) {
            return null;
        }

        Map<CashType, Integer> dispensedCash = new HashMap<>();
        int remainingAmount = amount;
        for (CashType cashType: CashType.values()) {
            int count = Math.min(remainingAmount/cashType.value, cashInventory.get(cashType));

            if (count > 0) {
                dispensedCash.put(cashType, count);
                remainingAmount-=count*cashType.value;
                cashInventory.put(cashType, cashInventory.get(cashType)-count);
            }
        }

        if (remainingAmount > 0) {
            for (Map.Entry<CashType, Integer> entry: dispensedCash.entrySet()) {
                cashInventory.put(entry.getKey(), cashInventory.get(entry.getKey()) + entry.getValue());
            }
            return null;
        }
        return dispensedCash;
    }

    public void addCash(CashType cashType,int count) {
        cashInventory.put(cashType, cashInventory.get(cashType)+count);
    }
}
