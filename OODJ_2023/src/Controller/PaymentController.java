/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Payment;
import Util.FileName;
import Util.SerializationUtil;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 */
public class PaymentController implements Controller {

    ArrayList<Payment> payments;
    private static PaymentController paymentController;

    public static PaymentController ActivatePaymentController() {
        if (PaymentController.paymentController == null) {
            PaymentController.paymentController = new PaymentController();
        }
        return PaymentController.paymentController;
    }

    PaymentController() {
        this.payments = new ArrayList<>();
        payments = (ArrayList<Payment>) SerializationUtil.readObjectFromFile(FileName.PAYMENT);
    }

    @Override
    public int getNewID() {
        return payments.size() + 1;
    }

    public ArrayList<Payment> getPayments() {
        return this.payments;
    }

    public ArrayList<Payment> getValidPayments() {
         return payments.stream()
                   .filter(payment -> !payment.isRefunded())
                   .collect(Collectors.toCollection(ArrayList::new));
    }

    public double getTotalSales() {
        double total = 0.0;
        ArrayList<Payment> validPayments = getValidPayments();
        for (Payment payment : validPayments) {
            System.out.println("payment id: " + payment.getPaymentID());
            System.out.println("payment: " + payment.getAmount());
            total += payment.getAmount();
        }
        return total;
    }

    public Payment getPaymentById(int id) {
        return payments.stream()
                .filter(Payment -> Payment.getPaymentID() == id)
                .findFirst()
                .orElse(null);
    }

    public Payment getPaymentByStudentID(int stuID) {
        return payments.stream()
                .filter(payment -> (payment.getStudent().getStudentID() == stuID))
                .findFirst()
                .orElse(null);
    }

    public <T> void add(Payment payment) {
        this.payments.add(payment);
        saveRecords();
    }

    public void update(Payment payment) {
        for (int i = 0; i < payments.size(); i++) {
            if (payments.get(i).getPaymentID() == payment.getPaymentID()) {
                payments.set(i, payment);
                break;
            }
        }
        saveRecords();
    }

    @Override
    public void saveRecords() {
        SerializationUtil.writeObjectToFile(this.payments, FileName.PAYMENT);
    }

    // Testing
//    public static void main(String[] args) {
//        PaymentController sc = paymentController.ActivatePaymentController();
//        sc.getPayments().forEach(payment -> {
//            System.out.println(payment.isRefunded());
//        });
//
//        System.out.println(sc.getPaymentById(1));
//        System.out.println(sc.getTotalSales());
//    }
}
