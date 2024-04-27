package com.hcl.hackton.helper;

public class Helper {

    public static String translateFiledName(String input) {

        switch (input) {
            case "customerId":
                return "customer_id";

            case "transcationRef":
                return "transcation_ref";

            case "instrumentId":
                return "instrument_id";

            case "instrumentName":
                return "instrument_name";

            case "tradeType":
                return "trade_type";

            case "auditDate":
                return "audit_date";
            default:
                return null;


        }
    }
}
