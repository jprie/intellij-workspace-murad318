import exception.OrderParsingException;

import java.util.Objects;

public class PaymentInfo {

    public static final String PAYED_BY_CC = "payed by cc";
    public static final String PAYED_BY_CASH = "payed by cash";
    public static final String OPEN = "open";

    public static PaymentInfo of(String info) throws OrderParsingException {

        return switch (info) {
            case OPEN -> new PaymentInfo(PaymentStatus.OPEN, PaymentMethod.UNKNOWN);
            case PAYED_BY_CC -> new PaymentInfo(PaymentStatus.PAYED, PaymentMethod.CREDIT_CARD);
            case PAYED_BY_CASH -> new PaymentInfo(PaymentStatus.PAYED, PaymentMethod.CASH);
            default -> throw new OrderParsingException("Payment info: " + info + " not parseable");
        };
    }

    enum PaymentStatus { OPEN, PAYED }
    enum PaymentMethod {CASH, CREDIT_CARD, UNKNOWN }

    private PaymentStatus status;
    private PaymentMethod method;

    public PaymentInfo(PaymentStatus status, PaymentMethod method) {
        this.status = status;
        this.method = method;
    }

    @Override
    public String toString() {
        return "PaymentInfo{" +
                "status=" + status +
                ", method=" + method +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentInfo that = (PaymentInfo) o;
        return status == that.status && method == that.method;
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, method);
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }
}
