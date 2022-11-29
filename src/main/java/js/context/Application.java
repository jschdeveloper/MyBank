package js.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.beans.binding.ObjectExpression;
import js.services.TransactionService;

public class Application {

    public static final TransactionService transactionService = new TransactionService();

    public static final ObjectMapper objectMapper = new ObjectMapper();

}
