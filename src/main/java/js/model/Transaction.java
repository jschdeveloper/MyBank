package js.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class Transaction {

    @JsonProperty("transaction_id")
    String transactionId;

    @JsonProperty
    Integer amount;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty
    Timestamp date;

    @JsonProperty
    String references;

    public Transaction(Integer amount, Timestamp date, String references) {
        this.transactionId = UUID.randomUUID().toString();
        this.amount = amount;
        this.date = date;
        this.references = references;
    }

}
